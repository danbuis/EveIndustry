package buis.dan.SpringIndustry;
/**
 * Class representing sale of some items.
 * @author dbuis
 *
 */
public class Sale {
	private String item;
	private int quantity;
	private double pricePerItem;
	
	public Sale() {
		
	}
	
	public Sale(String item, int quantity, double pricePerItem) {
		this.item = item;
		this.quantity = quantity;
		this.pricePerItem=pricePerItem;
	}
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	
}
