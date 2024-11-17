package com.isaacduart.productapi.application.services.interfaces;

import com.isaacduart.productapi.application.DTO.ProductRecordCreateDTO;
import com.isaacduart.productapi.application.DTO.ProductRecordDTO;
import com.isaacduart.productapi.domain.entities.Product;

import java.util.List;

public interface IProductService {

    ProductRecordDTO createProduct(ProductRecordCreateDTO product);
    ProductRecordDTO updateProduct(ProductRecordDTO product);
    void deleteProduct(Long id);
    ProductRecordDTO getProduct(Long id);
    List<ProductRecordDTO> getProducts();
}
