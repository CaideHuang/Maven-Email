package com.web.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.email.SendEmail;
import com.web.mapper.UserMapper;
import com.web.pojo.User;

@Service
public class WebService {

	@Autowired
	UserMapper userMapper;

	private final static String URL = "http://localhost:8080/manager-web/";

	/*
	 * 添加用户信息
	 */
	@Transactional
	public int insertUser(String email, String password) throws Exception {
		int num = userMapper.insertUser(email,doPassword(password),doCode(email, password));
		
		String context="<p>尊敬的"+email+"用户：</p><p style=text-indent:2em>感谢您注册我们的网站，但是注册之后需要你继续完成用户激活:<a href="+URL+"register.do?code="+doCode(email, password)+"&email="+email+">"+URL+"register.do?code="+doCode(email, password)+"&email="+email+"</a></p>";
		
		//发送邮件操作
		sendMail(email, "用户激活验证",context);
		
		return num;
	}

	/*
	 * 密码加密
	 */
	public static String doPassword(String password) {
		String password_md5 = DigestUtils.md5Hex(password);
		return password_md5;
	}

	/*
	 * 生成code
	 */
	public static String doCode(String email, String password) {
		String code = DigestUtils.md5Hex(email + password);
		return code;
	}

	/*
	 * 发送邮件
	 */
	public void sendMail(String to, String title, String context) throws Exception {
		SendEmail.sendMail(to, title, context);
	}

	/*
	 * 查询用户列表
	 */
	@Transactional
	public List<User> selectUserList() {
		List<User> users = userMapper.selectUserList();
		return users;
	}

	@Transactional
	public int updateUserState(String email) {
		int num = userMapper.updateUserState(email);
		return num;
	}

	@Transactional
	public User selectUserByEmail(String email) {
		
		User user = userMapper.selectUserByEmail(email);
		
		if(user==null){
			return null;
		}
		
		return user;
	}

}
