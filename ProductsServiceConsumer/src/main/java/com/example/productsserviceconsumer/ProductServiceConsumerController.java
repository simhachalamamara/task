package com.example.productsserviceconsumer;

import com.example.model.Product;
import com.example.model.ProductList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ProductServiceConsumerController {

    @GetMapping("/getFullProductInfo")
    public List<Product> GetProductInfos() throws Exception
    {
        Product[] productsList = new RestTemplate().getForObject("http://localhost:8080/getProductInfo", Product[].class);
        List<Product> listOfProducts = Arrays.stream(productsList).collect(Collectors.toList());
return listOfProducts;
    }


}
