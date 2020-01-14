
package acme.entities.duboas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Duboa extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(min = 1, max = 256)
	private String				text;

	@URL
	private String				trackId;

	//relationships
	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Job					job;

}
