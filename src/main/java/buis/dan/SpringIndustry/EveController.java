package buis.dan.SpringIndustry;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EveController {
	
	private static final Logger logger = LoggerFactory.getLogger(EveController.class);
	private Blueprint bp = new Blueprint();
	public Player player= new Player(bp.getExampleBlueprint());
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		return "redirect:/player_assets";
	}
	
	@RequestMapping(value = "/player_assets")
	public String listPlayerAssets(Model model) {
		logger.info("Player Assets");
		List<ResourceStack> resources = player.getResources();
		model.addAttribute("resources", resources);
		List<Blueprint> blueprints = player.getBlueprints();
		model.addAttribute("blueprints", blueprints);
		return "PlayerAssets";
	}
	
	@RequestMapping(value = "/blueprint_edit/{id}")
	public String editBlueprint(Model model, @PathVariable int id) {
		Blueprint blueprint = player.getBlueprints().get(id-1);
		logger.info("updating blueprint " + id);
		model.addAttribute("blueprint", blueprint);
		model.addAttribute("resources", blueprint.getResources());
		return "BlueprintEditForm";
	}
	
	@RequestMapping(value = "/blueprint_update", params="updateComplete")
	public String updateBlueprint(@ModelAttribute Blueprint blueprint) {
		player.updateBlueprint(blueprint, true);
		logger.info("updated blueprint -id:"+blueprint.getId());
		return "redirect:/player_assets";
	}
	
	@RequestMapping(value = "/blueprint_update", params="addResource")
	public String updateBlueprintNewResource(@ModelAttribute Blueprint blueprint) {
		logger.info("updating blueprint with a new resource slot");
		List<ResourceStack> resources= blueprint.getResources();
		resources.add(new ResourceStack());
		blueprint.setResources(resources);
		player.updateBlueprint(blueprint, false);
		return "redirect:/blueprint_edit/"+blueprint.getId();
	}
	
	@RequestMapping(value = "/new_blueprint")
		public String openNewBlueprintForm(Model model) {
			Blueprint blueprint = new Blueprint();
			blueprint.populateResourceList();
			model.addAttribute("blueprint", blueprint);
			return "NewBlueprintForm";
	}
	
	@RequestMapping(value="/blueprint_save")
	public String saveBlueprint(@ModelAttribute Blueprint blueprint) {
		player.save(blueprint);
		return "redirect:/player_assets";		
	}
	
	@RequestMapping(value="/delete_blueprint")
	public String deleteBlueprint(Model model) {
		model.addAttribute("blueprintList", player.getBlueprints());
		model.addAttribute("player", player);
		return "DeleteBlueprintVerify";
	}
	
	@RequestMapping(value="/delete_blueprint_verify", params="cancelDelete")
	public String cancelDeleteBlueprint() {
		return "redirect:/player_assets";
	}
	
	@RequestMapping(value="/delete_blueprint_verify", params="confirmDelete")
	public String confirmDeleteBlueprint(@ModelAttribute Blueprint blueprint) {
		player.deleteBlueprint(blueprint);
		return "redirect:/player_assets";
	}
	
	@RequestMapping(value="/items_purchase")
	public String addPurchasedItems(Model model){
		model.addAttribute("stack", new ResourceStack());
		return "AddPurchasedItems";
	}
	
	@RequestMapping(value="/update_resource_stacks")
	public String updateResourceStacks(@ModelAttribute ResourceStack resource){
		logger.info("updating resource stack");
		player.addResourceStack(resource);
		return "redirect:/player_assets";	
	}
	
	@RequestMapping(value="/nerd")
	public String updateResourceValues(Model model) {
		logger.info("updating market value of resources");
		model.addAttribute("player", player);
		return "UpdateResourceValues";
	}
	
	@RequestMapping(value="/resource_update")
	public String updateResourceValuesComplete(@ModelAttribute Player player) {
		logger.info("update of market values complete");
		logger.info(this.player.getResources().size()+" stacks");
		this.player.updateResourceValues(player.getMarketValues());
		return "redirect:/player_assets";
	}
}
