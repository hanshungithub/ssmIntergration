package cn.hassan.bo.impl;

import cn.hassan.bo.ItemService;
import cn.hassan.mapper.ItemsMapper;
import cn.hassan.pojo.Items;
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
