package kr.co.gardener.admin.controller.forests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.forest.list.PlantLevelList;
import kr.co.gardener.admin.model.forest.list.PlantList;
import kr.co.gardener.admin.service.forest.PlantLevelService;
import kr.co.gardener.admin.service.forest.PlantService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/plants")
public class PlantsController {
	final String path = "/admin/forests/plants/";
	
	@Autowired
	private PlantService plantService;
	
	@Autowired
	private PlantLevelService plantLevelService;
	
	
	@RequestMapping({"", "/"})
	public String index() {
		return path + "main"; 
	}
	
	// 식물관리 대량 --------------------------------------------
		@RequestMapping("/api/plant")
		@ResponseBody
		public PlantList plantList(Pager pager) {
			PlantList item = plantService.list_pager(pager);
			return item;
		}

		@ResponseBody
		@PostMapping("/add/plant")
		public String plantAdd(@RequestBody PlantList list) {
			plantService.insert_list(list);
			return "ok";
		}

		@ResponseBody
		@RequestMapping("/delete/plant")
		public String plantDelete(@RequestBody PlantList list) {
			plantService.delete_list(list);
			return "ok";
		}

		@ResponseBody
		@PostMapping("/update/plant")
		public String plantUpdate(@RequestBody PlantList list) {
			plantService.update_list(list);
			return "ok";
		}

		// 식물 레벨 관리 대량 --------------------------------------------
			@RequestMapping("/api/plantLevel")
			@ResponseBody
			public PlantLevelList plantLevelList(Pager pager) {
				PlantLevelList item = plantLevelService.list_pager(pager);
				return item;
			}

			@ResponseBody
			@PostMapping("/add/plantLevel")
			public String plantLevelAdd(@RequestBody PlantLevelList list) {
				plantLevelService.insert_list(list);
				return "ok";
			}

			@ResponseBody
			@RequestMapping("/delete/plantLevel")
			public String plantLevelDelete(@RequestBody PlantLevelList list) {
				plantLevelService.delete_list(list);
				return "ok";
			}

			@ResponseBody
			@PostMapping("/update/plantLevel")
			public String plantLevelUpdate(@RequestBody PlantLevelList list) {
				plantLevelService.update_list(list);
				return "ok";
			}
}
