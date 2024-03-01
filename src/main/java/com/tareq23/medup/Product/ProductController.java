package com.tareq23.medup.Product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.base-path}")
public class ProductController {
	
	@Value("${api.base-path}")
    private String baseUrl;
	
	@GetMapping("/check")
	public String check()
	{
		return baseUrl;
	}
}
