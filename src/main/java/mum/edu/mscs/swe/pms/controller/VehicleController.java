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


import mum.edu.mscs.swe.pms.model.Product;
import mum.edu.mscs.swe.pms.model.Vehicle;
import mum.edu.mscs.swe.pms.service.ManufacturerService;
import mum.edu.mscs.swe.pms.service.ProductService;
import mum.edu.mscs.swe.pms.service.VehicleService;



@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private ManufacturerService manufacturerService;
	
	@GetMapping(value="/vehicles")
	public ModelAndView vehicles() {
		ModelAndView mav = new ModelAndView();
		List<Vehicle> vehicles = vehicleService.findAll();
		mav.addObject("vehicles", vehicles);
		mav.setViewName("vehicle/list");
		return mav;
	}
	
	@RequestMapping(value="/vehicle/new", method = RequestMethod.GET)
	public String vehicleRegistrationForm(Model model){			
		model.addAttribute("vehicle", new Vehicle());
		model.addAttribute("manufacturers", manufacturerService.findAll());
		return "vehicle/new";
	}
	
	@RequestMapping(value = "/vehicle/new", method = RequestMethod.POST)
	public String registerNewVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			model.addAttribute("manufacturers", manufacturerService.findAll());
			return "vehicle/new";
		}
		try {
			vehicle = vehicleService.save(vehicle);
		} catch (Exception ex) {						
			return "vehicle/new";
		}

		return "redirect:/vehicles";
	}
	
	
	@GetMapping(value="/vehicle/edit/{id}")
	public String editVehicle(@PathVariable Long id, Model model){	
		Vehicle v = vehicleService.findById(id);
		if (v != null) {
			model.addAttribute("vehicle", v);
			model.addAttribute("manufacturers", manufacturerService.findAll());
			return "vehicle/edit";
		}
		return "vehicle/list";
	}
	
	@PostMapping(value = "/vehicle/edit")
	public String updateStudent(@Valid @ModelAttribute("vehicle") Vehicle vehicle, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "vehicle/edit";
		}
		vehicle = vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
}
