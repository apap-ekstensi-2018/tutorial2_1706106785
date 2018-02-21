package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Controller
public class PageController {

	@RequestMapping("/hello123")
	public String hello()
	{
		return "hello";
	}
	
	/*@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name",required = false, defaultValue = "dunia") String name, Model model)
	{
		model.addAttribute("name",name);
		return "greeting";
	}*/
	@RequestMapping(value = {"/greeting","greeting/{name}"})
	public String greetingPath (@PathVariable Optional<String> name,Model model)
	{
		if(name.isPresent())
		{
			model.addAttribute("name" , name.get());
		}
		else
		{
			model.addAttribute("name","apap");
		}
		
		return "greeting";
	}
	
	@RequestMapping(value = {"/perkalian","perkalian/{a}","perkalian/{b}","perkalian/{c}"})
	public String Perkalian (@PathVariable Optional<String> a,Optional <String> b,Model model)
	{
		if(a.isPresent())
		{
			model.addAttribute("a",a.get());
		}
		else
		{
			model.addAttribute("a",0);
		}
		
		if(b.isPresent())
		{
			model.addAttribute("b",b.get());
		}
		else
		{
			model.addAttribute("b",0);
		}
		
		int a1 = Integer.parseInt(a.get());
		int b1 = Integer.parseInt(b.get());
		
		model.addAttribute("c",a1*b1);
		
		return "perkalian";
	}
}
