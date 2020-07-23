package cn.hassan.site.pojo;

public class QueryVo {
	//商品
	private Items items;

	private Integer ids[];

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
}
