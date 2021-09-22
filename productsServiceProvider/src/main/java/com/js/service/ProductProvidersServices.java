package com.js.service;

import com.js.dao.ProductProvidersDao;
import com.js.exception.NoDataFound;
import com.js.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductProvidersServices {
           @Autowired
    private ProductProvidersDao productProvidersDao;

    public List<Product> getProductsInfo() {

        List<Product>  listOfProducts = productProvidersDao.findAll();


       /* Optional<List<Product>> listOfProducts1 = Optional.ofNullable(listOfProducts);
        Optional<Product> emptyListProduct = listOfProducts1.empty();
       if(emptyListProduct.isPresent())
        {
            System.out.println("Entering into Service layer .....");
            listOfProducts1.orElseThrow(()->new NoDataFound("No Data found on DataBase..!"));
        }*/
        return listOfProducts;
    }
}
