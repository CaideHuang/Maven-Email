package com.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.pojo.User;
import com.web.service.WebService;

@Controller
public class WebController {

	private static final int SUCCESS_CODE = 1;
	private static final int ERROR_CODE = 0;

	@Autowired
	WebService webService;

	@PostMapping("/insertUser.do")
	@ResponseBody
	public Map<String, Object> insertUser(@RequestParam("email") String email,
			@RequestParam("password") String password) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		int code = webService.insertUser(email, password);

		if (code > 0) {
			map.put("code", SUCCESS_CODE);
			map.put("message", "添加成功");
			return map;
		} else {
			map.put("code", ERROR_CODE);
			map.put("message", "添加失败");
			return map;
		}

	}

	@GetMapping("/list.do")
	public String userList(Map<String, Object> map) {

		List<User> selectUserList = webService.selectUserList();

		map.put("users", selectUserList);

		return "list";
	}

	@GetMapping("/register.do")
	public String register(@RequestParam("code") String code, @RequestParam("email") String email) {

		User user = webService.selectUserByEmail(email);

		if (user!=null) {
			
			if((user.getCode()).equals(code) && user.getState()==0){
				int num = webService.updateUserState(email);
				return "success";
			}else{
				return "error";
			}

		} else {
			return "error";
		}

	}
	
	@PostMapping("/jsonSelectUser.do")
	@ResponseBody
	public Map<String,Integer> selectUserByEmail(@RequestParam("email") String email){
		User user = webService.selectUserByEmail(email);
		
		Map<String,Integer> map = new HashMap<>();
		
		if(user==null){
			map.put("state", 0);
		}else{
			map.put("state", 1);
		}
		
		return map;
	}

}
