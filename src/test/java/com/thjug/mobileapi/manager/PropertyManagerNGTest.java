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
package com.thjug.mobileapi.manager;

import com.thjug.mobileapi.container.GlassfishContainer;
import com.thjug.mobileapi.entity.Property;
import javax.naming.NamingException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author nuboat
 */
public class PropertyManagerNGTest {

	final static String ID = "NAME";

	final Property property;
	final PropertyManager instance;

	public PropertyManagerNGTest() throws NamingException {
		instance = GlassfishContainer.lookup(PropertyManager.class);

		property = new Property();
		property.setId(ID);
		property.setString("THJUG");
	}

	@Test(priority = 1)
	public void testGetString() throws Exception {
		System.out.println("testGetString");

		final String id = "VERSION";
		final String result = instance.getString(id);

		Assert.assertNotNull(result);
	}

	@Test(priority = 2)
	public void testInsert() {
		System.out.println("testInsert");

		instance.insert(property);
		Assert.assertNotNull(property.getId());
	}

	@Test(priority = 3)
	public void testGet() {
		System.out.println("testGet");

		Assert.assertNotNull(instance.get(ID));
	}

	@Test(priority = 4)
	public void testUpdate() {
		System.out.println("testUpdate");

		property.setString("THJUG2");
		instance.update(property);

		final Property p = instance.get(ID);
		Assert.assertEquals(property.getString(), p.getString());
	}

	@Test(priority = 5)
	public void testDelete() {
		System.out.println("testDelete");

		instance.delete(property);
		Assert.assertNull(instance.get(property.getId()));
	}

}
