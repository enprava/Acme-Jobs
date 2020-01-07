
package acme.entities.answers;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.entities.applications.Application;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer extends DomainEntity {

	// Serialisation identifier ----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------------

	@NotBlank
	private String				answer;

	@Pattern(regexp = "^(?=(?:.*\\d){3,})(?=(?:.*[a-zA-Z]){3,})(?=(?:.*\\p{Punct}){3,}).{8,}$|^$")
	private String				password;

	//Relaciones------------------------------------------------

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Application			application;

}
