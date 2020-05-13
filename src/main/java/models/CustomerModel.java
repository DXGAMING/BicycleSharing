package models;

import javax.persistence.*;


@Entity
@Table(name = "customers")
public class CustomerModel extends UserModel
{
	public CustomerModel()
	{
	}



	@Override
	public void setPassword(String password)
	{
		super.setPassword(password);
	}

	@Override
	public void setName(String name)
	{
		super.setName(name);
	}

	@Override
	public void setSurname(String surname)
	{
		super.setSurname(surname);
	}

	@Override
	public void setPhone(String phone)
	{
		super.setPhone(phone);
	}

	@Override
	public void setPassportId(String passportId)
	{
		super.setPassportId(passportId);
	}

	@Column(name = "customerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Override
	public void setPersonalCode(long personalCode)
	{
		super.setPersonalCode(personalCode);
	}

	@Column
	@Override
	public String getName()
	{
		return super.getName();
	}

	@Column
	@Override
	public String getSurname()
	{
		return super.getSurname();
	}
	@Column
	@Override
	public String getPhone()
	{
		return super.getPhone();
	}

	@Column
	@Override
	public String getPassportId()
	{
		return super.getPassportId();
	}


	@Column
	@Override
	public String getPassword()
	{
		return super.getPassword();
	}

	@Id

	@Column(name = "customerid")
	@Override
	public long getPersonalCode()
	{
		return super.getPersonalCode();
	}
}
