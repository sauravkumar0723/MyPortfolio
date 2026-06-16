package tek.portfolio.reposotiries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tek.portfolio.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{

	Optional<AppUser>  findByUsername(String username);
}
