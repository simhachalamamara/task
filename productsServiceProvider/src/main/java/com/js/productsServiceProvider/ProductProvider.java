package com.js.productsServiceProvider;

import com.js.exception.NoDataFound;
import com.js.model.Product;
import com.js.service.ProductProvidersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductProvider {

    @Autowired
    private ProductProvidersServices productProvidersServices;

    @GetMapping("/getProductInfo")
    public List<Product> getProductInfo() throws NoDataFound {
        List<Product> listOfProducts = null;
        listOfProducts = productProvidersServices.getProductsInfo();
        if (listOfProducts.isEmpty() && listOfProducts != null) {
            throw new NoDataFound("No Data Found Exception..! make sure database is running properly");
        }
        return listOfProducts;

    }
}

