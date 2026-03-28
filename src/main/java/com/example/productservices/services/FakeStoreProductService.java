package com.example.productservices.services;

import com.example.productservices.dtos.FakeStoreProductDto;
import com.example.productservices.exceptions.ProductNotFoundException;
import com.example.productservices.models.Category;
import com.example.productservices.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    //this service implementation uses FakeStore to fetch products from

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product getProductById(long productId){
        //make an api call to FakeStore and get the product with the given id
        FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("product with id " + productId + " doesn't exist.");
        }
        //convert fakeStoreProductDto object into a Product object

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] fakeStoreProductDtos=restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }
}
