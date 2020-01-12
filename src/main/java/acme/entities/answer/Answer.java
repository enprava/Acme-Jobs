
package acme.entities.answer;

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

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				answer;

	@Pattern(regexp = "^(?=(?:.*\\d){1,})(?=(?:.*[a-zA-Z]){1,})(?=(?:.*\\p{Punct}){1,}).{10,}$|^$")
	private String				password;

	private String				trackId;

	@NotNull
	@Valid
	@OneToOne(optional = true)
	private Application			application;
}
