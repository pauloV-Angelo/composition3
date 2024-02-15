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
	double sum = 0;
	for(OrderItem oi: orderItens) {
		sum += oi.subTotal();
	}
	return sum;
}

public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("ORDER SUMARY: \n");
	sb.append("Order moment: "+ moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+ "\n");
	sb.append("Order Status: " + status.toString() + "\n");
	sb.append("Client: " + client.getName()+" (" +client.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +") - " + client.getEmail() +"\n" );
	sb.append("Order items: \n");
	for(OrderItem orderItem: orderItens) {
		sb.append(orderItem.getP().getName()+", $"+ String.format("%.2f", orderItem.getP().getPrice()) +", Quantity: "+orderItem.getQuantity()+ ", SubTotal: "+String.format("%.2f", orderItem.subTotal())+"\n");
	}
	sb.append("Total price: $"+ String.format("%.2f", total()));
	return sb.toString();
}



}
