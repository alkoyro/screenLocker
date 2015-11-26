package by.home.core;

public final class WorkstationLocker {
	private static final WorkstationLocker INSTANCE = new WorkstationLocker();

	private WorkstationLocker() {
		initDependency();
	}

	private void initDependency() {
		String path = System.getProperty("user.dir") + System.getProperty("file.separator") + 
			"lib" + System.getProperty("file.separator"); 
		if ( System.getProperty("os.arch").equals("amd64") ) {
			path += "WorkstationLockerX64.dll";			
		} else {
			path += "WorkstationLockerX32.dll";
		}
		Runtime.getRuntime().load(path);
	}

	public static WorkstationLocker getInstance() {
		return INSTANCE;
	}

	public native void lock();
}
