package it.corrado.controller;

import it.corrado.dto.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
public interface ProductController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductDto createProduct(@RequestBody ProductDto productDto);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductDto updateProduct(@PathVariable(name="id") Long id, @RequestBody ProductDto productDto);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable(name="id")Long id);
}
