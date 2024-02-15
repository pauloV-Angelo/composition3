package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Client Data:");
		System.out.print("Name: ");
		String name =sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		String bday = sc.nextLine();
		
		Client client = new Client(name, email, LocalDate.parse(bday,DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		Order order = new Order();
		order.setMoment(LocalDateTime.now());
		order.setClient(client);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String st1 = sc.nextLine();
		OrderStatus os1 = OrderStatus.valueOf(st1);
		order.setStatus(os1);
		System.out.print("How many itens to this order? ");
		int n = sc.nextInt();
	
		for(int i = 0;i<n;i++) {
			sc.nextLine();
			System.out.printf("Enter #%d item data: %n", i+1);
			System.out.print("Product name: ");
			String pName = sc.nextLine();
			System.out.print("Product price: ");
			double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product p = new Product(pName, pPrice);
			OrderItem orderItem = new OrderItem(quantity,pPrice,p);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println(order);
		
		
		sc.close();
	}

}
