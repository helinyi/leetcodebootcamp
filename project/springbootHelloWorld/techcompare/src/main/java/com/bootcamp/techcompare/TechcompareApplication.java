package com.bootcamp.techcompare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
@Validated
//@RequestMapping(value = "/search")
public class TechcompareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechcompareApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "NYU!!!") String name) {
		return String.format("Hello %s!", name);
	}
//	@GetMapping("/searchTest")
//	public ObjectMapper getAllProducts() {
//		ResponseEntity<String> res;
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			String uri = "https://fakestoreapi.com/products";
//			RestTemplate restTemplate = new RestTemplate();
//			String result = restTemplate.getForObject(uri, String.class);
//			res = new ResponseEntity<>(result, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			res = new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return mapper;
//	}
	@GetMapping("/allProducts")
	private ResponseEntity<String> getAllProducts() {
		try {
			String uri = "https://fakestoreapi.com/products";
			RestTemplate restTemplate = new RestTemplate();
			String result = restTemplate.getForObject(uri, String.class);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/search")
	public String searchAndFilter(
			@RequestParam(value = "category", defaultValue = "null") String category,
			@RequestParam(value = "id", defaultValue = "0") int id,
			@RequestParam(value = "price", defaultValue = "-100") double price) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ResponseEntity<String> responseEntity = getAllProducts();

			if(responseEntity.getStatusCode() == HttpStatus.OK) {
				String json = responseEntity.getBody();
				// Assuming json is not null and is a valid JSON string of an array of products
				List<Product> products = mapper.readValue(json, new TypeReference<List<Product>>() {});

				// Filter products
				List<Product> filteredProducts = products.stream()
						.filter(product -> product.getCategory().equalsIgnoreCase(category))
						.filter(product -> product.getId() == id)
						.collect(Collectors.toList());

				// Convert filtered list back to JSON string to return
				return mapper.writeValueAsString(filteredProducts);
			} else {
				// Error fetching products, return appropriate message or handle differently
				return "Error fetching products";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error processing request";
		}
	}


	// search bestbuy API with optional filters
//	@GetMapping("/search")
//	public String searchAndFilter(
//	@RequestParam(value = "category", defaultValue = "laptop") String
//	category,
//	@RequestParam(value = "price", defaultValue = "10") double price) {
//		ObjectMapper mapper = getAllProducts();
//		return null;
//	}

//	String url = "https://api.bestbuy.com/v1/products((search=" + query +
//	")&(categoryPath.id=" + category
//	+ "))";
//	// add optional filters to url
//	// fire requests to bestbuy API
//	// parse the response
//	// return the response
//
//	return String.format("Searching for %s in category %s with pageSize %s and
//	page %s", query, category, pageSize,
//	page);
//	}

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
