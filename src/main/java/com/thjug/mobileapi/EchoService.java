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

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@Path("echo")
public class EchoService {

	private static final Logger LOG = LoggerFactory.getLogger(EchoService.class);

	@POST
	@Produces("application/json")
	public String post(
			@Context UriInfo context,
			@FormParam("message") final String message) {
		LOG.info(" \n URL: {} \n message: {}", context.getPath(), message);
		return "{{{ " + message + " }}}";
	}

}
