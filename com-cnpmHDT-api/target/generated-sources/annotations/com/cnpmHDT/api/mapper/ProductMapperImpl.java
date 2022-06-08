package com.cnpmHDT.api.mapper;

import com.cnpmHDT.api.dto.product.ProductDto;
import com.cnpmHDT.api.form.product.CreateProductForm;
import com.cnpmHDT.api.form.product.UpdateProductForm;
import com.cnpmHDT.api.storage.model.Category;
import com.cnpmHDT.api.storage.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-02T10:00:50+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product fromCreateProductFormToEntity(CreateProductForm createProductForm) {
        if ( createProductForm == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( createProductFormToCategory( createProductForm ) );
        product.setImage( createProductForm.getProductImage() );
        product.setDescription( createProductForm.getProductDescription() );
        product.setShortDescription( createProductForm.getProductShortDescription() );
        product.setPrice( createProductForm.getProductPrice() );
        product.setName( createProductForm.getProductName() );
        product.setSaleoff( createProductForm.getProductSaleOff() );

        return product;
    }

    @Override
    public void fromUpdateProductFormToEntity(UpdateProductForm updateProductForm, Product product) {
        if ( updateProductForm == null ) {
            return;
        }

        if ( updateProductForm.getProductImage() != null ) {
            product.setImage( updateProductForm.getProductImage() );
        }
        if ( updateProductForm.getProductPrice() != null ) {
            product.setPrice( updateProductForm.getProductPrice() );
        }
        if ( updateProductForm.getProductName() != null ) {
            product.setName( updateProductForm.getProductName() );
        }
        if ( updateProductForm.getProductId() != null ) {
            product.setId( updateProductForm.getProductId() );
        }
        if ( updateProductForm.getProductSaleOff() != null ) {
            product.setSaleoff( updateProductForm.getProductSaleOff() );
        }
    }

    @Override
    public ProductDto fromEntityToAdminDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductSaleOff( product.getSaleoff() );
        productDto.setProductId( product.getId() );
        productDto.setProductName( product.getName() );
        productDto.setProductImage( product.getImage() );
        productDto.setProductCategoryId( productCategoryId( product ) );
        productDto.setProductShortDescription( product.getShortDescription() );
        productDto.setProductPrice( product.getPrice() );
        productDto.setProductDescription( product.getDescription() );

        return productDto;
    }

    @Override
    public List<ProductDto> fromEntityListToProductDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( fromEntityToAdminDto( product ) );
        }

        return list;
    }

    @Override
    public ProductDto fromEntityToClientDtoDetailProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductSaleOff( product.getSaleoff() );
        productDto.setProductId( product.getId() );
        productDto.setProductName( product.getName() );
        productDto.setProductImage( product.getImage() );
        productDto.setProductCategoryId( productCategoryId( product ) );
        productDto.setProductShortDescription( product.getShortDescription() );
        productDto.setProductDescription( product.getDescription() );
        productDto.setProductPrice( product.getPrice() );

        return productDto;
    }

    @Override
    public ProductDto fromEntityToClientDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductSaleOff( product.getSaleoff() );
        productDto.setProductId( product.getId() );
        productDto.setProductName( product.getName() );
        productDto.setProductImage( product.getImage() );
        productDto.setProductCategoryId( productCategoryId( product ) );
        productDto.setProductPrice( product.getPrice() );

        return productDto;
    }

    @Override
    public List<ProductDto> fromEntityListToProductClientDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( fromEntityToClientDto( product ) );
        }

        return list;
    }

    protected Category createProductFormToCategory(CreateProductForm createProductForm) {
        if ( createProductForm == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( createProductForm.getProductCategoryId() );

        return category;
    }

    private Long productCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
