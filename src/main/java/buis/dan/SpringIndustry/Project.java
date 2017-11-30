package buis.dan.SpringIndustry;

import java.util.List;

public class Project {
	private Player projectOwner;
	private Blueprint blueprint;
	private int quantity;
	private List<Sale> sales;
	private List<ResourceStack> resources;
	private String item;
	private double fees;
	private double currentProfit;
	private String status;
	
	public Project() {
		
	}
	
	public Project(Blueprint blueprint, int runs) {
		this.blueprint = blueprint;
		this.quantity = runs;
		
		List<ResourceStack> blueprintResources = blueprint.getResources();
		for(ResourceStack resource : blueprintResources) {
			for(int i=0; i<projectOwner.getResources().size(); i++) {
				if(projectOwner.getResources().get(i).getType() == resource.getType()) {
					this.resources.add(projectOwner.getResources().get(i).split(runs*resource.getQuantity()));
				}
			}
		}
	}
	
	public Blueprint getBlueprint() {
		return blueprint;
	}	
	public void setBlueprint(Blueprint blueprint) {
		this.blueprint = blueprint;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<Sale> getSales() {
		return sales;
	}
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getCurrentProfit() {
		return currentProfit;
	}
	public void setCurrentProfit(double currentProfit) {
		this.currentProfit = currentProfit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ResourceStack> getResources() {
		return resources;
	}
	public void setResources(List<ResourceStack> resources) {
		this.resources = resources;
	}

	public Player getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(Player projectOwner) {
		this.projectOwner = projectOwner;
	}
	
	
}
