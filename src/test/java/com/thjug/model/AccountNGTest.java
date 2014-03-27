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
package com.thjug.model;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class AccountNGTest {

	@Test
	public void testGetId() throws IOException {
		final Account instance = new Account();
		instance.setId(1L);
		instance.setUsername("nuboat");
		instance.setFirstname("Peerapat");
		instance.setLastname("A");

		final ObjectMapper mapper = new ObjectMapper();
		final String json = mapper.writeValueAsString(instance);
		System.out.println(json);
	}

}
