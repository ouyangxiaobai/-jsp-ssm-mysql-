package cn.bjsxt.pojo;

public class Logtable {
	private int logid;
	private int userid;
	private String username;
	private String action;
	private String actiontime;
	
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActiontime() {
		return actiontime;
	}
	public void setActiontime(String actiontime) {
		this.actiontime = actiontime;
	}
	@Override
	public String toString() {
		return "Logtable [logid=" + logid + ", userid=" + userid + ", username=" + username + ", action=" + action + ", actiontime=" + actiontime + "]";
	}
	public Logtable(int logid, int userid, String username, String action, String actiontime) {
		super();
		this.logid = logid;
		this.userid = userid;
		this.username = username;
		this.action = action;
		this.actiontime = actiontime;
	}
	public Logtable() {
		super();
	}
	
	
}
