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
import com.thjug.mobileapi.model.Account;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@Path("account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

	@GET
	@Path("{id}")
	@Interceptors(LoggingInterceptor.class)
	public Response get(
			@Context final UriInfo context,
			@PathParam("id") final Long id) {
		LOG.info(" \n URL: {} \n Id: {}", context.getPath(), id);
		final Account account = new Account();
		account.setId(1L);
		account.setUsername("nuboat");
		account.setFirstname("Peerapat");
		account.setLastname("A");

		return Response.status(Response.Status.OK).entity(account).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Interceptors(LoggingInterceptor.class)
	public Response post(
			@Context final UriInfo context,
			final Account account) {
		LOG.info(" \n URL: {} \n Username: {}", context.getPath(), account.getUsername());

		return Response.status(Response.Status.OK).entity(account).build();
	}

}
