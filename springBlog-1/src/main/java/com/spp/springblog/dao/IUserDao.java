package com.spp.springblog.dao;

import com.spp.springblog.vo.UserVO;

public interface IUserDao {
	public void saveUser(UserVO userVo, String role);

	public UserVO findByUsername(String vusername);

	public String findRoleByUsername(String vusername);

	public void userDelete(UserVO userVo);

	public void userUpdate(UserVO userVo);
	
	public int idchk(UserVO userVo);
}
