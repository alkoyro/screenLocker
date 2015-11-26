package by.home.console.command.executor;

import org.apache.log4j.Logger;

import by.home.console.LockerConfiguration;
import by.home.core.config.Configuration;
import by.home.core.config.ConfigurationProvider;
import by.home.core.executor.ConfigurationExecutor;

public class CommandExecutor {
	private static final Logger LOGGER = Logger.getLogger(CommandExecutor.class);
	
	public void execute(LockerConfiguration lockerConfiguration) {
		ConfigurationProvider configurationProvider = new ConfigurationProvider();
		try {
			Configuration configuration = configurationProvider.getConfiguration(lockerConfiguration);
			ConfigurationExecutor configurationExecutor = new ConfigurationExecutor();
			LOGGER.info("Starting execution");
			configurationExecutor.execute(configuration);
			LOGGER.info("Finish execution");
		} catch ( Exception e ) {
			LOGGER.error(e);
		}
	}
}
