package cn.edu.xjtu.se.lib.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.jspsmart.upload.SmartUpload;

import org.apache.tomcat.util.http.fileupload.FileItem; 
import org.apache.tomcat.util.http.fileupload.FileUploadException;  

 
import cn.edu.xjtu.se.lib.dao.BookDao;
import cn.edu.xjtu.se.lib.dao.BookImpl;
import cn.edu.xjtu.se.lib.dao.UserDao;
import cn.edu.xjtu.se.lib.dao.UserImpl;
import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.User;
import cn.edu.xjtu.se.lib.unity.StrongPsw;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		//response.setHeader("Content-Type", "text/html; charset=UTF-8");
		  //为解析类提供配置信息  
//        DiskFileItemFactory factory = new DiskFileItemFactory();  
//        //创建解析类的实例  
//        ServletFileUpload sfu = new ServletFileUpload(factory);  
//        //开始解析  
//        sfu.setFileSizeMax(1024*400);  
//        //每个表单域中数据会封装到一个对应的FileItem对象上  
//        try {  
//            List<FileItem> items = sfu.parseRequest(request);  
//            //区分表单域  
//            for (int i = 0; i < items.size(); i++) {  
//                FileItem item = items.get(i);  
//                //isFormField为true，表示这不是文件上传表单域  
//                if(!item.isFormField()){  
//                    ServletContext sctx = getServletContext();  
//                    //获得存放文件的物理路径  
//                    //upload下的某个文件夹   得到当前在线的用户  找到对应的文件夹  
//                      
//                    String path = sctx.getRealPath("/upload");  
//                    System.out.println(path);  
//                    //获得文件名  
//                    String fileName = item.getName();  
//                    System.out.println(fileName);  
//                    //该方法在某些平台(操作系统),会返回路径+文件名  
//                    fileName = fileName.substring(fileName.lastIndexOf("/")+1);  
//                    File file = new File(path+"\\"+fileName);  
//                    if(!file.exists()){  
//                        item.write(file);  
//                        //将上传图片的名字记录到数据库中  
//                          
//                        resp.sendRedirect("/upload/ok.html");  
//                    }  
//                }  
//            }  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
		
		
//		SmartUpload su = new  SmartUpload();
		//su.service(request,response);
		
		Book book=new Book();
		BookDao bookdao = new BookImpl();
		//String f = request.getParameter("picture");
		
		//System.out.println(f);
		int num =Integer.parseInt( request.getParameter("number"));
		book.setIsbn(request.getParameter("isbn"));
		book.setBookName(request.getParameter("bookName"));
		book.setPublish(request.getParameter("publish"));
		book.setAuthor(request.getParameter("author"));
//		int num =Integer.parseInt( su.getRequest().getParameter("number"));
//		book.setIsbn(su.getRequest().getParameter("isbn"));
//		book.setBookName(su.getRequest().getParameter("bookName"));
//		book.setPublish(su.getRequest().getParameter("publish"));
//		book.setAuthor(su.getRequest().getParameter("author"));
		book.setTotal_num(num);
		book.setCan_borrow(num);
		book.setDescribe(request.getParameter("describe"));
		book.setPicture(request.getParameter("picture"));
//		book.setDescribe(su.getRequest().getParameter("describe"));
//		book.setPicture(su.getRequest().getParameter("picture"));
		System.out.println(book);
		bookdao.addBook(book);
	
		
		System.out.println("加入成功");
		
		ArrayList<Book> books = new ArrayList<Book>();
		books = bookdao.displayAllBook();
		
        request.setAttribute("books", books);
        String is = request.getParameter("isbn");
        request.setAttribute("isbns", is);
		request.getRequestDispatcher("views/book/bookPic.jsp").forward(request, response);
	}

}
