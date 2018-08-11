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
import mum.edu.mscs.swe.pms.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/products")
	public ModelAndView products() {
		ModelAndView mav = new ModelAndView();
		List<Product> products = productService.findAll();
		//mav.addAttribute("classActiveSettings","active");
		mav.addObject("products", products);
		mav.setViewName("product/list");
		return mav;
	}
	
	@RequestMapping(value="/product/new", method = RequestMethod.GET)
	public String studentRegistrationForm(Model model){			
		model.addAttribute("product", new Product());
		return "product/new";
	}
	
	@RequestMapping(value = "/product/new", method = RequestMethod.POST)
	public String registerNewStudent(@Valid @ModelAttribute("product") Product product, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "product/new";
		}
		try {
			product = productService.save(product);
		} catch (Exception ex) {
			
			model.addAttribute("errors", Arrays.asList(new ObjectError("productNumber", "Duplicate productNumber!")));
			return "product/new";
		}
		
		System.out.println(product);
		return "redirect:/products";
	}
	
	
	@GetMapping(value="/product/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model){	
		Product p = productService.findById(id);
		if (p != null) {
			model.addAttribute("product", p);
			return "product/edit";
		}
		return "product/list";
	}
	
	@PostMapping(value = "/product/edit")
	public String updateStudent(@Valid @ModelAttribute("product") Product product, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "product/edit";
		}
		product = productService.save(product);
		return "redirect:/products";
	}
	
}
