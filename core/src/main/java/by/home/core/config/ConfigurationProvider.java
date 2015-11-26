package by.home.core.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationProvider {
	public static final String DEFAULT_PROPERTIES_FILE = "configuration.properties";
	
	public DefaultConfiguration getDefaultConfiguration() throws IOException {
		Properties defaultProperties = loadDefaultProperties();

		return initConfiguration(defaultProperties);
	}
	
	private DefaultConfiguration initConfiguration(Properties properties) throws IOException {
		DefaultConfiguration configuration = new DefaultConfiguration();
		
		configuration.setScreenLowPowerTimeout(
				Long.valueOf((String) properties.get(DefaultConfiguration.PROPERTY_SCREEN_LOW_POWER)));
		configuration.setScreenSwitchOffTimeout(
				Long.valueOf((String) properties.get(DefaultConfiguration.PROPERTY_SCREEN_SWITCH_OFF)));
		configuration.setScreenSwitchOnTimeout(
				Long.valueOf((String) properties.get(DefaultConfiguration.PROPERTY_SCREEN_SWITCH_ON)));
		configuration.setWorkstationLockTimeout(
				Long.valueOf((String) properties.get(DefaultConfiguration.PROPERTY_WORKSTATION_LOCK)));
		
		
		return configuration;
	}
	
	/**
	 * all paramaters of defaultConfiguration will be overidden by overridedConfiguration 
	 * @param overridedConfiguration
	 * @return
	 * @throws IOException
	 */
	public Configuration getConfiguration(Configuration overridedConfiguration) throws IOException {		
		DefaultConfiguration defaultConfiguration = getDefaultConfiguration();
		
		if ( overridedConfiguration.getScreenLowPowerTimeout() != null ) {
			defaultConfiguration.setScreenLowPowerTimeout(overridedConfiguration.getScreenLowPowerTimeout());
		}
		if ( overridedConfiguration.getScreenSwitchOffTimeout() != null ) {
			defaultConfiguration.setScreenSwitchOffTimeout(overridedConfiguration.getScreenSwitchOffTimeout());
		}
		if ( overridedConfiguration.getScreenSwitchOnTimeout() != null ) {
			defaultConfiguration.setScreenSwitchOnTimeout(overridedConfiguration.getScreenSwitchOnTimeout());
		}
		if ( overridedConfiguration.getWorkstationLockTimeout() != null ) {
			defaultConfiguration.setWorkstationLockTimeout(overridedConfiguration.getWorkstationLockTimeout());
		}

				
		return defaultConfiguration;		
	}
	
	private Properties loadDefaultProperties() throws IOException {
		Properties defaultProperties = new Properties();
		defaultProperties.load(getClass().getClassLoader().
				getResourceAsStream(DEFAULT_PROPERTIES_FILE));
		return defaultProperties;
	}
}
