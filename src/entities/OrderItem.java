package entities;

public class OrderItem {
private Integer quantity;
private Double price;
private Product p;

public OrderItem() {
	
}


public OrderItem(Integer quantity, Double price, Product p) {
	this.quantity = quantity;
	this.price = price;
	this.p = p;
}


public Integer getQuantity() {
	return quantity;
}


public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}


public Product getP() {
	return p;
}


public void setP(Product p) {
	this.p = p;
}


public double subTotal() {
	return price*quantity;
}
}
