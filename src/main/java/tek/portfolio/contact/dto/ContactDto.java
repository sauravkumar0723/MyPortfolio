package tek.portfolio.contact.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
	
	@Size(min = 2, max = 30, message = "Invalid Name length")
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@Size(min = 8, max = 50, message = "Invalid Name length")
	@NotBlank(message = "Email cannot be empty")
	private String email;
	
	@Size(min = 10, max = 50, message = "Invalid subject length")
	@NotBlank(message = "Subject cannot be empty")
	private String subject;
	
	@Size(min = 10, max = 1000, message = "Invalid message length")
	@NotBlank(message = "message cannot be empty")
	private String message;

}
