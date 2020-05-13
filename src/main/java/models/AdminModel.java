package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "admins")
public class AdminModel extends UserModel
{
	public AdminModel()
	{
	}

	@Column
	@Override
	public String getPassword()
	{
		return super.getPassword();
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

	@Id
	@Override
	public long getPersonalCode()
	{
		return super.getPersonalCode();
	}
}
