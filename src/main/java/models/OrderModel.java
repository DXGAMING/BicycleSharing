package models;

import javax.annotation.Resource;
import java.util.Date;


public class OrderModel extends AbstractModel
{
	@Resource(name = "bicycleModel")
	private BicycleModel bicycle;

	@Resource(name = "customerModel")
	private CustomerModel customer;

	@Resource(name = "adminModel")
	private AdminModel admin;

	private double discountAmount;

	public double getDiscountAmount()
	{
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount)
	{
		this.discountAmount = discountAmount;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	private Date startDate;
	private Date endDate;
	public BicycleModel getBicycle()
	{
		return bicycle;
	}

	public CustomerModel getCustomer()
	{
		return customer;
	}

}
