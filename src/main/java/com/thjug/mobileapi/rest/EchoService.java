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

import com.thjug.mobileapi.interceptor.LoggingInterceptor;
import javax.interceptor.Interceptors;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@Path("echo")
@Produces(MediaType.APPLICATION_JSON)
@Interceptors(LoggingInterceptor.class)
public class EchoService {

	private static final Logger LOG = LoggerFactory.getLogger(EchoService.class);

	@GET
	@Interceptors(LoggingInterceptor.class)
	public String get(
			@Context UriInfo context,
			@QueryParam("message") final String message) {
		LOG.info(" \n URL: {} \n message: {}", context.getPath(), message);
		return "{{{ " + message + " }}}";
	}

	@POST
	@Interceptors(LoggingInterceptor.class)
	public String post(
			@Context UriInfo context,
			@FormParam("message") final String message) {
		LOG.info(" \n URL: {} \n message: {}", context.getPath(), message);
		return "{{{ " + message + " }}}";
	}

}
