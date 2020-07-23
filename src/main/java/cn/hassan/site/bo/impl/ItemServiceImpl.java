package cn.hassan.site.bo.impl;

import cn.hassan.site.bo.ItemService;
import cn.hassan.site.mapper.ItemsMapper;
import cn.hassan.site.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;

	public List<Items> queryItemList() {
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	public Items queryItemsById(int id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	public void updateItemById(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}
}
