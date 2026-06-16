package tek.portfolio;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import tek.portfolio.entity.AppUser;
import tek.portfolio.reposotiries.UserRepository;


@SpringBootApplication
public class MyPortfolioApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MyPortfolioApplication.class, args);
		
		UserRepository userRepo = ctx.getBean(UserRepository.class);
        PasswordEncoder encoder  = ctx.getBean(PasswordEncoder.class);
		
		//admin member
		if( userRepo.findByUsername("admin").isEmpty()) {
			
			AppUser appUser = new AppUser();
			appUser.setUsername("admin");
			appUser.setPassword(encoder.encode("admin123"));
			appUser.setRole("ROLE_ADMIN");
			userRepo.save(appUser);
			System.out.println("Admin Inserted");
			//admin
			//admin123
			//insert
		} else {
			System.out.println("ADMIN ALREADY EXISTS");
		}
		
		//admin member
				if( userRepo.findByUsername("member").isEmpty()) {
					
					AppUser appUser = new AppUser();
					appUser.setUsername("member");
					appUser.setPassword(encoder.encode("member123"));
					appUser.setRole("ROLE_MEMBER");
					userRepo.save(appUser);
					System.out.println("MEMBER Inserted");
					
					//member
					//member123
					//insert
				} else {
					System.out.println("member ALREADY EXISTS");
				}
		
	}

}
