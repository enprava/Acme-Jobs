
package acme.entities.shaters;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Shater extends DomainEntity {

	// Serialisation identifier ----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------------
	@NotBlank
	@Size(max = 256)
	private String				description;

	private String				trackId;

	@NotNull
	@Valid
	@OneToOne(optional = true)
	private Job					job;
}
