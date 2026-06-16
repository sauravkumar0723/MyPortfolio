package tek.portfolio.configuration.modelmapperss;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

	@Bean
	 ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
