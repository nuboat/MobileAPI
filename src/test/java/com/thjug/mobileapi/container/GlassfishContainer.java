/*
 * Copyright(c) 2007-2012 - Entiera Software Solutions
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Entiera Solutions. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Entiera.
 *
 * Created on Feb 10, 2014
 */
package com.thjug.mobileapi.container;

import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 *
 * @author pasoktummarungsri
 */
public class GlassfishContainer {

	private static final String GLASSFISH_ROOT = "org.glassfish.ejb.embedded.glassfish.installation.root";
	private static final String DOMAIN_ROOT = "org.glassfish.ejb.embedded.glassfish.instance.root";
	private static final String DOMAINXML_ROOT = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static EJBContainer container = null;

	private static final String APP_NAME = "thjug";

	private GlassfishContainer() {
	}

	@BeforeSuite
	public static void initial() {
		createContainer();
	}

	@AfterSuite
	public static void released() {
		if (container != null) {
			container.close();
		}
	}

	public static Context getContext() {
		return (container == null) ? createContainer() : container.getContext();
	}

	@SuppressWarnings("unchecked")
	public static <T> T lookup(final Class<? extends T> type) throws NamingException {
		return (T) getContext().lookup("java:global/" + APP_NAME + "/classes/" + type.getSimpleName());
	}

	private static Context createContainer() {
		final String glassfish_home = System.getProperty("glassfish_home");

		final Properties properties = new Properties();
		properties.put(GLASSFISH_ROOT, glassfish_home);
		properties.put(DOMAIN_ROOT, glassfish_home + "/domains/domain1");
		properties.put(DOMAINXML_ROOT, glassfish_home + "/domains/domain1/config/domain.xml");
		properties.put(EJBContainer.APP_NAME, APP_NAME);

		try {
			container = EJBContainer.createEJBContainer(properties);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return container.getContext();
	}

}
