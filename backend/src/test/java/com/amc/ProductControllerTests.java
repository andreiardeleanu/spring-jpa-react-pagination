package com.amc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
@TestInstance(Lifecycle.PER_CLASS)
class ProductControllerTests {

  private final static String  PRODCUT_PATH ="/product";
  String created;

  @Test
  void testCreate() {
    ResponseEntity<String> resp = rest.postForEntity(
        PRODCUT_PATH,
        product(),
        String.class);

    assertNotNull(resp.getBody());
    created = resp.getBody();
  }

  @Test
  void testUpdate() throws JsonProcessingException {
    JsonNode node = updatedProduct(created);
     rest.put(
        PRODCUT_PATH.concat("/").concat(node.get("id").asText()),
        node,
        String.class);
  }


  private static JsonNode product() {
    return MAPPER.createObjectNode()
        .put("description", "product")
        .put("stock", 10);
  }

  private static JsonNode updatedProduct(String product) throws JsonProcessingException {
    return MAPPER.readTree(product);
  }



  @Autowired
  private TestRestTemplate rest;

  private static final ObjectMapper MAPPER = new ObjectMapper();
}
