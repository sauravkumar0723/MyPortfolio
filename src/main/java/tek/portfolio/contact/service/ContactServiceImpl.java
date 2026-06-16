package tek.portfolio.contact.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tek.portfolio.contact.dto.ContactDto;
import tek.portfolio.entity.ContactEntity;
import tek.portfolio.reposotiries.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ContactEntity saveContacts(ContactDto contactDto) {
		
		
//		ContactEntity contactEntity = new ContactEntity();
//		contactEntity.setName(contactDto.getName());
//		contactEntity.setEmail(contactDto.getEmail());
//		contactEntity.setSubject(contactDto.getSubject());
//		contactEntity.setMessage(contactDto.getMessage());
//		
//		contactEntity.setDatetime(LocalDateTime.now().toString());
		
		ContactEntity contactEntity = modelMapper.map(contactDto, ContactEntity.class);
		// we explicitly put the data 
		contactEntity.setDatetime(LocalDateTime.now().toString()); 
		return contactRepo.save(contactEntity);
	}

	@Override
	public boolean isContactEmailExist(String email) {
		
		return contactRepo.existsByEmail(email);
	}

	@Override
	public List<ContactEntity> readAllContacts() {
		
		return contactRepo.findAll();
	}

	@Override
	public void deleteContactById(int id) {
		contactRepo.deleteById(id);
		
	}

	

}
