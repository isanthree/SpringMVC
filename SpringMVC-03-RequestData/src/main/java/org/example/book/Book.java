package org.example.book;

/**
 *
 */
public class Book {
	private String bookName;
	private String author;
	private Double price;
	private Integer stock;
	private String sales;
	private Address address;

	public Book() {
	}

	public Book(String bookName, String author, Double price, Integer stock, String sales) {
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.sales = sales;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Book{" +
				"bookName='" + bookName + '\'' +
				", author='" + author + '\'' +
				", price=" + price +
				", stock=" + stock +
				", sales='" + sales + '\'' +
				", address=" + address +
				'}';
	}
}
