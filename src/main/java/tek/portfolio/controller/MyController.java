package tek.portfolio.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tek.portfolio.contact.dto.ContactDto;
import tek.portfolio.contact.service.ContactService;
import tek.portfolio.contact.service.ServicesService;

@Controller
@RequestMapping("/client")
public class MyController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ServicesService servicesService;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/services")
	public String services(Model modal) {
		modal.addAttribute("listOfServices", servicesService.readService());
		return "services";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@Valid @ModelAttribute ContactDto contactDto, BindingResult bindingResult , Model model , RedirectAttributes redirectAttributes) {
		
//		if(bindingResult.hasErrors()) 
//		{
//		// this will print on console
//		      List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//		       for (FieldError error : fieldErrors) 
//		       {
//			    String defaultMessage = error.getDefaultMessage();
//		       } 
//		}
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("result", "Invalid Input");
			 model.addAttribute("errors", bindingResult.getFieldErrors());
			 return "contact";
		}
		
		
		if(contactService.isContactEmailExist(contactDto.getEmail())) {
			redirectAttributes.addFlashAttribute("result", "You have already sent");
			return "redirect:/client/contact";
		}
		
		contactService.saveContacts(contactDto);
		redirectAttributes.addFlashAttribute("result", "Contact Saved Successfully");
		return "redirect:/client/contact";
	}
	
//	@PostMapping("/saveService")
//	public String saveService(@ModelAttribute ContactDto contactDto, RedirectAttributes redirectAttributes) {
//		
//		
//		return "redirect:/client/services";
//	}

	    // DownloadResume
	@GetMapping("/downloadResume")
	public void downloadResume(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		we tell where to pick the file when file was kept on server
		String realPath = request.getServletContext().getRealPath("/resume/");
		Path path = Paths.get(realPath, "SauravResume.pdf");
//		in response we tell the file type
		response.setContentType("application/pdf");
		// in response we download the file
		response.setHeader("Content-Disposition", "attachment; filename=SauravResume.pdf");
		// get the file from browser
			ServletOutputStream outputStream = response.getOutputStream();
			Files.copy(path, outputStream);
			
			outputStream.flush();
	}
	
	@GetMapping("/mylogin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/unauthorized")
	public String unauthorized() {
		return "unauthorized";
	}
}
