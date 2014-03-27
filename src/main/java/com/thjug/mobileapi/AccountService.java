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

import com.thjug.model.Account;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@Path("account")
public class AccountService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response get(
			@Context final UriInfo context,
			@PathParam("id") final Long id) {
		LOG.info(" \n URL: {} \n Id: {}", context.getPath(), id);
		final Account account = new Account();
		account.setId(1L);
		account.setUsername("nuboat");
		account.setFirstname("Peerapat");
		account.setLastname("A");

		return Response.status(200).entity(account).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response post(
			@Context final UriInfo context,
			final Account account) {
		LOG.info(" \n URL: {} \n Username: {}", context.getPath(), account.getUsername());

		return Response.status(200).entity(account).build();
	}

}
