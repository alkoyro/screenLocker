package by.home.core.config;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationProviderTest {
	private ConfigurationProvider provider;
	
	@Before
	public void init() {
		provider = new ConfigurationProvider();
	}
	
	@Test
	public void testDefaultConfigurationLoading() throws IOException {
		DefaultConfiguration configuration = provider.getDefaultConfiguration();
		assertNotNull(configuration);
	}
	
	private void assertNotNull(Configuration configuration) {
		Assert.assertNotNull(configuration.getScreenLowPowerTimeout());
		Assert.assertNotNull(configuration.getScreenSwitchOffTimeout());
		Assert.assertNotNull(configuration.getScreenSwitchOnTimeout());
		Assert.assertNotNull(configuration.getWorkstationLockTimeout());		
	}

	@Test
	public void testOverrideConfigurationLoading() throws IOException {
		DefaultConfiguration overrideConfiguration = new DefaultConfiguration();
		overrideConfiguration.setScreenSwitchOffTimeout(1000l);
		overrideConfiguration.setScreenSwitchOnTimeout(1l);
		Configuration configuration = provider.getConfiguration(overrideConfiguration);
		assertNotNull(configuration);
		Assert.assertEquals(overrideConfiguration.getScreenSwitchOffTimeout(),
				configuration.getScreenSwitchOffTimeout());
		Assert.assertEquals(overrideConfiguration.getScreenSwitchOnTimeout(),
				configuration.getScreenSwitchOnTimeout());
		overrideConfiguration.setWorkstationLockTimeout(20l);
		overrideConfiguration.setScreenLowPowerTimeout(20l);
		configuration = provider.getConfiguration(overrideConfiguration);
		assertNotNull(configuration);
		Assert.assertEquals(overrideConfiguration.getScreenLowPowerTimeout(),
				configuration.getScreenLowPowerTimeout());
		Assert.assertEquals(overrideConfiguration.getWorkstationLockTimeout(),
				configuration.getWorkstationLockTimeout());
	}
}
