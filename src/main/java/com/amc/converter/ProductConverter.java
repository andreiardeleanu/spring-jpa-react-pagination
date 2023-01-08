package com.amc.converter;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

import com.amc.entities.Product;
import com.amc.model.ProductDto;

/**
 * This class will do the conversion between dto and object.
 */
public interface ProductConverter {

  /**
   * Method to convert from dto to entity.
   *
   * @param dto the dto.
   * @return the corespondent entity
   */
  default Product fromDto(ProductDto dto) {
    return Product.builder().buyPrice(dto.getBuyPrice()).sellPrice(dto.getSellPrice())
        .stock(dto.getStock())
        .code(isNullOrEmpty(dto.getCode()) ? generateCode(dto.getDescription()) : dto.getCode())
        .description(dto.getDescription())
        .vat(dto.getVat()).build();
  }

  /**
   * Method to convert from entity to dto.
   *
   * @param product the product.
   * @return the corespondent dto
   */
  default ProductDto toDto(Product product) {
    return ProductDto.builder().code(product.getCode()).description(product.getDescription())
        .code(product.getCode())
        .id(product.getId())
        .stock(product.getStock()).vat(product.getVat()).sellPrice(product.getSellPrice())
        .buyPrice(product.getBuyPrice()).build();
  }

  /**
   * Used to generate a product code base on product description.
   *
   * @param description the product description
   * @return the corespondent product code
   */
  default String generateCode(String description) {
    int hash = description.hashCode();
    int mask = 255;
    int firstDir = hash & mask;
    return format("%08d", firstDir);
  }
}
