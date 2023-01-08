package com.amc.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The java object corresponding to sql table.
 */
@Entity
@Table(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue
  private Integer id;
  @Basic
  private String description;
  @Basic
  private String code;
  @Basic
  private Double vat;
  @Basic
  private Double sellPrice;
  @Basic
  private Double buyPrice;
  @Basic
  private Double stock;
}
