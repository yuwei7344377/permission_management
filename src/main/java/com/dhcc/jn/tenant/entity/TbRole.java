package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 角色表实体类.
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
public class TbRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**角色id*/
	private String roleId;
	/**租户id*/
	private String zhId;
	/**角色编码*/
	private String roleCode;
	/**角色名称*/
	private String roleName;
	/**租户类型ID*/
	private String zhTypeId;
	
	public String getZhTypeId() {
		return zhTypeId;
	}

	public void setZhTypeId(String zhTypeId) {
		this.zhTypeId = zhTypeId;
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
	 *@return: String  角色编码
	 */
	public String getRoleCode(){
		return this.roleCode;
	}

	/**
	 *方法: 设置String
	 *@param: String  角色编码
	 */
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  角色名称
	 */
	public String getRoleName(){
		return this.roleName;
	}

	/**
	 *方法: 设置String
	 *@param: String  角色名称
	 */
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}

}
