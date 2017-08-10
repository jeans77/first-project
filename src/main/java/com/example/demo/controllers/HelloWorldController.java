package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Whisper;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	//Create a class named Whisperer that makes Strings lower case
	//Using the method below create a method "Whisper" for a GetMapping that does the same thing *BUT uses Whisperer
	// This means that you should map a GET to the path "whisper"
	// This means you should have a method named "whisper" that returns a ModelAndView
	// returns model and view
	
	@GetMapping("Whisper")
	public ModelAndView Whisper(@RequestParam(required=false, defaultValue="«silence»") String message) {
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		Whisper whisper = new Whisper(message);
		String result = whisper.decapitalize();
		mv.addObject("message", result);
		return mv;
	}
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		Yeller yeller = new Yeller(message);
		String result = yeller.capitalize();
		mv.addObject("message", result);
		return mv;
	}
	// returns model only
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
	//Declaring variable and decoration required importing the Adder Class from resources
		Adder adder = new Adder (first, second);
		double result = adder.calculate();
		
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}

	
}
