package org.zahid.apps.web.pos.service;

import org.zahid.apps.web.pos.entity.User;

import java.util.List;

public interface UserService {
	List<User> getUsers();

	void save(User user);

}
