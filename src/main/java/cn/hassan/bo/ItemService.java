package cn.hassan.bo;

import cn.hassan.pojo.Items;

import java.util.List;

public interface ItemService {

	List<Items> queryItemList();

	Items queryItemsById(int id);

	void updateItemById(Items items);
}
