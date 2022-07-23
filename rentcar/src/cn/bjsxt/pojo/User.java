package cn.bjsxt.pojo;

public class User {
	private Integer userid;
	private String username;
	private String userpwd;
	private String realname;
	private String identity;
	private String sex;
	private String address;
	private String phone;
	private String position;
	private int roleid;
	private Role role;
	public User(Integer userid, String username, String userpwd, String realname, String identity, String sex,
			String address, String phone, String position, int roleid) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.realname = realname;
		this.identity = identity;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.position = position;
		this.roleid = roleid;
	}
	public User() {
		super();
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", realname=" + realname
				+ ", identity=" + identity + ", sex=" + sex + ", address=" + address + ", phone=" + phone
				+ ", position=" + position + ", roleid=" + roleid + "]";
	}
	
	
}
