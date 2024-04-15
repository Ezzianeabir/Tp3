package org.example;

import java.util.zip.DataFormatException;

public class ProductService {
    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) throws DataFormatException {
        // Appel à la méthode de l'API client
        return productApiClient.getProduct(productId);
    }
}