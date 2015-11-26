package by.home.console;

import com.beust.jcommander.Parameter;

import by.home.core.config.Configuration;

public class LockerConfiguration implements Configuration {
	@Parameter(names = { "-switchOff", "-off" })
	private Long screenSwitchOffTimeout;
	@Parameter(names = { "-switchOn", "-on" })
	private Long screenSwitchOnTimeout;
	@Parameter(names = { "-lowPower", "-lp" })
	private Long screenLowPowerTimeout;
	@Parameter(names = { "-lock", "-l" })
	private Long workstationLockTimeout;

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
