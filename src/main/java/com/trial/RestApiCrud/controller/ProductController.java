package com.trial.RestApiCrud.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trial.RestApiCrud.Service.ProductService;
import com.trial.RestApiCrud.dto.ProductCreateRequestDto;
import com.trial.RestApiCrud.dto.ProductResponseDto;
import com.trial.RestApiCrud.dto.ProductUpdateRequestDto;
import com.trial.RestApiCrud.entity.Product;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello User";
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductCreateRequestDto productcreaterequestDto){
		ProductResponseDto productResponseDto = productService.addProduct(productcreaterequestDto);
		return ResponseEntity.ok(productResponseDto);
	}
	
	@GetMapping("/allproducts")
	public ResponseEntity<List<Product>> allProducts() {
		List<Product> products = productService.allProducts();
		return ResponseEntity.ok(products);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
		String status = productService.deleteProduct(id);
		return ResponseEntity.ok(status);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
		ProductResponseDto productResponseDto = productService.updateProduct(id, productUpdateRequestDto);
		return ResponseEntity.ok(productResponseDto);
	}
	

}
