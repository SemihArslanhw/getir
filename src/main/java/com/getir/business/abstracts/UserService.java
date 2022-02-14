package com.getir.business.abstracts;

import com.getir.core.entities.User;
import com.getir.core.utilities.results.DataResult;
import com.getir.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
	
}
