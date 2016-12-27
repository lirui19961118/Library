package test;

import java.util.ArrayList;
import java.util.List;

import cn.edu.xjtu.se.lib.dao.*;
import cn.edu.xjtu.se.lib.entity.Book;
import cn.edu.xjtu.se.lib.entity.Order;
import cn.edu.xjtu.se.lib.entity.User;

public class Fuck {

	public static void main(String[] args) {
		UserDao userdao=new UserImpl();
		String idid = "2141601027";
		System.out.println(idid);
		System.out.println(userdao.searchUserByIdCard(idid).getName());
		
		
	}

}
