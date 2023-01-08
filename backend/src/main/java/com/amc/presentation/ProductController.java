package com.amc.presentation;

import com.amc.service.ProductService;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller use the exchange data with the ui.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

  @Autowired
  private ProductService service;


  @GetMapping
  public ResponseEntity search(
      @RequestParam(value = "_end", defaultValue = "10") @Min(0) int end,
      @RequestParam(value = "_start", defaultValue = "0") @Min(1) int start,
      @RequestParam(value = "_order", required = false) String order,
      @RequestParam(value = "_sort", required = false) String sort,
      @RequestParam(value = "description", required = false) String description,
      @RequestParam(value = "code", required = false) String code) {
    return service.search(description, code, end, start, order, sort);
  }

}
