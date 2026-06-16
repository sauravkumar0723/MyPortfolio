package tek.portfolio.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tek.portfolio.entity.ServiceEntity;

@Repository
public interface ServicesRepo extends JpaRepository<ServiceEntity, Integer>{

}
