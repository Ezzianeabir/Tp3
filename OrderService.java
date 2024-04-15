package org.example;public class OrderService {
    private OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public boolean createOrder(Order order) {
        // Logique de création de la commande

        // Dans cet exemple, on simule simplement le succès de la création


        return true; // Retourne vrai pour simuler le succès de la création de la commande
    }
}
