package com.amc.service;

import static org.h2.util.StringUtils.isNullOrEmpty;

import com.amc.util.GenericSpecifications;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface GenericService {

  default PageRequest withPage(int end, int start, String order, String sort) {
    PageRequest pageRequest;

    if (isNullOrEmpty(sort)) {
      pageRequest = PageRequest
          .of(start / (end - start), (end - start));
    } else {
      if ("DESC".equals(order)) {
        pageRequest = PageRequest
            .of(start / (end - start), (end - start), Sort.by(sort).descending());
      } else {
        pageRequest = PageRequest
            .of(start / (end - start), (end - start), Sort.by(sort).ascending());
      }
    }
    return pageRequest;
  }

  default ResponseEntity withHeader(List body) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Total-Count", String.valueOf(body.size()));
    return ResponseEntity.ok().headers(headers).body(body);
  }

  default Specification withSpecification(LinkedHashMap<String, GenericSpecifications> params) {
    Specification specification = null;
    if (params.isEmpty()) {
      return specification;
    }
    specification = Specification.where(params.entrySet().stream().findFirst().get().getValue());
    for (int i = 1; i < params.size(); i++) {
      GenericSpecifications value = (new ArrayList<GenericSpecifications>(
          params.values())).get(i);
      specification = specification.and(value);
    }
    return specification;
  }
}
