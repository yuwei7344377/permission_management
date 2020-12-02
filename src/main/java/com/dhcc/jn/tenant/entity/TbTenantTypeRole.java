package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 租户类型默认角色实体类.
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
public class TbTenantTypeRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**租户类型id*/
	private String zhTypeId;
	/**角色编码*/
	private String roleCode;
	/**角色名称*/
	private String roleName;
	
	
	/**
	 *方法: 取得String
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  租户类型id
	 */
	public String getZhTypeId(){
		return this.zhTypeId;
	}

	/**
	 *方法: 设置String
	 *@param: String  租户类型id
	 */
	public void setZhTypeId(String zhTypeId){
		this.zhTypeId = zhTypeId;
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
