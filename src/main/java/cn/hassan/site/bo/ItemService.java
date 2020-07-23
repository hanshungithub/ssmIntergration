package cn.hassan.site.bo;

import cn.hassan.site.pojo.Items;

import java.util.List;

public interface ItemService {

	List<Items> queryItemList();

	Items queryItemsById(int id);

	void updateItemById(Items items);
}
