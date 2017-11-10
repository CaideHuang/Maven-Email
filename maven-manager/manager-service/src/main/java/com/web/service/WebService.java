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
	 * ����û���Ϣ
	 */
	@Transactional
	public int insertUser(String email, String password) throws Exception {
		int num = userMapper.insertUser(email,doPassword(password),doCode(email, password));
		
		String context="<p>�𾴵�"+email+"�û���</p><p style=text-indent:2em>��л��ע�����ǵ���վ������ע��֮����Ҫ���������û�����:<a href="+URL+"register.do?code="+doCode(email, password)+"&email="+email+">"+URL+"register.do?code="+doCode(email, password)+"&email="+email+"</a></p>";
		
		//�����ʼ�����
		sendMail(email, "�û�������֤",context);
		
		return num;
	}

	/*
	 * �������
	 */
	public static String doPassword(String password) {
		String password_md5 = DigestUtils.md5Hex(password);
		return password_md5;
	}

	/*
	 * ����code
	 */
	public static String doCode(String email, String password) {
		String code = DigestUtils.md5Hex(email + password);
		return code;
	}

	/*
	 * �����ʼ�
	 */
	public void sendMail(String to, String title, String context) throws Exception {
		SendEmail.sendMail(to, title, context);
	}

	/*
	 * ��ѯ�û��б�
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
