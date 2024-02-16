package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
private LocalDateTime moment;
private OrderStatus status;

private Client client;
private List<OrderItem> item = new ArrayList<>();

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

public void addItem(OrderItem item) {
	this.item.add(item);
}

public void removeItem(OrderItem item) {
	this.item.remove(item);
}

public Double total() {
	double sum = 0;
	for(OrderItem oi: item) {
		sum += oi.subTotal();
	}
	return sum;
}

public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("ORDER SUMARY: \n");
	sb.append("Order moment: "+ moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+ "\n");
	sb.append("Order Status: " + status + "\n");
	sb.append(client.toString());
	sb.append("Order items: \n");
	for(OrderItem orderItem: item) {
		sb.append(orderItem.toString());
	}
	sb.append("Total price: $"+ String.format("%.2f", total()));
	return sb.toString();
}



}
