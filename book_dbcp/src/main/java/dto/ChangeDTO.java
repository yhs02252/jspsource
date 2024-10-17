package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class ChangeDTO {
	private String userid;;
	private String currentPassword;
	private String changePassword;
}
