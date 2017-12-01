package buis.dan.SpringIndustry;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<ResourceStack> resources = new ArrayList<ResourceStack>();
	private List<Blueprint> blueprints = new ArrayList<Blueprint>();
	private List<Project> projects = new ArrayList<Project>();
	private List<ResourceStack> marketValues = new ArrayList<ResourceStack>();
	
	public Player() {
		initializeMarketValues();
	}
	
	/**
	 * constructor to quickly create an example player
	 * @param print
	 */
	
	public Player(Blueprint print) {
		blueprints.add(print);
		resources.add(new ResourceStack("Tritanium", 104350, 500000));
		resources.add(new ResourceStack("Pyerite", 72420, 355238.5));
		resources.add(new ResourceStack("Mexallon", 14670, 923996.5));
		resources.add(new ResourceStack("Isogen", 25262, 1052920.16));
		resources.add(new ResourceStack("Nocxium", 22987, 7163438.81));
		resources.add(new ResourceStack("Zydrine", 2093, 1994252.26));
		resources.add(new ResourceStack("Megacyte", 104, 111663.76));
		
		initializeMarketValues();
		
	}
	public void updateBlueprint(Blueprint blueprint, boolean truncate) {
		System.out.println(blueprint.getId());
		if(truncate) {
			blueprint.truncateEmptyStacks();
		}
		blueprints.set(blueprint.getId()-1, blueprint);
		
	}
	
	public void initializeMarketValues() {
		marketValues.add(new ResourceStack("Veldspar", 1, 14.2));
		marketValues.add(new ResourceStack("Concentrated Veldspar", 1, 14.1));
		marketValues.add(new ResourceStack("Dense Veldspar", 1, 15.7));
		
		marketValues.add(new ResourceStack("Scordite", 1, 17.8));
		marketValues.add(new ResourceStack("Condensed Scordite", 1, 18.2));
		marketValues.add(new ResourceStack("Massive Scordite", 1, 19.0));
		
		marketValues.add(new ResourceStack("Plagioclase", 1, 59.0));
		marketValues.add(new ResourceStack("Azure Plagioclase", 1, 60.0));
		marketValues.add(new ResourceStack("Rich Plagioclase", 1, 66.5));
		
		marketValues.add(new ResourceStack("Pyroxeres", 1, 48.0));
		marketValues.add(new ResourceStack("Solid Pyroxeres", 1, 47.1));
		marketValues.add(new ResourceStack("Viscous Pyroxeres", 1, 51.6));
		
		marketValues.add(new ResourceStack("Kernite", 1, 263));
		marketValues.add(new ResourceStack("Luminous Kernite", 1, 195));
		marketValues.add(new ResourceStack("Fiery Kernite", 1, 197));
		
		marketValues.add(new ResourceStack("Tritanium", 1, 4.64));
		marketValues.add(new ResourceStack("Pyerite", 1, 4.79));
		marketValues.add(new ResourceStack("Mexallon", 1, 62.7));
		marketValues.add(new ResourceStack("Isogen", 1, 41));
		marketValues.add(new ResourceStack("Nocxium", 1, 313));
		marketValues.add(new ResourceStack("Zydrine", 1, 946));
		marketValues.add(new ResourceStack("Megacyte", 1, 1047));
		marketValues.add(new ResourceStack("Morphite", 1, 8400));
	}
	
	
	public List<Blueprint> getBlueprints() {
		return blueprints;
	}
	public void setBlueprints(List<Blueprint> blueprints) {
		this.blueprints = blueprints;
	}
	public List<ResourceStack> getResources() {
		return resources;
	}
	public void setResources(List<ResourceStack> resources) {
		this.resources = resources;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Blueprint save(Blueprint blueprint) {
		blueprint.setId(blueprints.size()+1);
		blueprint.truncateEmptyStacks();
		blueprints.add(blueprint);
		return blueprint;
		
	}

	public void addResourceStack(ResourceStack resource) {
		boolean match=false;
		for(ResourceStack stack:resources){
			if(stack.getType().toUpperCase().equals(resource.getType().toUpperCase())){
				//then we have a match
				stack.addToStack(resource.getQuantity(), resource.getValue());
				match=true;
			}
		}
		
		if(!match){
			//no match found, append
			resources.add(resource);
		}
	}

	public List<ResourceStack> getMarketValues() {
		return marketValues;
	}

	public void setMarketValues(List<ResourceStack> marketValues) {
		this.marketValues = marketValues;
	}

	public void updateResourceValues(List<ResourceStack> marketValuesNew) {
		System.out.println(this.resources.size()+" stacks");
		this.marketValues=marketValuesNew;
		
	}

	

}
