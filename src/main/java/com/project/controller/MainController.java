package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.project.dao.ProductDao;
import com.project.entity.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Product> products = productDao.getProducts();
		model.addAttribute("products" , products);
		return "index";
	}

	// Show add product form
	@RequestMapping("/addProduct")
	public String addProduct(Model m) {

		m.addAttribute("title", "Add Product");
		return "addProduct";
	}

	// Handle add product
	@RequestMapping(value = "/handleproduct", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest req) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/");
		return redirectView;

	}
	
	
	// Delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(HttpServletRequest req, @PathVariable ("productId") int id) {
		productDao.deleteProduct(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath());
		return redirectView;
	}
	
	//Update handler
	@RequestMapping("/update/{productId}")
	public String updateHandler(@PathVariable ("productId") int id, Model model) {
		Product product = this.productDao.getProduct(id);
		model.addAttribute("product" , product);
		return "updateform";
	}
	
}
