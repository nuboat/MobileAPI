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
package com.thjug.mobileapi.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nuboat
 */
@Logging
@Interceptor
public class LoggingInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

	@AroundInvoke
	public Object intercept(final InvocationContext context) throws Exception {
		final long start = System.currentTimeMillis();
		try {
			return context.proceed();
		} finally {
			final long end = System.currentTimeMillis();
			final long running = end - start;

			LOG.info("Run {}.{} in {} ms.",
					context.getTarget().getClass().getSimpleName().replace("$Proxy$_$$_WeldSubclass", ""),
					context.getMethod().getName(),
					running);
		}

	}
}
