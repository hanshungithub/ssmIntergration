package cn.hassan.site.controller;

import cn.hassan.site.bo.ItemService;
import cn.hassan.common.exception.MyException;
import cn.hassan.site.pojo.Items;
import cn.hassan.site.pojo.QueryVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("item")
public class ItemController {

	Logger logger = Logger.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;

	@RequestMapping("/itemList.action")
	public ModelAndView queryItemList() {
		List<Items> list = itemService.queryItemList();
		ModelAndView view = new ModelAndView();
		view.addObject("itemList", list);
		view.setViewName("itemList");
		return view;
	}

	/**
	 * 利用ModelAndView向页面传数据
	 * @param request
	 * @return
	 */
	//@RequestMapping("/itemEdit.action")
	public ModelAndView queryItemsById(HttpServletRequest request) {
		String id = request.getParameter("id");
		Items items = itemService.queryItemsById(Integer.parseInt(id));
		ModelAndView view = new ModelAndView();
		view.addObject("item", items);
		view.setViewName("editItem");
		return view;
	}

	/**
	 * 利用model向页面传数据
	 * @param request
	 * @param model
	 * @return
	 */
	//@RequestMapping("/itemEdit.action")
	public String queryItemsById(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		Items items = itemService.queryItemsById(Integer.parseInt(id));
		model.addAttribute("item", items);
		return "editItem";
	}

	/**
	 *
	 * @param id @RequestParam 常用于处理简单类型的绑定前端传过来的是itemId 而我们的接收参数是id 则可以用此注解转换
	 * @param model ModelMap是model的实现类，和model的作用一样
	 * @return
	 */
	@RequestMapping("/itemEdit.action")
	public String queryItemsById(@RequestParam(value = "itemId",required = true,defaultValue = "1") Integer id, ModelMap model) {
		Items items = itemService.queryItemsById(id);
		model.addAttribute("items", items);
		return "editItem";
	}

	//@RequestMapping("/updateitem")
	public String updateItem(QueryVo vo){
		Items items = vo.getItems();
		itemService.updateItemById(items);
		return "success";
	}

	@RequestMapping("queryItem")
	public String queryItem(QueryVo vo,Integer ids[]) {
		//System.out.println(vo.getItems().getId());
		//System.out.println(vo.getItems().getName());

		System.out.println(vo.getIds().length);
		System.out.println(ids.length);
		return "success";
	}


	/**
	 * 查询商品列表（异常测试打开）
	 *
	 * @return
	 * @throws Exception
	 */
	//@RequestMapping(value = { "itemList", "itemListAll" })
	public ModelAndView queryItemLists() throws Exception {
		// 自定义异常
		if (true) {
			throw new MyException("自定义异常出现了~");
		}
		// 查询商品数据
		List<Items> list = itemService.queryItemList();
		// 创建ModelAndView,设置逻辑视图名
		ModelAndView mv = new ModelAndView("itemList");
		// 把商品数据放到模型中
		mv.addObject("itemList", list);
		return mv;
	}

	/**
	 * 更新商品
	 *
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateItem")
	public String updateItemById(QueryVo vo, MultipartFile pictureFile) throws Exception {
		Items item = vo.getItems();
		// 图片上传
		// 设置图片名称，不能重复，可以使用uuid
		String picName = UUID.randomUUID().toString();
		// 获取文件名
		String oriName = pictureFile.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));
		// 开始上传
		pictureFile.transferTo(new File("F:\\webupload\\images\\" + picName + extName));
		// 设置图片名到商品中
		item.setPic(picName + extName);
		// ---------------------------------------------
		// 更新商品
		this.itemService.updateItemById(item);

		return "forward:/itemEdit.action";
	}

	//json数据交互
	@RequestMapping(value = "/json.action")
	public @ResponseBody Items json(@RequestBody Items items){
		return items;
	}

	/**
	 * 使用RESTful风格开发接口，实现根据id查询商品
	 * 如果@RequestMapping中表示为"item/{id}"，id和形参名称一致，@PathVariable不用指定名称。如果不一致，例如"item/{ItemId}"则需要指定名称@PathVariable("itemId")
	 * @param id
	 * @return
	 */
	@RequestMapping("item/{id}")
	@ResponseBody
	public Items queryItemById(@PathVariable() Integer id) {
		Items item = itemService.queryItemsById(id);
		return item;
	}
}
