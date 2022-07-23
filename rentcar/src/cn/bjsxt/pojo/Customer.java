package cn.bjsxt.pojo;


public class Customer {
	private Integer custId;
	private String identity;
	private String pwd;
	private String name;
	private String address;
	private String phone;
	private String career;
	private Character sex;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer custId, String name, String pwd, Character sex, String identity, String phone,
			String career, String address) {
		super();
		this.custId = custId;
		this.identity = identity;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.career = career;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", identity=" + identity + ", pwd=" + pwd + ", name=" + name
				+ ", address=" + address + ", phone=" + phone + ", career=" + career + ", sex=" + sex + "]";
	}

}
