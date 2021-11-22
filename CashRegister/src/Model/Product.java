package Model;

public class Product {
	private String Barcode;
	private String Name;
	private int Price;
	
	public Product(String barcode, String name, int price) {
		super();
		Barcode = barcode;
		Name = name;
		Price = price;
	}

	public String getBarcode() {
		return Barcode;
	}

	public void setBarcode(String barcode) {
		Barcode = barcode;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}
	
	

}
