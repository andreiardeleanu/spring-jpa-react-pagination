package com.amc.service;

import static org.h2.util.StringUtils.isNullOrEmpty;

import com.amc.model.ProductDto;
import com.amc.repository.ProductRepository;
import com.amc.util.GenericSpecifications;
import com.amc.util.SearchCriteria;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements  GenericService {

  @Autowired
  private ProductRepository repository;


  public ResponseEntity<List<ProductDto>> search(String description, String code, int end, int start, String order, String sort) {
    LinkedHashMap<String, GenericSpecifications> params = new LinkedHashMap<>();
    if (!isNullOrEmpty(description)) {
      params
          .put("description", new GenericSpecifications(
              new SearchCriteria("description", ":", description)));
    }
    if (!isNullOrEmpty(code)) {
      params
          .put("code", new GenericSpecifications(
              new SearchCriteria("code", ":", code)));
    }
    List<ProductDto> productDtoList = repository.findAll(withSpecification(params), withPage(end, start, order, sort)).getContent();
    return withHeader(productDtoList);
  }
}
