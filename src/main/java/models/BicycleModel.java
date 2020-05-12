package models;

import constants.MainConstants.BicycleType;
import constants.MainConstants.BicycleSize;


public class BicycleModel extends AbstractModel
{
	private String model;
	private BicycleSize size;
	private BicycleType type;
	private double pricePerHour;

	public String getModel()
	{
		return model;
	}

	public void setModel(final String model)
	{
		this.model = model;
	}

	public BicycleSize getSize()
	{
		return size;
	}

	public void setSize(final BicycleSize size)
	{
		this.size = size;
	}

	public BicycleType getType()
	{
		return type;
	}

	public void setType(final BicycleType type)
	{
		this.type = type;
	}

	public double getPricePerHour()
	{
		return pricePerHour;
	}

	public void setPricePerHour(final double pricePerHour)
	{
		this.pricePerHour = pricePerHour;
	}
}
