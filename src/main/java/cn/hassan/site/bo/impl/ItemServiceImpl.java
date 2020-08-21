package cn.hassan.site.bo.impl;

import cn.hassan.site.bo.ItemService;
import cn.hassan.site.mapper.ItemsMapper;
import cn.hassan.site.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

	@Transactional
	public void B() {
		Items items = new Items();
		items.setName("Mac book Pro");
		items.setPrice((float) 18000);
		items.setDetail("very good");
		items.setCreatetime(new Date());
		itemsMapper.insert(items);
		System.out.println(1/0);
	}
}
