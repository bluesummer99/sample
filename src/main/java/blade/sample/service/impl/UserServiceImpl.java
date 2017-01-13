package blade.sample.service.impl;

import blade.sample.service.UserService;
import com.blade.ioc.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void sayHello() {
		System.out.println("userserviceimpl say hello");
	}

}
