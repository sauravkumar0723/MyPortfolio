package tek.portfolio.contact.service;

import java.util.List;

import tek.portfolio.contact.dto.ContactDto;
import tek.portfolio.entity.ContactEntity;

public interface ContactService {

	ContactEntity saveContacts(ContactDto contactDto);
	
	boolean isContactEmailExist(String email);
	
	List<ContactEntity> readAllContacts();
	
	void deleteContactById(int id);
}
