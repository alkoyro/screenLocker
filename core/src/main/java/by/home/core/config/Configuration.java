package by.home.core.config;

public interface Configuration {
	public static final String PROPERTY_SCREEN_LOW_POWER = "screenLowPowerTimeout";
	public static final String PROPERTY_SCREEN_SWITCH_OFF = "screenSwitchOffTimeout";
	public static final String PROPERTY_SCREEN_SWITCH_ON = "screenSwitchOnTimeout";
	public static final String PROPERTY_WORKSTATION_LOCK = "workstationLockTimeout";
	
	public Long getScreenSwitchOffTimeout();
	public Long getScreenSwitchOnTimeout();
	public Long getScreenLowPowerTimeout();
	public Long getWorkstationLockTimeout();
}
