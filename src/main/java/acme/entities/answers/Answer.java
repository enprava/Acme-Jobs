
package acme.entities.answers;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

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

	@URL
	private String				trackId;

	//relationships

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Application			application;

}
