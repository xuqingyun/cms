/**
 * 
 */
package com.cnv.cms.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cnv.cms.model.Group;
import com.cnv.cms.model.Pager;
import com.cnv.cms.model.Role;
import com.cnv.cms.model.User;

/**
 * @author Administrator
 *
 */

public interface UserService extends BaseService<User>{
	/**
	 * 添加用户，需要判断用户名是否存在，如果存在抛出异常
	 * @param user 用户对象
	 * @param rids 用户的所有角色信息
	 * @param gids 用户的所有组信息
	 */
	@Transactional
	public void add(User user,List<Integer> rids, List<Integer> gids);
	//public boolean add(User user);
	/**
	 * 删除用户，注意需要把用户和角色和组的对应关系删除
	 * 如果用户存在相应的文章不能删除
	 * @param id
	 * @return 
	 */

	//public boolean delete(int id);
	/**
	 * 用户的更新，如果rids中的角色在用户中已经存在，就不做操作
	 * 如果rids中的角色在用户中不存在就要添加，如果用户中的角色不存在于rids中需要进行删除
	 * 对于group而已同样要做这个操作
	 * @param user
	 * @param rids
	 * @param gids
	 */
	@Transactional
	public void update(User user,List<Integer> listRids,List<Integer> listGids);
	@Transactional
	public void update(int id,List<Integer> rids,List<Integer> gids);
	
	//public boolean update(User user);
	/**
	 * 更新密码方法
	 * @param uid
	 * @param oldPwd
	 * @param newPwd
	 */
	public void updatePwd(int uid,String oldPwd,String newPwd);
	/**
	 * 更新用户的状态
	 * @param id
	 */
	public void updateStatus(int id);
	/**
	 * 列表用户
	 */
	public Pager<User> findUser();
	/*
	 * 用户列表
	 */
	public List<User> listUsers();
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	public User selectById(int id);
	public User load(String username);
	/**
	 * 获取用户的所有角色信息
	 * @param id
	 * @return
	 */
	public List<Role> listUserRoles(int id);
	/**
	 * 获取用户的所有组信息
	 * @param id
	 * @return
	 */
	public List<Group> listUserGroups(int id);
	
	public List<Integer> listUserRoleIds(int id);
	
	public List<Integer> listUserGroupIds(int id);
	
	public List<User> listGroupUsers(int gid);
	public List<User> listRoleUsers(int rid);
	
	/**
	 * 根据Group ID 获取用户信息
	 * @param id
	 */
	public List<User> listUsersByGroupID(int id);
	
	public User login(String username,String password);
	
	public void addLoginSession(String sessionid, int userid);
}