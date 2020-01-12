
package forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Double						jobsWithShater;

	Double						shaterWithTrackId;

	Double						applicationsProtected;

}
