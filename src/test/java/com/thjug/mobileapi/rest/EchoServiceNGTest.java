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

package com.thjug.mobileapi.rest;

import javax.ws.rs.core.UriInfo;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class EchoServiceNGTest {

	private final UriInfo context = Mockito.mock(UriInfo.class);

	@Test
	public void testPost() {
		when(context.getPath()).thenReturn("/echo");

		final String message = "hello";
		final EchoService instance = new EchoService();
		final String result = instance.post(context, message);
		Assert.assertNotNull(result);
	}

}
