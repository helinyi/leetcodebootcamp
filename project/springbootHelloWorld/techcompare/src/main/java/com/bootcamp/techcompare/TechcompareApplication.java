package com.bootcamp.techcompare;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TechcompareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechcompareApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "NYU!!!") String name) {
		return String.format("Hello %s!", name);
	}

	// search bestbuy API with optional filters
	@GetMapping("/search")
	public String searchAndFilter(@RequestParam(value = "query", defaultValue =
	"laptop") String query,
	@RequestParam(value = "category", defaultValue = "abcat0501000") String
	category,
	@RequestParam(value = "brand", defaultValue = "10") int brand,
	@RequestParam(value = "price", defaultValue = "10") int price) {

	String url = "https://api.bestbuy.com/v1/products((search=" + query +
	")&(categoryPath.id=" + category
	+ "))";
	// add optional filters to url
	// fire requests to bestbuy API
	// parse the response
	// return the response

	return String.format("Searching for %s in category %s with pageSize %s and
	page %s", query, category, pageSize,
	page);
	}

	// @GetMapping("/search")
	// public String searchAndFilter(@RequestParam(value = "category", defaultValue
	// = "laptop") String category) {

	// // String url = "https://api.bestbuy.com/v1/products((categoryPath.id=" +
	// // category + "))";
	// // // add optional filters to url
	// // // fire requests to bestbuy API
	// // // parse the response
	// // // return the response

	// // return String.format("Searching for category %s with brand %s and price
	// %s",
	// // category, brand, price);
	// HashMap<String, String> map = new HashMap<>();
	// map.put("key", "value");
	// map.put("foo", "bar");
	// map.put("aa", "bb");
	// return map;
	// }

}
