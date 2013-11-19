package com.shishuo.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.shishuo.cms.entity.Admin;

@Repository
public interface AdminDao {

	public int addAdmin(Admin admin);
	
	public List<Admin> getAllList(@Param("offset") long offset,@Param("rows") long rows);
	
	public long getAllListCount();
	
	public int updateAdmin(Admin admin);
	
	public int deleteAdmin(@Param("adminId") long adminId);
	
	public Admin getAdminById(@Param("adminId") long adminId);
}
