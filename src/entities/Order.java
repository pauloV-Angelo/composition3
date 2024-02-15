package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
private LocalDateTime moment;
private OrderStatus status;

private Client client;
private List<OrderItem> orderItens = new ArrayList<>();

public Order() {
	
}

public Order(LocalDateTime moment, OrderStatus status, Client client) {
	this.moment = moment;
	this.status = status;
	this.client = client;
}

public LocalDateTime getMoment() {
	return moment;
}

public void setMoment(LocalDateTime moment) {
	this.moment = moment;
}

public OrderStatus getStatus() {
	return status;
}

public void setStatus(OrderStatus status) {
	this.status = status;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public List<OrderItem> getOrderItens() {
	return orderItens;
}

public void addItem(OrderItem item) {
	orderItens.add(item);
}

public void removeItem(OrderItem item) {
	orderItens.remove(item);
}

public Double total() {
	//placeholder implementado em breve
	return 2.0*5;
}



}
