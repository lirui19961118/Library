package cn.edu.xjtu.se.lib.entity;

import java.sql.Date;

public class Order {
	private int UserBookId;
	
	private String idCard;
	private String isbn;
	private Date borrowTime;
	private Date returnTime;
	private String status;
	
	public int getUserBookId() {
		return UserBookId;
	}
	public void setUserBookId(int userBookId) {
		UserBookId = userBookId;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
