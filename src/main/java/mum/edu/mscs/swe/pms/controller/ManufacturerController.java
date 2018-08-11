package mum.edu.mscs.swe.pms.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.mscs.swe.pms.model.Manufacturer;
import mum.edu.mscs.swe.pms.model.Product;
import mum.edu.mscs.swe.pms.service.ManufacturerService;
import mum.edu.mscs.swe.pms.service.ProductService;



@Controller
public class ManufacturerController {

	@Autowired
	private ManufacturerService manufacturerService;
	
	@GetMapping(value="/manufacturers")
	public ModelAndView manufacturers() {
		ModelAndView mav = new ModelAndView();
		List<Manufacturer> manufacturers = manufacturerService.findAll();
		mav.addObject("manufacturers", manufacturers);
		mav.setViewName("manufacturer/list");
		return mav;
	}
	
	@RequestMapping(value="/manufacturer/new", method = RequestMethod.GET)
	public String manufacturerRegistrationForm(Model model){			
		model.addAttribute("manufacturer", new Manufacturer());
		return "manufacturer/new";
	}
	
	@RequestMapping(value = "/manufacturer/new", method = RequestMethod.POST)
	public String registerNewManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "manufacturer/new";
		}
		try {
			manufacturer = manufacturerService.save(manufacturer);
		} catch (Exception ex) {
			
			//model.addAttribute("errors", Arrays.asList(new ObjectError("productNumber", "Duplicate productNumber!")));
			return "product/new";
		}
		
		System.out.println(manufacturer);
		return "redirect:/manufacturers";
	}
	
	
	@GetMapping(value="/manufacturer/edit/{id}")
	public String editManufacturer(@PathVariable Long id, Model model){	
		Manufacturer m = manufacturerService.findById(id);
		if (m != null) {
			model.addAttribute("manufacturer", m);
			return "manufacturer/edit";
		}
		return "manufacturer/list";
	}
	
	@PostMapping(value = "/manufacturer/edit")
	public String updateManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "manufacturer/edit";
		}
		manufacturer = manufacturerService.save(manufacturer);
		return "redirect:/manufacturers";
	}
	
}
