package tek.portfolio.contact.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tek.portfolio.contact.dto.ServiceDto;
import tek.portfolio.entity.ServiceEntity;
import tek.portfolio.reposotiries.ServicesRepo;

@Service
@Transactional(rollbackOn = Exception.class)
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	private ServicesRepo servicesRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ServiceEntity saveService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto) throws Exception {
		
		// we get the file name form multipart
		//database logic
		String filename = UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "a")+ multipartFile.getOriginalFilename();
		
		ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
		serviceEntity.setFilename(filename);
		serviceEntity.setDatetime(LocalDateTime.now().toString());
		ServiceEntity entity = servicesRepo.save(serviceEntity);
		// my database work is done
		
		
		// there start the file logic
//		// now we upload the file
		Path path = Paths.get(realPath,filename);
//		//now we convert in to file
		File file = path.toFile();
//		// transfer the file
		multipartFile.transferTo(file);
		
		return entity;
	}

	@Override
	public List<ServiceEntity> readService() {
		
		return servicesRepo.findAll();
	}
	
	// deleteSErvice Logic

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteService(String realPath, int id, String filename) {
		
		servicesRepo.deleteById(id);
		File file = new File(realPath+File.separator+filename);
		file.delete();
		
	}
// updateServices
	@Override
	public Optional<ServiceEntity> readService(int id) {
	
		
		return servicesRepo.findById(id);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public ServiceEntity updateService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto, int id,
			String oldFileName) throws Exception {
		
		
		if(multipartFile!=null && !multipartFile.isEmpty()) {
			// new file
			String filename = UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "a")+ multipartFile.getOriginalFilename();
			
			ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
			serviceEntity.setId(id);
			serviceEntity.setFilename(filename);
			serviceEntity.setDatetime(LocalDateTime.now().toString());
			ServiceEntity entity = servicesRepo.save(serviceEntity);
			
			// how to update file in folder....means deleting existing file and update the file
			// deleted the oldFile
			 new File(realPath+File.separator+oldFileName).delete();
			
			
			// now, we upload the new file
			Path path = Paths.get(realPath,filename);
//			//now we convert in to file
			File file = path.toFile();
//			// transfer the file
			multipartFile.transferTo(file);			
			return entity;

		} 
		else {
			// OLd File
			ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
			serviceEntity.setId(id);
			serviceEntity.setFilename(oldFileName);
			serviceEntity.setDatetime(LocalDateTime.now().toString());
			ServiceEntity entity = servicesRepo.save(serviceEntity);
			return entity;
		}
	}
}
