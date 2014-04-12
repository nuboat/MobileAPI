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

import com.thjug.mobileapi.entity.Property;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nuboat
 */
@LocalBean
@Stateless
public class PropertyManager {

	@PersistenceContext
	private EntityManager em;

	public void insert(final Property p) {
		em.persist(p);
	}

	public void update(final Property p) {
		em.merge(p);
	}

	public void delete(final Property p) {
		em.remove(em.merge(p));
	}

	public Property get(final String id) {
		return em.find(Property.class, id);
	}

	public String getString(final String id) {
		return em.find(Property.class, id).getString();
	}

}
