package cn.hassan.site.bo.impl;

import cn.hassan.site.bo.ItemService;
import cn.hassan.site.bo.UserService;
import cn.hassan.site.mapper.UserMapper;
import cn.hassan.site.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created with idea
 * Author: hss
 * Date: 2020/8/21 10:18
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ItemService itemService;

	@Transactional
	public void A() {
		User user = new User();
		user.setUsername("sherry");
		user.setBirthday(new Date());
		user.setSex(String.valueOf(1));
		user.setAddress("HangZhou");
		userMapper.insert(user);

		itemService.B();
	}
}
