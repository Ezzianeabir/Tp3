package org.example;
public class OrderController {
    private OrderService orderService;
    private OrderDao orderDao;

    public OrderController(OrderService orderService, OrderDao orderDao) {
        this.orderService = orderService;
        this.orderDao = orderDao;
    }

    public boolean createOrder(Order order) {
        // Appel de la méthode createOrder du service
        boolean orderCreated = orderService.createOrder(order);

        // Si la commande a été créée avec succès, enregistrer la commande dans le DAO
        if (orderCreated) {
            orderDao.saveOrder(order);
        }

        // Retourner true si la commande a été créée avec succès, sinon false
        return orderCreated;
    }
}
