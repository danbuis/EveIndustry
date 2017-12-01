package buis.dan.SpringIndustry;

import java.util.ArrayList;
import java.util.List;

public class Blueprint {
	private String name;
	private int id;
	private int materialEfficiency;
	private int productionEfficiency;
	private List<ResourceStack> resources;
	
	public Blueprint() {
	}
	
	public Blueprint(String name, int id, int materialEfficiency, int productionEfficiency, List<ResourceStack> resources) {
		this.name=name;
		this.id=id;
		this.materialEfficiency=materialEfficiency;
		this.productionEfficiency=productionEfficiency;
		this.resources=resources;
	}
	
	public void populateResourceList() {
		resources = new ArrayList<ResourceStack>();
		for (int i=1; i<=10; i++) {
			resources.add(new ResourceStack());
		}
	}
	
	public Blueprint getExampleBlueprint() {
		ResourceStack Nocxium = new ResourceStack("Nocxium", 4, 0);
		ResourceStack Mexallon = new ResourceStack("Mexallon", 7, 0);
		ResourceStack Pyerite = new ResourceStack("Pyerite", 7, 0);
		ResourceStack Tritanium = new ResourceStack("Tritanium", 856, 0);
		
		ArrayList<ResourceStack> resources = new ArrayList<ResourceStack>();
		resources.add(Nocxium);
		resources.add(Mexallon);
		resources.add(Pyerite);
		resources.add(Tritanium);
		
		return new Blueprint("Warrior SW-300", 1, 10,20, resources);
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaterialEfficiency() {
		return materialEfficiency;
	}
	public void setMaterialEfficiency(int materialEfficiency) {
		this.materialEfficiency = materialEfficiency;
	}
	public int getProductionEfficiency() {
		return productionEfficiency;
	}
	public void setProductionEfficiency(int productionEfficiency) {
		this.productionEfficiency = productionEfficiency;
	}
	public List<ResourceStack> getResources() {
		return resources;
	}
	public void setResources(List<ResourceStack> resources) {
		this.resources = resources;
	}

	public void truncateEmptyStacks() {
		int emptyStacks = 0;
		
		for(ResourceStack stack: resources) {
			if (stack.getType().equalsIgnoreCase("")) {
				emptyStacks++;
			}
		}
		if(emptyStacks!=0 && emptyStacks!=resources.size()) {
		this.resources= resources.subList(0, resources.size()-emptyStacks);
		} else if(emptyStacks==resources.size()){
			this.resources=resources.subList(0,1);
		}
		
		
	}
	
}
