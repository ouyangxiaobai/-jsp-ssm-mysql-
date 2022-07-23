package cn.bjsxt.pojo;

public class Menu {
	private Integer menuId;
	private String name;
	private String parentid;
	private String url;
	public Menu(Integer menuId, String name, String parentid, String url) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.parentid = parentid;
		this.url = url;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", name=" + name + ", parentid=" + parentid + ", url=" + url + "]";
	}
	
	
}
