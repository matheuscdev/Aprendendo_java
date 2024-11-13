package org.example.models.entities;

import org.example.models.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(){
    }

    public Order(OrderStatus status, Date moment, Client client) {
        this.status = status;
        this.moment = moment;
        this.client = client;
    }

    public OrderStatus getStatus() {

        return status;
    }

    public void setStatus(OrderStatus status) {

        this.status = status;
    }

    public Date getMoment() {

        return moment;
    }

    public void setMoment(Date moment) {

        this.moment = moment;
    }

    public Client getClient() {

        return client;
    }

    public void setClient(Client client) {

        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){

        items.add(item);
    }

    public void removeItem(OrderItem item){

        items.remove(item);
    }

    public Double total(){

        double sum = 0.0;
        for (OrderItem x : items){
             sum += x.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items: \n");

        for (OrderItem x : items){

            sb.append(x + "\n");
        }
        sb.append("Total price: R$");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}
