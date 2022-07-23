package cn.bjsxt.pojo;

public class Checktable {
	private Integer checkid;
	private String username;
	private Integer rentid;
	private String checkno;
	private String checktime;
	private String problem;
	private Double paying;
	private String type;
	private String flag;
	public Integer getCheckid() {
		return checkid;
	}
	public void setCheckid(Integer checkid) {
		this.checkid = checkid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRentid() {
		return rentid;
	}
	public void setRentid(Integer rentid) {
		this.rentid = rentid;
	}
	public String getCheckno() {
		return checkno;
	}
	public void setCheckno(String checkno) {
		this.checkno = checkno;
	}
	public String getChecktime() {
		return checktime;
	}
	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public Double getPaying() {
		return paying;
	}
	public void setPaying(Double paying) {
		this.paying = paying;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Checktable [checkid=" + checkid + ", username=" + username + ", rentid=" + rentid + ", checkno=" + checkno + ", checktime=" + checktime + ", problem=" + problem + ", paying=" + paying + ", type=" + type + ", flag=" + flag + "]";
	}
	public Checktable(Integer checkid, String username, Integer rentid, String checkno, String checktime, String problem, Double paying, String type, String flag) {
		super();
		this.checkid = checkid;
		this.username = username;
		this.rentid = rentid;
		this.checkno = checkno;
		this.checktime = checktime;
		this.problem = problem;
		this.paying = paying;
		this.type = type;
		this.flag = flag;
	}
	public Checktable() {
		super();
	}
	
	
	
	
	
	

}
