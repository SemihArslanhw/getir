package com.getir.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import com.getir.business.abstracts.UserService;
import com.getir.core.dataAccess.UserDao;
import com.getir.core.entities.User;
import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;
import com.getir.core.utilities.results.SuccesDataResult;
import com.getir.core.utilities.results.SuccessResult;

public class UserManager implements UserService{

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccesDataResult<User>(this.userDao.findByEmail(email)
				,"Kullanıcı bulundu");
	}
	
}
