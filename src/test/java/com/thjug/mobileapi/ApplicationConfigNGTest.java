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

package com.thjug.mobileapi;

import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class ApplicationConfigNGTest {

	@Test
	public void testGetClasses() {
		final ApplicationConfig instance = new ApplicationConfig();
		final Set<Class<?>> result = instance.getClasses();
		assertNotNull(result);
	}

}
