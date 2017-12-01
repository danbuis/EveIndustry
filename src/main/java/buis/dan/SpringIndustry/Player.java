package buis.dan.SpringIndustry;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<ResourceStack> resources = new ArrayList<ResourceStack>();
	private List<Blueprint> blueprints = new ArrayList<Blueprint>();
	private List<Project> projects = new ArrayList<Project>();
	
	public Player() {
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
		
	}
	public void updateBlueprint(Blueprint blueprint, boolean truncate) {
		System.out.println(blueprint.getId());
		if(truncate) {
			blueprint.truncateEmptyStacks();
		}
		blueprints.set(blueprint.getId()-1, blueprint);
		
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

	

}
