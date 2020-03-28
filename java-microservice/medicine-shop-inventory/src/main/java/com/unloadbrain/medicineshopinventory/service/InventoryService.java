package com.unloadbrain.medicineshopinventory.service;

import com.unloadbrain.medicineshopinventory.domain.model.Product;
import com.unloadbrain.medicineshopinventory.domain.repository.ProductRepository;
import com.unloadbrain.medicineshopinventory.dto.request.ProductCreateRequest;
import com.unloadbrain.medicineshopinventory.dto.response.IdentityResponse;
import com.unloadbrain.medicineshopinventory.dto.response.ProductResponse;
import com.unloadbrain.medicineshopinventory.dto.response.ProductsResponse;
import com.unloadbrain.medicineshopinventory.util.UuidUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class InventoryService {

    private final ProductRepository productRepository;
    private final UuidUtil uuidUtil;

    public ProductsResponse listByPage(Pageable pageable) {

        Page<Product> productPage = productRepository.findAll(pageable);

        long totalElements = productPage.getTotalElements();
        int totalPage = productPage.getTotalPages();
        int size = productPage.getSize();
        int page = productPage.getNumber();

        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Product product : productPage.getContent()) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setDescription(product.getDescription());
            productResponse.setPurchasePrice(product.getPurchasePrice());
            productResponse.setExpire(product.getExpire());
            productResponse.setStock(product.getStock());
            productResponseList.add(productResponse);
        }

        return ProductsResponse.builder()
                .items(productResponseList)
                .page(page)
                .size(size)
                .totalPages(totalPage)
                .totalElements(totalElements)
                .build();

    }

    public IdentityResponse create(ProductCreateRequest productCreateRequest) {

        String id = uuidUtil.getUuid();

        Product product = new Product();
        product.setId(id);
        product.setName(productCreateRequest.getName());
        product.setDescription(productCreateRequest.getDescription());
        product.setPurchasePrice(productCreateRequest.getPrice());
        product.setExpire(productCreateRequest.getExpireDate());
        productRepository.save(product);

        return new IdentityResponse(id);
    }

}
