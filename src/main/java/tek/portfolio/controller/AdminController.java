package tek.portfolio.controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tek.portfolio.contact.dto.ServiceDto;
import tek.portfolio.contact.service.ContactService;
import tek.portfolio.contact.service.ServicesService;
import tek.portfolio.entity.ServiceEntity;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ServicesService servicesService;
	
	@GetMapping("/home")
	public String home() {
		return "admin/adminHome";
	}
	
	@GetMapping("/readAllContacts")
	public String readAllContacts(Model model) {
		
		
		
		model.addAttribute("contactData", contactService.readAllContacts());
		return "admin/readAllContacts";
	}
	
	@GetMapping("/deleteContactById")
	public String deleteContactById(@RequestParam int id) {
		
		contactService.deleteContactById(id);
		
		
		return "redirect:/admin/readAllContacts";
	}
	
	// we start the services 
	@GetMapping("/addService")
	public String addServiceView() {
		
		return "admin/addService";
	}
	// multipart file
	@PostMapping("/addService")
	public String addService(@Valid @ModelAttribute ServiceDto serviceDto , BindingResult result 
			, Model model , RedirectAttributes redirectAttributes , HttpServletRequest request) throws Exception {
		
		if(result.hasErrors()) {
			model.addAttribute("result", "Invalid Input");
			model.addAttribute("errors", result.getFieldErrors());
			return "admin/addService";
		}
		
		// file must be not null and not empty
		
		if(serviceDto.getServiceFile()== null || serviceDto.getServiceFile().isEmpty()) {
			model.addAttribute("result", "File Must Be Uploaded");
			return "admin/addService";
		}
		// we want to file size in services not more than 2MB
		
		MultipartFile multipartFile = serviceDto.getServiceFile();
		long size = multipartFile.getSize();
		if(size > (1*1024*1024)) {
			model.addAttribute("fileError", "File Size must not Exceed 1MB");
			return "admin/addService";
		}
		System.out.println("******************All goes right in validation*******************");
		
		// we want get in to realPath of file
		String realPath = request.getServletContext().getRealPath("img/services");
//		// we want to get Original file name
//		String originalFileName = UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "a")+ multipartFile.getOriginalFilename();
//		// now we upload the file
//		Path path = Paths.get(realPath,originalFileName);
//		//now we convert in to file
//		File file = path.toFile();
//		// transfer the file
//		multipartFile.transferTo(file);
		
		// now send data to database
		servicesService.saveService(realPath, multipartFile, serviceDto);
		redirectAttributes.addFlashAttribute("result", "Services Added SuccessFully");
		
		return "redirect:/admin/addService";
	}
	
	
//	    readAllService
	@GetMapping("/readAllServices")
	public String readAllServices(Model modal) {
		modal.addAttribute("listOfServices", servicesService.readService());
		return "admin/readAllServices";
	}
	
	// deleteService
	@GetMapping("/deleteService")
	public String deleteService(@RequestParam int id, @RequestParam String filename,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
//		to get the real path
		String realPath = request.getServletContext().getRealPath("img/services");
		servicesService.deleteService(realPath, id, filename);
		
		return "redirect:/admin/readAllServices";
	}
	
	// updateServices
	@GetMapping("/updateService")
	public String updateServiceView(@RequestParam int id, Model model) {
		
		
		Optional<ServiceEntity> service = servicesService.readService(id);
		ServiceEntity serviceEntity = service.get();
		model.addAttribute("serviceData", serviceEntity);
		return "admin/updateService";
	}
	
	// updateServices
		@PostMapping("/updateService")
		public String updateServiceView(@RequestParam int id, @RequestParam String oldFileName, 
				@ModelAttribute ServiceDto serviceDto, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
			
			System.out.println("********check data will come into backend or not************");
			
			String realPath = request.getServletContext().getRealPath("img/services");
			MultipartFile serviceFile = serviceDto.getServiceFile();
			
			servicesService.updateService(realPath, serviceFile, serviceDto, id, oldFileName);
			return "redirect:/admin/readAllServices";
		}
		
	   // upload Resume
		@GetMapping("/uploadResume")
		public String updateResumeView() {

			return "admin/uploadResume";
		}
		
		@PostMapping("/uploadResume")
		public String updateResume( @RequestParam MultipartFile resume,
				RedirectAttributes redirectAttributes, HttpServletRequest request) throws IllegalStateException, IOException {
			if(resume== null || resume.isEmpty()) {
				redirectAttributes.addFlashAttribute("result", "Resume Must Be Uploaded");
				return "redirect:/admin/uploadResume";
			}
			long size =resume.getSize();
			if(size > (1*1024*1024)) {
				redirectAttributes.addFlashAttribute("result", "Resume Size Must  Not Be exceed 3MB");
				return "redirect:/admin/uploadResume";
			}
			// only pdf will upload other thing will not upload
			String contentType = resume.getContentType();
			if(!contentType.contains("pdf")) {
				redirectAttributes.addFlashAttribute("result", "Resume should must be in pdf format");
				return "redirect:/admin/uploadResume";
			}
			//
			String realPath = request.getServletContext().getRealPath("/resume/");
			// now we upload the file
			Path path = Paths.get(realPath, "SauravResume.pdf");
//			//now we convert in to file
			File file = path.toFile();
			
			// file exist
			if(file.exists()) {
				file.delete();
			}
//			// transfer the file
			resume.transferTo(file);
			redirectAttributes.addFlashAttribute("result", "Resume uploaded sucessfully");
			return "redirect:/admin/uploadResume";
		}
		
}
