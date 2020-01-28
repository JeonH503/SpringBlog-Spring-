package com.spp.springblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spp.springblog.vo.UserVO;

@Repository
public class UserDao implements IUserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void saveUser(UserVO userVo, String role) {
		sqlSession.insert("userMapper.insertUser",userVo);
	}
	
	@Override
	public UserVO findByUsername(String vusername) {
		return sqlSession.selectOne("userMapper.selectOneUser",vusername);
		
	}

	@Override
	public String findRoleByUsername(String vusername) {
		return sqlSession.selectOne("userMapper.selectOneForRoleUser",vusername);
	}

	@Override
	public void userDelete(UserVO userVo) {
		sqlSession.delete("userMapper.deleteUser",userVo);
	}

	@Override
	public void userUpdate(UserVO userVo) {
		sqlSession.update("userMapper.updateUser",userVo);
	}
	
	@Override
	public int idchk(UserVO userVo) {
		return sqlSession.selectOne("userMapper.idchk",userVo);
	}
	
}
