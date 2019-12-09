
package acme.entities.offers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends DomainEntity {

	//Serialisation identifier

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@NotBlank
	@NotNull
	private String				text;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadline;

	@Valid
	@NotNull
	private Money				minmoney;

	@Valid
	@NotNull
	private Money				maxmoney;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^O[A-Z]{4}\\-\\d{5}$")
	private String				ticker;

}
