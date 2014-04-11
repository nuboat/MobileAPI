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

import com.thjug.mobileapi.entity.Property;
import com.thjug.mobileapi.interceptor.LoggingInterceptor;
import com.thjug.mobileapi.manager.PropertyManager;
import javax.ejb.EJB;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
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
@Path("property")
@Produces(MediaType.APPLICATION_JSON)
public class PropertyService {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyService.class);

	@EJB
	private PropertyManager manager;

	@GET
	@Path("{keyname}")
	@Interceptors(LoggingInterceptor.class)
	public Response get(
			@Context final UriInfo context,
			@PathParam("keyname") final String keyname) {
		LOG.info(" \n URL: {} \n Key: {}", context.getPath(), keyname);

		final Property property = manager.get(keyname);

		return Response.status(Response.Status.OK).entity(property).build();
	}

}
