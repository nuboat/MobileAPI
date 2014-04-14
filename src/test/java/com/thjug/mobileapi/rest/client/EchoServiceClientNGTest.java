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
package com.thjug.mobileapi.rest.client;

import com.thjug.mobileapi.rest.PropertyServiceNGTest;
import java.io.Closeable;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Jersey REST client generated for REST resource:EchoService [echo]<br>
 * USAGE:
 * <pre>
        EchoServiceClientNGTest client = new EchoServiceClientNGTest();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 * </pre>
 * Good references: https://jersey.java.net/documentation/latest/client.html
 *
 * @author nuboat
 */
public class EchoServiceClientNGTest implements Closeable {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyServiceNGTest.class);

	private static final String BASE_URI = "http://localhost:8080/mobile/rest";

	private final WebTarget webTarget;
	private final Client client;

	public EchoServiceClientNGTest() {
		client = ClientBuilder.newClient();
		webTarget = client.target(BASE_URI).path("echo");
	}

	@BeforeTest
	public void initial() {
		LOG.info("Start {} times.", System.currentTimeMillis());
	}

	public String get(final String key, final String value) throws ClientErrorException {
		return webTarget.queryParam(key, value).request().get(String.class);
	}

	public String post(final Form form) throws ClientErrorException {
		return webTarget.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), String.class);
	}

	@Override
	public void close() {
		client.close();
	}

	@Test(enabled=false)
	public void testGet() {
		try (final EchoServiceClientNGTest service = new EchoServiceClientNGTest()) {
			final Object response = service.get("message", "hellllo");
			Assert.assertNotNull(response);
		}
	}

	@Test(enabled=false)
	public void testPost() {
		try (final EchoServiceClientNGTest service = new EchoServiceClientNGTest()) {
			final Form form = new Form();
			form.param("message", "hellllo");
			final Object response = service.post(form);
			Assert.assertNotNull(response);
		}
	}

}
