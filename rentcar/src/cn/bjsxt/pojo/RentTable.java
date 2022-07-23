package cn.bjsxt.pojo;

import java.sql.Date;

public class RentTable {
	private Integer rentid;
	private String userName;
	private String custIdentity;
	private String carNumber;
    private String rentNo;
    private double imprest;
    private double pricePayAble;
    private double realPay;
    private Date beginTime;
    private Date endTime;
    private Date realEndTime;
    private String rentFlag;
	public RentTable(Integer rentid, String userName, String custIdentity, String carNumber, String rentNo, double imprest,
			double pricePayAble, double realPay, Date beginTime, Date endTime, Date realEndTime, String rentFlag) {
		super();
		this.rentid = rentid;
		this.userName = userName;
		this.custIdentity = custIdentity;
		this.carNumber = carNumber;
		this.rentNo = rentNo;
		this.imprest = imprest;
		this.pricePayAble = pricePayAble;
		this.realPay = realPay;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.realEndTime = realEndTime;
		this.rentFlag = rentFlag;
	}
	public RentTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRentid() {
		return rentid;
	}
	public void setRentid(int rentid) {
		this.rentid = rentid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCustIdentity() {
		return custIdentity;
	}
	public void setCustIdentity(String custIdentity) {
		this.custIdentity = custIdentity;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getRentNo() {
		return rentNo;
	}
	public void setRentNo(String rentNo) {
		this.rentNo = rentNo;
	}
	public double getImprest() {
		return imprest;
	}
	public void setImprest(double imprest) {
		this.imprest = imprest;
	}
	public double getPricePayAble() {
		return pricePayAble;
	}
	public void setPricePayAble(double pricePayAble) {
		this.pricePayAble = pricePayAble;
	}
	public double getRealPay() {
		return realPay;
	}
	public void setRealPay(double realPay) {
		this.realPay = realPay;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getRealEndTime() {
		return realEndTime;
	}
	public void setRealEndTime(Date realEndTime) {
		this.realEndTime = realEndTime;
	}
	public String getRentFlag() {
		return rentFlag;
	}
	public void setRentFlag(String rentFlag) {
		this.rentFlag = rentFlag;
	}
	@Override
	public String toString() {
		return "RentTable [rentid=" + rentid + ", userName=" + userName + ", custIdentity=" + custIdentity
				+ ", carNumber=" + carNumber + ", rentNo=" + rentNo + ", imprest=" + imprest + ", pricePayAble="
				+ pricePayAble + ", realPay=" + realPay + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", realEndTime=" + realEndTime + ", rentFlag=" + rentFlag + "]";
	}
    
    
}
