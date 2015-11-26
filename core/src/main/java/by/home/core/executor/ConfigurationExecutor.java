package by.home.core.executor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import by.home.core.ScreenPowerSwitcher;
import by.home.core.WorkstationLocker;
import by.home.core.config.Configuration;

public class ConfigurationExecutor {
	private static final Logger LOGGER = Logger.getLogger(ConfigurationExecutor.class);
	
	public void execute(Configuration configuration) throws InterruptedException, ExecutionException {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		//task to perform and it's delay
		Map<Runnable, Long> tasks = createTasks(configuration);
		for (Entry<Runnable, Long> task : tasks.entrySet()) {
			 ScheduledFuture<?> future = executorService.schedule(task.getKey(), task.getValue(), TimeUnit.SECONDS);
			 try {
				 future.get();
			 }
			 catch(ExecutionException exception) {
				 LOGGER.error(exception);
			 }
		}
		
		executorService.shutdown();
	}

	private Map<Runnable, Long> createTasks(Configuration configuration) {
		Map<Runnable, Long> tasks = new HashMap<Runnable, Long>();

		if ( configuration.getScreenLowPowerTimeout() > 0 ) {
			tasks.put(new Runnable() {
				@Override
				public void run() {
					LOGGER.info("Perform screen low power action");
					ScreenPowerSwitcher.getInstance().lowPower();					
				}
			}, configuration.getScreenLowPowerTimeout());
		}
		
		if ( configuration.getScreenSwitchOffTimeout() > 0 ) {
			tasks.put(new Runnable() {
				@Override
				public void run() {
					LOGGER.info("Perform screen switch off action");
					ScreenPowerSwitcher.getInstance().switchOff();
				}
			}, configuration.getScreenSwitchOffTimeout());
		}
		
		if ( configuration.getScreenSwitchOnTimeout() > 0 ) {
			tasks.put(new Runnable() {
				@Override
				public void run() {
					LOGGER.info("Perform screen switch on action");
					ScreenPowerSwitcher.getInstance().switchOn();
				}
			}, configuration.getScreenSwitchOnTimeout());
		}
		
		if ( configuration.getWorkstationLockTimeout() > 0 ) {
			tasks.put(new Runnable() {
				@Override
				public void run() {
					LOGGER.info("Perform workstation lock action");
					WorkstationLocker.getInstance().lock();
				}
			}, configuration.getWorkstationLockTimeout());
		}

		return tasks;
	}
}
