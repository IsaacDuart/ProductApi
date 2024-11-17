package com.isaacduart.productapi.application.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordCreateDTO(@NotBlank String name, @NotNull BigDecimal price, String description) {
}
