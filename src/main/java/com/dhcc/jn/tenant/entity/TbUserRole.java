package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 账户角色关系实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2020-07-22 jlf
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	jlf
 * PG
 *	jlf
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public class TbUserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**授权id*/
	private String id;
	/**租户id*/
	private String zhId;
	/**账户id*/
	private String userId;
	/**角色id*/
	private String roleId;
	/**来源:1用户类型角色表 2角色表*/
	private String roleSource;
	
	
	/**
	 *方法: 取得String
	 *@return: String  授权id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  授权id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  租户id
	 */
	public String getZhId(){
		return this.zhId;
	}

	/**
	 *方法: 设置String
	 *@param: String  租户id
	 */
	public void setZhId(String zhId){
		this.zhId = zhId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  账户id
	 */
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置String
	 *@param: String  账户id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  角色id
	 */
	public String getRoleId(){
		return this.roleId;
	}

	/**
	 *方法: 设置String
	 *@param: String  角色id
	 */
	public void setRoleId(String roleId){
		this.roleId = roleId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  来源:1用户类型角色表 2角色表
	 */
	public String getRoleSource(){
		return this.roleSource;
	}

	/**
	 *方法: 设置String
	 *@param: String  来源:1用户类型角色表 2角色表
	 */
	public void setRoleSource(String roleSource){
		this.roleSource = roleSource;
	}
	
	
}
