package it.corrado.service;

import it.corrado.dto.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto,Long asin);
    void deleteProduct(Long asin);
}
