package com.sip.ams.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("providers", providerRepository.findAll());
		return "provider/listProviders";
	}

	@GetMapping("add")
	public String showAddProviderForm(Model model) {
		Provider provider = new Provider();// object dont la valeur desattributs par defaut
		model.addAttribute("provider", provider);
		return "provider/addProvider";
	}

	@PostMapping("add")
	public String addProvider(@Valid Provider provider, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "provider/addProvider";
		}
		providerRepository.save(provider);
		return "redirect:list";
	}

}
