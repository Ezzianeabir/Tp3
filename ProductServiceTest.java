package org.example;
import java.util.zip.DataFormatException;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ProductServiceTest {

    @Test
    public void testGetProduct_Successful() throws DataFormatException {
        // Création du mock ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Configuration du comportement du mock
        Product expectedProduct = new Product("123", "Product Name", 10.99);
        when(productApiClientMock.getProduct("123")).thenReturn(expectedProduct);

        // Création de l'objet ProductService avec le mock
        ProductService productService = new ProductService(productApiClientMock);

        // Appel de la méthode à tester
        Product actualProduct = productService.getProduct("123");

        // Vérification que la méthode getProduct du mock est appelée avec le bon argument
        verify(productApiClientMock).getProduct("123");

        // Vérification que le produit retourné est celui attendu
        assertEquals(expectedProduct, actualProduct);
    }
    @Test
    public void testGetProduct_DataFormatIncompatible() {
        // Création du mock pour ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Configurer le comportement du mock pour lancer une DataFormatException
        when(productApiClientMock.getProduct(anyString())).thenThrow(DataFormatException.class);

        // Création du ProductService avec le mock ProductApiClient
        ProductService productService = new ProductService(productApiClientMock);

        // Appel de la méthode à tester et vérification de l'exception
        assertThrows(DataFormatException.class, () -> productService.getProduct("123"));
    }
    @Test
    public void testGetProduct_ApiCallFailure() {
        // Création du mock ProductApiClient
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);

        // Configuration du comportement du mock
        when(productApiClientMock.getProduct("789")).thenThrow(new ApiCallException("Failed to call API"));

        // Création de l'objet ProductService avec le mock
        ProductService productService = new ProductService(productApiClientMock);

        // Appel de la méthode à tester et vérification de l'exception levée
        assertThrows(ApiCallException.class, () -> {
            productService.getProduct("789");
        });

        // Vérification que la méthode getProduct du mock est appelée avec le bon argument
        verify(productApiClientMock).getProduct("789");
    }

}
