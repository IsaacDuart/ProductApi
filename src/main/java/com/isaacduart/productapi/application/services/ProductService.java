package com.isaacduart.productapi.application.services;

import com.isaacduart.productapi.application.DTO.ProductRecordCreateDTO;
import com.isaacduart.productapi.application.DTO.ProductRecordDTO;
import com.isaacduart.productapi.application.mapstructprofiles.ProductMapper;
import com.isaacduart.productapi.application.services.interfaces.IProductService;
import com.isaacduart.productapi.domain.entities.Product;
import com.isaacduart.productapi.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductRecordDTO createProduct(ProductRecordCreateDTO product) {
        var productCreate = productMapper.createToEntity(product);
        productRepository.save(productCreate);
        return productMapper.toDTO(productCreate);
    }

    @Override
    public ProductRecordDTO updateProduct(ProductRecordDTO product) {
        var productFind = productMapper.toEntity(product);
        productRepository.save(productFind);
        return productMapper.toDTO(productFind);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductRecordDTO getProduct(Long id) {
        var product = productRepository.findById(id).orElse(null);
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductRecordDTO> getProducts() {
        var products = productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
        return products;
    }
}
