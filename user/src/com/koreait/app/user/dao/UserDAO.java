package com.koreait.app.user.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.user.mybatis.SqlMapConfig;


public class UserDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	public UserDAO() {
		// autocommit
		sqlsession = factory.openSession(true);
	}
	
	public boolean join(UserDTO user) {
		boolean result = false;
		
		if(sqlsession.insert("User.join", user) != 0) {
			result = true;
		}
		
		return result;
	}

	public boolean login(String userid, String userpw) {
		boolean result = false;
		
		HashMap<String, String> datas = new HashMap<>();
		datas.put("userid", userid);
		datas.put("userpw", userpw);
		
		if( (Integer)sqlsession.selectOne("User.login", datas) == 1) {
			result = true;
			
		}
		
		
		
		return result;
	}
	
}

















