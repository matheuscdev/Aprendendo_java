package org.example.entities;

import org.example.entities.enums.OrderStatus;

import java.util.Date;

public class Order {

    private Date moment;
    private OrderStatus status;

    private Client client;
    private OrderItem orderItem;



}
