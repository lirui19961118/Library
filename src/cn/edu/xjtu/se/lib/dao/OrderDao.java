package cn.edu.xjtu.se.lib.dao;

import java.util.ArrayList;

import cn.edu.xjtu.se.lib.entity.Order;

public interface OrderDao {
	//增加一个借书记录
	Order addOrder(Order o);
	//通过isbn及idCard找到记录删除
	boolean removeOrder(String isbn, String idCard);
	//通过isbn和idCard查找借书记录
	Order searchOrder(String isbn, String idCard);
	//更新借书状态
	boolean updateStatus(String isbn, String idCard, String status);
	//通过idcard查询所有order
	ArrayList<Order> searchByIdcard(String idCard);
	
	boolean removeOrderById(int id);
}
