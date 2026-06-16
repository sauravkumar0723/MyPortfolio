package tek.portfolio.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import tek.portfolio.contact.dto.ServiceDto;
import tek.portfolio.entity.ServiceEntity;

public interface ServicesService {
	
	ServiceEntity saveService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto) throws Exception;
	List<ServiceEntity> readService();
	
	// deleteService
	void deleteService(String realPath, int id , String filename);
	// updateServices
	Optional<ServiceEntity> readService(int id);
	
	ServiceEntity updateService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto, int id, String oldFileName) throws Exception;
	

}
