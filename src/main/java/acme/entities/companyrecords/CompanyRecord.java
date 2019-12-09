
package acme.entities.companyrecords;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CompanyRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				name, sector, ceoname, description;
	@NotBlank
	@URL
	private String				web;
	@NotBlank
	@Pattern(regexp = "^([+]\\d{1,3}\\s)?([(]\\d{1,4}[)]\\s)?\\d{6,10}$")
	private String				phone;
	@NotBlank
	@Email
	private String				email;
	@Max(5)
	@Min(0)
	private Integer				stars;
	@NotNull
	private boolean				incorporated;

}
