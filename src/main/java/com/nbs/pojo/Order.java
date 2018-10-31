package com.nbs.pojo;



import java.util.Date;
import java.util.List;

public class Order {
	
	private String orderId;
	private Long userId;
	private Date createDate;
	private Date updateDate;
	private List<OrderDetail> orderDetails;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Order(String orderId, Long userId, Date createDate, Date updateDate, List<OrderDetail> orderDetails) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.orderDetails = orderDetails;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", orderDetails=" + orderDetails + "]";
	}
	
	

}
