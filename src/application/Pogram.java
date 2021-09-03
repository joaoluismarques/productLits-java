package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Pogram {
	public static void main(String [] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i = 1; i<= n; i++) {
			System.out.println("Product #" + i + "data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(resp == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsFee));
			}
			if(resp == 'c') {
				product.add(new Product(name, price));
			}
			if(resp =='u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = UsedProduct.sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, manufactureDate));
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : product) {
			System.out.println(p.priceTag());
		}
		
		
		
		
		
		sc.close();
	}

}
