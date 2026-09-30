package com.trial.RestApiCrud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trial.RestApiCrud.dto.ProductCreateRequestDto;
import com.trial.RestApiCrud.dto.ProductResponseDto;
import com.trial.RestApiCrud.dto.ProductUpdateRequestDto;
import com.trial.RestApiCrud.entity.Product;
import com.trial.RestApiCrud.repository.ProductRepository;

@Service
public class ProductService {
	
	public ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ProductResponseDto addProduct(ProductCreateRequestDto productcreaterequestDto) {
		
		Product product = new Product();
		
		product.setName(productcreaterequestDto.getName());
		
		product.setPrice(productcreaterequestDto.getPrice());
		
		productRepository.save(product);
		
		ProductResponseDto productResponseDto = new ProductResponseDto();
		
		productResponseDto.setName(product.getName());
		productResponseDto.setMsg(product.getName() + " added Successfully.");
		
		return productResponseDto;
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Product deleted.";
	}
	
	public ProductResponseDto updateProduct(Long id,ProductUpdateRequestDto productUpdateRequestDto) {
		
		Product fetchedProduct = productRepository.findById(id)
				.orElseThrow(()-> 
				new RuntimeException("User not found with id " + id));
		
		fetchedProduct.setName(productUpdateRequestDto.getName());
		fetchedProduct.setPrice(productUpdateRequestDto.getPrice());
		
		productRepository.save(fetchedProduct);
		
		ProductResponseDto productResponseDto = new ProductResponseDto();
		
		productResponseDto.setName(fetchedProduct.getName());
		productResponseDto.setMsg("Product updated.");
		
		return productResponseDto;
	}
}
