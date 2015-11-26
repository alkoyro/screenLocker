package by.home.core;

public final class ScreenPowerSwitcher {
	private static final ScreenPowerSwitcher INSTANCE = new ScreenPowerSwitcher();
	
	private ScreenPowerSwitcher() {
		initDependency();
	}
	
	private void initDependency() {
		String path = System.getProperty("user.dir") + System.getProperty("file.separator") + 
			"lib" + System.getProperty("file.separator");
		if ( System.getProperty("os.arch").equals("amd64") ) {
			path += "ScreenPowerSwitcherX64.dll";			
		} else {
			path += "ScreenPowerSwitcherX32.dll";
		}
		Runtime.getRuntime().load(path);
	}

	public static ScreenPowerSwitcher getInstance() {
		return INSTANCE;
	}
	
	public native void switchOn();
	public native void switchOff();
	public native void lowPower();
}
