package com.gl.companyShare.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.companyShare.bean.CompanyShare;
import com.gl.companyShare.service.CompanyShareService;




@RestController
public class CompanyShareController {

	
	@Autowired
	  private CompanyShareService service;
	  
	  @GetMapping("/index")
	  public ModelAndView showIndexPage() {
		  ModelAndView mv= new ModelAndView("index");
		  List<CompanyShare> companyList=service.findAll();
			mv.addObject("companyList",companyList);
			return mv;
	  }
	  
	  @GetMapping("/company-entry")
	  public ModelAndView showCompanyEntryPage() {
		  CompanyShare companyshare=new CompanyShare();
		  ModelAndView mv=new ModelAndView("companyEntryPage");
		  mv.addObject("companyRecord",companyshare);
		  return mv;
	  }
	  
	  @PostMapping("/companyshare")
		public ModelAndView saveNewCompany(@ModelAttribute("companyRecord")CompanyShare companyshare) {
			long id=service.generateCompanyId();
			companyshare.setCompanyId(id);
			service.save(companyshare);
			return new ModelAndView("redirect:/index");
		}
	  @GetMapping("/companyshare")
		public ModelAndView showAllCompany() {
			List<CompanyShare> companyList=service.findAll();
			ModelAndView mv=new ModelAndView("companyReportPage");
			mv.addObject("companyshare",companyList);
			return mv;
		}
	  @GetMapping("/delete-company/{id}")
		public ModelAndView deleteACompany(@PathVariable long id) {
			service.delete(id);
			return new ModelAndView("redirect:/index");
		}
		@GetMapping("/edit-sharePrice/{id}")
		public ModelAndView showACourseEditPage(@PathVariable long id) {
			CompanyShare companyshare=service.findById(id);
			ModelAndView mv=new ModelAndView("companyEditPage");
			mv.addObject("companyRecord",companyshare);
			return mv;
		}
		@PostMapping("/edit-sharePrice")
		public ModelAndView editCourse(@ModelAttribute("companyRecord") CompanyShare companyshare) {
			service.save(companyshare);
			return new ModelAndView("redirect:/index");
		
	}
}
