package it.corrado.controller.impl;

import it.corrado.controller.ProductController;
import it.corrado.dto.ProductDto;
import it.corrado.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    @Autowired
    private final ProductService productService;


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        return productService.updateProduct(productDto,id);
    }

    @Override
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }
}
