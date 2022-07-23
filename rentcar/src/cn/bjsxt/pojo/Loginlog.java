package cn.bjsxt.pojo;

public class Loginlog {
	private int loginid;
	private int userid;
	private String username;
	private String loginip;
	private String logintime;
	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	@Override
	public String toString() {
		return "Loginlog [loginid=" + loginid + ", userid=" + userid + ", username=" + username + ", loginip=" + loginip + ", logintime=" + logintime + "]";
	}
	public Loginlog(int loginid, int userid, String username, String loginip, String logintime) {
		super();
		this.loginid = loginid;
		this.userid = userid;
		this.username = username;
		this.loginip = loginip;
		this.logintime = logintime;
	}
	public Loginlog() {
		super();
	}
	
	
	
}
