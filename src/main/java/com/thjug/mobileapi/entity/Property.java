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
package com.thjug.mobileapi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nuboat
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p")})
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
	private String id;

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
	private String string;

	public Property() {
	}

	public Property(final String id) {
		this.id = id;
	}

	public Property(final String id, final String string) {
		this.id = id;
		this.string = string;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getString() {
		return string;
	}

	public void setString(final String string) {
		this.string = string;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Property)) {
			return false;
		}
		Property other = (Property) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Property[ id=" + id + " ]";
	}

}
