package cn.edu.xjtu.se.lib.dao;

import java.util.ArrayList;
import java.util.List;

import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.Order;
import cn.edu.xjtu.se.lib.entity.User;

public interface BookDao {
	//增加书籍
	Book addBook(Book book);
	//删除书籍
	boolean removeBook(Book book);
    //更新书籍（改变总书籍和课结束及数量）
	Book updateBook(Book book);
	//通过isbn搜索书籍
	Book searchByIsbn(String isbn);
	//通过书名模糊搜索书籍
	ArrayList<Book> searchByBookName(String bookName);
	//通过作者搜索书籍
	List<Book> searchByAuthor(String author);
	//搜索此学生所借书籍
	List<Order> searchByStu(String idCard);
	//显示所有书籍信息
	ArrayList<Book> displayAllBook();
}
