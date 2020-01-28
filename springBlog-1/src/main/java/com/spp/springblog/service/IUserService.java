package com.spp.springblog.service;

import com.spp.springblog.vo.UserVO;

public interface IUserService {

	int idchk(UserVO userVo);

	boolean userUpdate(UserVO userVo, String oldVpassword);

	boolean userDelete(UserVO userVo);

	void saveUser(UserVO userVo, String role);

}
