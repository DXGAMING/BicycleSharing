package facades.impl;

import facades.UserCreationFacade;
import models.AbstractModel;
import models.AdminModel;
import models.CustomerModel;
import models.UserModel;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;
import services.ModelService;


import java.util.HashMap;
import java.util.Map;

import static constants.MainConstants.DELIMITER;


public class UserCreationFacadeImpl implements UserCreationFacade
{
	private IdGenerator idGenerator;
	private ModelService<UserModel> modelService;

	public UserCreationFacadeImpl()
	{
		idGenerator = new SimpleIdGenerator();
		modelService = new ModelService<>();
	}

	@Override
	public void createUser(final boolean isAdmin, final String userData)
	{
		Map<String, String> fields = parseUserData(userData);
		if (isAdmin)
		{
			UserModel admin = new AdminModel();
			admin.setName(fields.get("name"));
			admin.setSurname(fields.get("surname"));
			admin.setPhone(fields.get("phone"));
			admin.setPassportId(fields.get("passportId"));
			admin.setPassword(fields.get("password"));
			modelService.save(admin);
		}
		else
		{
			CustomerModel customer = new CustomerModel();
			customer.setName(fields.get("name"));
			customer.setSurname(fields.get("surname"));
			customer.setPhone(fields.get("phone"));
			customer.setPassportId(fields.get("passportId"));
			customer.setPassword(fields.get("password"));
			modelService.save(customer);

		}
	}

	/**
	 * Single string with UserModel fields separated by symbol
	 *
	 * @param userData
	 * @return
	 */
	private Map<String, String> parseUserData(final String userData)
	{
		String[] keys = { "name", "surname", "phone", "passportId", "password" };
		String[] userDataToParse = userData.split(DELIMITER);
		Map<String, String> values = new HashMap<>();
		for (int i = 0; i < keys.length; i++)
		{
			values.put(keys[i], userDataToParse[i]);
		}
		return values;
	}

	public void setModelService(final ModelService<UserModel> modelService)
	{
		this.modelService = modelService;
	}

	public void setIdGenerator(final IdGenerator idGenerator)
	{
		this.idGenerator = idGenerator;
	}
}
