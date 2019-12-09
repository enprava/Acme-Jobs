
package acme.entities.messagethreads;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MessageThread extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	@NotBlank
	private String					title;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date					moment;

	@NotBlank
	private String					users;

	//Relationships

	@NotNull
	@Valid
	@ManyToMany
	private Collection<UserAccount>	useraccount;

}
