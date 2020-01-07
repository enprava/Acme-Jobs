
package acme.dashboard;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private Double	ratJobsWithChallenge2;

	private Double	ratChallenge2WithAnswer;

	private Double	ratApplicationsWithPasswords;

}
