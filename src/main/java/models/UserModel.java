package models;


public abstract class UserModel extends AbstractModel
{

	private String name;
	private String surname;
	private String phone;
	private String passportId;


	public String getName()
	{
		return name;
	}


	public void setName(final String name)
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(final String surname)
	{
		this.surname = surname;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public String getPassportId()
	{
		return passportId;
	}

	public void setPassportId(final String passportId)
	{
		this.passportId = passportId;
	}

}
