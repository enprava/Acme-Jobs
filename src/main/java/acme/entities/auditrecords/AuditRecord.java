
package acme.entities.auditrecords;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.roles.Auditor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;
	@NotBlank
	private String				title;
	@NotNull
	private Status				status;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;
	@NotBlank
	private String				body;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Auditor				auditor;

}
