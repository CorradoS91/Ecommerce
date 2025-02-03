package it.corrado.service.impl;

import it.corrado.dto.ProductDto;
import it.corrado.exception.AsinNotFoundException;
import it.corrado.mapper.ProductMapper;
import it.corrado.model.Product;
import it.corrado.repository.ProductRepository;
import it.corrado.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product=productMapper.productDtoToProduct(productDto);
        Optional<Product> productOpt = productRepository.getProductByAsin(product.getAsin());
        if(productOpt.isPresent()){
            throw new AsinNotFoundException(product.getAsin(),"This asin already exists: "+product.getAsin());
        }else{
            productRepository.save(product);
            return productMapper.productToProductDto(product);
        }

    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long asin) {
        Product oldProduct = productRepository.findById(asin).orElseThrow(()->buildAsinNotFoundException(asin));
        productMapper.updateProduct(productDto,oldProduct);
        productRepository.save(oldProduct);
        return productMapper.productToProductDto(oldProduct);
    }

    @Override
    public void deleteProduct(Long id) {

    }
    private RuntimeException buildAsinNotFoundException(Long asin) {
        AsinNotFoundException exception = new AsinNotFoundException();
        exception.setAsinNotFound(asin);
        if (asin != null) {
            String ms = "The following Asin was not found: %d";
            exception.setMessage(String.format(ms, asin));
            return exception;
        }
        return null;
    }
}
