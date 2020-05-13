package constants;

import javax.persistence.Embeddable;



public final  class MainConstants
{

	public static final String DELIMITER = "\\|";
	@Embeddable
	public static class BicycleSize
	{
		public static final String SMALL = "SMALL".intern();
		public static final String MIDDLE = "MIDDLE".intern();
		public static final String LARGE = "LARGE".intern();
	}

	@Embeddable
	public static class BicycleType
	{
		public static final String MOUNTAIN = "MOUNTAIN".intern();
		public static final String TRACK = "TRACK".intern();
		public static final String HYBRID = "HYBRID".intern();
		public static final String BMX = "BMX".intern();
	}

}
