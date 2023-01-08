package com.amc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The transport object used to receive requests from ui.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

  protected Integer id;
  protected String description;
  protected String code;
  protected Double vat;
  protected Double sellPrice;
  protected Double buyPrice;
  protected Double stock;
}
