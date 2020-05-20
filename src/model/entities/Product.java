package model.entities;

public class Product {

	private String name;
	private Double price;
	private Integer quantit;

	public Product() {
	}

	public Product(String name, Double price, Integer quantit) {
		this.name = name;
		this.price = price;
		this.quantit = quantit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantit() {
		return quantit;
	}

	public void setQuantit(Integer quantit) {
		this.quantit = quantit;
	}

	@Override
	public String toString() {
		return name + ", " +  String.format("%.2f", (price * quantit));
	}
}
