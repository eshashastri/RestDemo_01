package com.hsbc.service;

import com.hsbc.entity.Product;
import com.hsbc.exception.InvalidIdException;
import com.hsbc.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public Product saveProduct(Product product){
        return productRepo.save(product);
    }
    public Product findProduct(int id) throws InvalidIdException
    {
        Optional<Product> optProduct= productRepo.findById(id);
        Product product= optProduct.orElseThrow(
                ()->new InvalidIdException("Id is not valid : "+id)
        );
        return product;
    }
    public Product updateProduct(Product product) throws InvalidIdException {
        findProduct(product.getId());
        return productRepo.save(product);
    }
    public Product deleteProduct(int id) throws InvalidIdException{
        Product p = findProduct(id);
        productRepo.deleteById(id);
        return p;
    }
    public List<Product> findProducts(){
        return productRepo.findAll();
    }
    public List<Product> findProductByName(String name)
    {
        List<Product> products=productRepo.findByName(name);
        return products;
    }
    public List<Product> findProductByPartialName(String name){
        return productRepo.findByPartialName(name);
    }

}
