package com.sip.ams.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.Provider;
import com.sip.ams.reposetories.ProviderRepository;

@Controller
@RequestMapping("/provider/")
public class ProviderController {
	@Autowired
	ProviderRepository providerRepository;
	
	@GetMapping("list")
	public String listProviders(Model model) {
		System.out.println(providerRepository.findAll());
		model.addAttribute("providers",providerRepository.findAll());
		return "provider/listProviders";
		}
	
	
}
