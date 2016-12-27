package cn.edu.xjtu.se.lib.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xjtu.se.lib.dao.BookDao;
import cn.edu.xjtu.se.lib.dao.BookImpl;
import cn.edu.xjtu.se.lib.entity.Book;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		//从requset当中获得流信息
		InputStream fileSource = request.getInputStream();
		String tempFileName = "E:/tempFile";
		//tempFile指向临时文件
		File tempFile = new File(tempFileName);
		//outputStram文件输出流指向这个临时文件
		FileOutputStream outputStream = new FileOutputStream(tempFile);
		byte b[] = new byte[1024];
		int n;
		while(( n = fileSource.read(b)) != -1){
			outputStream.write(b, 0, n);
		}
		//关闭输出流、输入流
		outputStream.close();
		fileSource.close();
				
		//获取上传文件的名称
		RandomAccessFile randomFile = new RandomAccessFile(tempFile,"r");
		randomFile.readLine();
		String str = randomFile.readLine();
		int beginIndex = str.lastIndexOf("=") + 2;
		int endIndex = str.lastIndexOf("\"");
		String filename = str.substring(beginIndex, endIndex);
		System.out.println("filename:" + filename);
				
		//重新定位文件指针到文件头
		randomFile.seek(0);
		long startPosition = 0;
		int i = 1;
		//获取文件内容 开始位置
		while(( n = randomFile.readByte()) != -1 && i <=4){
			if(n == '\n'){
				startPosition = randomFile.getFilePointer();
				i ++;
			}
		}
		startPosition = randomFile.getFilePointer() -1;
		//获取文件内容 结束位置
		randomFile.seek(randomFile.length());
		long endPosition = randomFile.getFilePointer();
		int j = 1;
		while(endPosition >=0 && j<=2){
			endPosition--;
			randomFile.seek(endPosition);
			if(randomFile.readByte() == '\n'){
				j++;
			}
		}
		endPosition = endPosition -1;
		
		//设置保存上传文件的路径
		String realPath = getServletContext().getRealPath("/") + "static/img";
		System.out.println(realPath);
		File fileupload = new File(realPath);
		if(!fileupload.exists()){
			fileupload.mkdir();
		}
		File saveFile = new File(realPath,filename);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile,"rw");
		//从临时文件当中读取文件内容（根据起止位置获取）
		randomFile.seek(startPosition);
		while(startPosition < endPosition){
			randomAccessFile.write(randomFile.readByte());
			startPosition = randomFile.getFilePointer();
		}
		//关闭输入输出流、删除临时文件
		randomAccessFile.close();
		randomFile.close();
		tempFile.delete();
		
		request.setAttribute("result", "上传成功！");
		
		String isbns = request.getParameter("isbns");
		BookDao bd = new BookImpl();
		Book bs = bd.searchByIsbn(isbns);
		bs.setPicture("static/img/" + filename);
		bd.updateBookPic(bs);
		
		ArrayList booklist = new ArrayList();
		booklist = bd.displayAllBook();
		request.setAttribute("books", booklist);
		
		request.getRequestDispatcher("views/book/bookmanager.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
