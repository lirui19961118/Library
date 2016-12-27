package test;

import java.util.ArrayList;
import java.util.List;

import cn.edu.xjtu.se.lib.dao.*;
import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.Order;
import cn.edu.xjtu.se.lib.entity.User;

public class Fuck {

	public static void main(String[] args) {
		
		Book book = new Book();
		BookDao bookdao = new BookImpl();
		//int num =Integer.parseInt(request.getParameter("number"));
		book.setIsbn("1");
		book.setBookName("1");
		book.setPublish("1");
		book.setAuthor("1");
		book.setTotal_num(40);
		book.setCan_borrow(40);
		book.setDescribe("asa");
		book.setPicture("scr");
		System.out.println(book.getDescribe());
		bookdao.addBook(book);
		
		
	}

}
