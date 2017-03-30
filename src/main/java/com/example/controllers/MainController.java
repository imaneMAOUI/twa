package com.example.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.beans.*;
import com.example.persistence.*;
import com.example.repositories.PlatRepository;

@Controller
public class MainController {
	@Autowired
	PlatRepository platRepository;
	
	
	/*********************************/
	@GetMapping("/session/login")
	public String loginGet() {
		return "user/login";
	}
	/*
	@PostMapping("/session/login")
	public String loginPost() {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
		return "user/products";
	}*/

	/*********************************/
	@GetMapping("/session/subscribe")
	public String subscribeGet() {
		return "user/subscribe";
	}
	
	@PostMapping("/session/subscribe")
	public String subscribePost() {
		return "user/subscribe";
	}

	/*********************************/
	@GetMapping("/store/products")
	public ModelAndView productsGet() {
		List<Plat> list = platRepository.findAll();
		ModelAndView model= new ModelAndView("user/products");
		model.addObject("list",list);
		return model;
	}

	/*********************************/
	@GetMapping("/store/panier")
	public String panierGet() {
		return "user/subscribe";
	}
	
	/*********************************/
	@GetMapping("/admin/manage/products")
	public String adminGet()
	{
		return "user/manageProducts";
	}
	
	/*********************************/
	@GetMapping("/admin/manage/products/add")
	public String adminAddProductGet(Model model)
	{
		model.addAttribute("plat", new PlatBean());
		return "admin/manageProducts";
	}	
	
	@PostMapping("/admin/manage/products/add")
	public String adminAddProductPost(@ModelAttribute PlatBean platBean)
	{
		Plat plat = new Plat(platBean.getDescription(),platBean.getPrix(),platBean.getQuantite());
		platRepository.save(plat);
		return "user/products";
	}
}
