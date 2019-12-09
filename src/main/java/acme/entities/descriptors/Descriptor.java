
package acme.entities.descriptors;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import acme.entities.duties.Duty;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Descriptor extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	@NotBlank
	private String					description;

	@NotEmpty
	@OneToMany()
	private Collection<@Valid Duty>	duties;

}
