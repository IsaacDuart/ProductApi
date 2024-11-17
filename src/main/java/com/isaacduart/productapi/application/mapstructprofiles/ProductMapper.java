package com.isaacduart.productapi.application.mapstructprofiles;

import com.isaacduart.productapi.application.DTO.ProductRecordCreateDTO;
import com.isaacduart.productapi.application.DTO.ProductRecordDTO;
import com.isaacduart.productapi.domain.entities.Product;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRecordDTO productRecordDTO);
    ProductRecordDTO toDTO(Product product);

    Product createToEntity(ProductRecordCreateDTO productRecordDTO);
    ProductRecordCreateDTO toCreateDTO(Product product);
}
