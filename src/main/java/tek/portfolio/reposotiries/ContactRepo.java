package tek.portfolio.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tek.portfolio.entity.ContactEntity;

@Repository
public interface ContactRepo extends JpaRepository<ContactEntity, Integer> {
	
	boolean existsByEmail(String email);

}
