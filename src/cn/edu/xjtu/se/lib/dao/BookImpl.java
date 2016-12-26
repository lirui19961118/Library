package cn.edu.xjtu.se.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.Order;
import cn.edu.xjtu.se.lib.entity.User;

public class BookImpl implements BookDao {
	//数据库连接对象
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		String isbn = book.getIsbn();
		String bookName = book.getBookName();
		String author = book.getAuthor();
		String publish = book.getPublish();
		String describe = book.getDescribe();
		String picpath = book.getPicture();
		int total_num = book.getTotal_num();
		int can_borrow = book.getCan_borrow();
		
		conn = DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return null;
		}
		try {
			String sql="" +
					"insert into book" +
					"(isbn,bookName,publish,author,total_num,can_borrow,describe,picture)" +
					"values(" +
					"?,?,?,?,?,?,?,?)";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			System.out.println(sql);
			ptmt.setString(1, isbn);
			ptmt.setString(2, bookName);
			ptmt.setString(3, publish);
			ptmt.setString(4, author);
			ptmt.setInt(5, total_num);
			ptmt.setInt(6, can_borrow);
			ptmt.setString(7, describe);
			ptmt.setString(8, picpath);
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return book;
	}

	@Override
	public boolean removeBook(Book book) {
		// TODO Auto-generated method stub
		boolean flag = true;
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return false;
		}
		
		try {
			String sql="" +
					" delete from Book " +
					" where isbn=? ";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, book.getIsbn());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return flag;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		if(conn == null){
			System.out.println("数据库没有连接");
			return null;
		}
		
		try {
			String sql="" +
					" update Book " +
					" set total_num=?, can_borrow=? " +
					" where isbn=? ";
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, book.getTotal_num());
			ptmt.setInt(2, book.getCan_borrow());
			ptmt.setString(3, book.getIsbn());
			ptmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(conn, st, rs);
		}
		return book;
	}

	@Override
	public Book searchByIsbn(String isbn) {
		// TODO Auto-generated method stub
		Connection conn=DBConnection.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from Book ");
		sb.append(" where isbn=?");
		Book b = null;
		try {
			PreparedStatement ptmt;
			ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, isbn);
			
			System.out.println(sb.toString());
			ResultSet rs=ptmt.executeQuery();
			while(rs.next()){
				b = new Book();
				b.setIsbn(rs.getString("isbn"));
				b.setAuthor(rs.getString("author"));
				b.setBookName(rs.getString("bookName"));
				b.setCan_borrow(rs.getInt("can_borrow"));
				b.setDescribe(rs.getString("describe"));
				b.setPicture(rs.getString("picture"));
				b.setPublish(rs.getString("publish"));
				b.setTotal_num(rs.getInt("total_num"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}

		return b;
	}

	@Override
	public ArrayList<Book> searchByBookName(String bookName) {
		// TODO Auto-generated method stub
		ArrayList<Book> result = new ArrayList<Book>();
		String sql = "select * from Book where bookName like '%"+bookName+"%'";
		result = new QueryList().queryReturnList(sql);
		return result;
	}

	@Override
	public List<Book> searchByAuthor(String author) {
		// TODO Auto-generated method stub
		ArrayList<Book> result = new ArrayList<Book>();
		String sql = "select * from Book where author='"+author+"'";
		result = new QueryList().queryReturnList(sql);
		return result;
	}

	@Override
	public List<Order> searchByStu(String idCard) {
		// TODO Auto-generated method stub
		ArrayList<Order> result = new ArrayList<Order>();
		String sql = "select * from User_Book where idCard='"+idCard+"'";
		result = new QueryList().queryReturnList(sql);
		return result;
	}
	
	@Override
	public ArrayList<Book> displayAllBook() {
		// TODO 自动生成的方法存根
		ArrayList<Book> b = new ArrayList<Book>();
		String sql = "select * from book";
		b = new QueryList().queryReturnList(sql);
		return b;
	}

}
