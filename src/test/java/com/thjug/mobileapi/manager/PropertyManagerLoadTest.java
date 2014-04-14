/**
 * <pre>
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 * </pre>
 */
package com.thjug.mobileapi.manager;

import com.thjug.mobileapi.container.GlassfishContainer;
import com.thjug.mobileapi.define.GlobalProperty;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class PropertyManagerLoadTest {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyManagerLoadTest.class);

	@BeforeTest
	public void initial() throws NamingException {
		LOG.info("Start {} times.", System.currentTimeMillis());

		GlassfishContainer.getContext();
	}

	@Test(enabled=false, threadPoolSize=24, invocationCount=10000, invocationTimeOut = 10000L, timeOut=10000L)
	public void testLoopGetString() throws Exception {
		final String id = GlobalProperty.VERSION.toString();
		long starttime = System.currentTimeMillis();
		final PropertyManager manager = GlassfishContainer.lookup(PropertyManager.class);
		manager.getString(id);
		long endtime = System.currentTimeMillis();
		LOG.info("Execution in {} ms.", (endtime - starttime));
	}

}
