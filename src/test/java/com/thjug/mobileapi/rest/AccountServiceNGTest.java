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

import com.thjug.mobileapi.model.Account;
import static org.mockito.Mockito.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author PeerapatAsoktummarun
 */
public class AccountServiceNGTest {

	private final UriInfo context = Mockito.mock(UriInfo.class);

	@Test
	public void testGet() {
		when(context.getPath()).thenReturn("/echo");

		Long id = null;
		AccountService instance = new AccountService();
		Response expResult = null;
		Response result = instance.get(context, id);
		Assert.assertEquals(result, expResult);
	}

	@Test
	public void testPost() {
		when(context.getPath()).thenReturn("/echo");
		
		Account account = null;
		AccountService instance = new AccountService();
		Response expResult = null;
		Response result = instance.post(context, account);
		Assert.assertEquals(result, expResult);
	}

}
