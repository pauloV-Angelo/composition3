package entities;

public class OrderItem {
private Integer quantity;
private Double price;
private Product p;

public double subTotal() {
	return price*quantity;
}
}
