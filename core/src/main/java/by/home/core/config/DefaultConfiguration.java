package by.home.core.config;

public class DefaultConfiguration implements Configuration{	
	private Long screenSwitchOffTimeout;
	private Long screenSwitchOnTimeout;
	private Long screenLowPowerTimeout;
	private Long workstationLockTimeout;
	
	public void setScreenSwitchOffTimeout(Long screenSwitchOffTimeout) {
		this.screenSwitchOffTimeout = screenSwitchOffTimeout;
	}

	public void setScreenSwitchOnTimeout(Long screenSwitchOnTimeout) {
		this.screenSwitchOnTimeout = screenSwitchOnTimeout;
	}

	public void setScreenLowPowerTimeout(Long screenLowPowerTimeout) {
		this.screenLowPowerTimeout = screenLowPowerTimeout;
	}

	public void setWorkstationLockTimeout(Long workstationLockTimeout) {
		this.workstationLockTimeout = workstationLockTimeout;
	}

	@Override
	public Long getScreenSwitchOffTimeout() {
		return screenSwitchOffTimeout;
	}

	@Override
	public Long getScreenSwitchOnTimeout() {
		return screenSwitchOnTimeout;
	}

	@Override
	public Long getScreenLowPowerTimeout() {
		return screenLowPowerTimeout;
	}
 
	@Override
	public Long getWorkstationLockTimeout() {
		return workstationLockTimeout;
	}
	
}
