package org.example;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        // Création des mocks pour OrderService et OrderDao
        OrderService orderServiceMock = mock(OrderService.class);
        OrderDao orderDaoMock = mock(OrderDao.class);

        // Création d'une commande factice pour le test
        Order order = new Order(1, "abir");

        // Configuration du comportement des mocks
        when(orderServiceMock.createOrder(order)).thenReturn(true); // Simuler un retour réussi de la méthode createOrder

        // Création de l'objet OrderController avec les mocks
        OrderController orderController = new OrderController(orderServiceMock, orderDaoMock);

        // Appel de la méthode à tester
        orderController.createOrder(order);

        // Vérification que la méthode createOrder a été appelée avec le bon argument
        verify(orderServiceMock).createOrder(order);

        // Vérification que la méthode saveOrder du DAO est appelée uniquement si la méthode createOrder du service retourne true
        if (orderServiceMock.createOrder(order)) {
            verify(orderDaoMock).saveOrder(order);
        } else {
            verify(orderDaoMock, never()).saveOrder(order);
        }
    }
}
