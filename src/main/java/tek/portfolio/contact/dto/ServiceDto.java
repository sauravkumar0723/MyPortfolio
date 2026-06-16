package tek.portfolio.contact.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {

	@Size(min = 2, max = 30, message = "Invalid Name length")
	@NotBlank(message = "title cannot be empty")
	private String title;
	
	@Size(min = 8, max = 1000, message = "Invalid Description length")
	@NotBlank(message = "Description cannot be empty")
	private String description;
	
	private MultipartFile serviceFile;
}
