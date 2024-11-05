package com.example.webapp.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webapp.model.Shirt;

//@RestController
@Controller
public class WebAppCntroller {
	@GetMapping(value="/get")
	public String getWord() {
		//return "Hello World";
		return "new.html";
	}
	@GetMapping(value="/getnum/{a}/{b}")
	public int getnum(@PathVariable int a, @PathVariable int b) {
		if(a>b)
			return a;
		else
			return b;
	}
	@GetMapping(value="/str/{a}")
	public String getStr(@PathVariable String a) {  
		return a.toUpperCase();
	}
	@GetMapping("/prime/{a}/{b}")
	public int prime(@PathVariable int a,@PathVariable int b) {
		int d =0;
		for(int i=a; i<=b;i++ ) {
			int c= i;
			int count=0;
			for(int j=2; j<c;j++) {
				if(c%j==0)
					count++;
			}
			 if(count==0) {
				 d++;
			 }
		}
		return d;
		
	}
	@GetMapping("/prime1/{a}/{b}")
	public int prime1(@PathVariable int a,@PathVariable int b) {
		int count=0;		
		for(int i=a; i<=b;i++ ) {
			boolean x=false;
			for(int j=2;j<i;j++) {
				if(i%j==0)
					x= true;
			}
		
			if(x==false)
				count++;
			
		}
		return count;
	}
	@GetMapping(value="/getshirt")
	public Shirt getDetails(@RequestBody Shirt a) {
		return a;
	}
	@GetMapping(value="/fabric")
	public String getFabric(@RequestBody Shirt a) {
		return a.getFabric().toUpperCase();
	}
	@GetMapping(value="/price")
	public Shirt getShirt(@RequestBody Shirt a) {
		if(a.isChecked()==true) {
			a.setPrice(a.getPrice()- (a.getPrice()*5/100));
		}
		else {
			a.setPrice(a.getPrice()+ (a.getPrice()*5/100));
		}
		return a;
	}
	@GetMapping(value="/list")
	public List<Shirt> list1 (@RequestBody List<Shirt> a){
		return a;
	}
	@GetMapping(value="/second")
	public Shirt getSecond(@RequestBody List<Shirt> a ) {
		return a.get(1);
	
	}
	@GetMapping(value="/list1")
	public List<String> list2 (@RequestBody List<Shirt> a){
		return a.stream().map(x->x.getBrand()).sorted().toList();
	}
	@GetMapping(value="/max")
	public int list3 (@RequestBody List<Shirt> a){
		return a.stream().map(x->x.getPrice()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	}
	@GetMapping(value="/getAccess")
	public String getThis(@RequestParam String name,@RequestParam String password) {
		if(name.equals("akil")&& password.equals("maran")) 
			return "Success";
			else
				return "Access denied";
				
		}
	}

