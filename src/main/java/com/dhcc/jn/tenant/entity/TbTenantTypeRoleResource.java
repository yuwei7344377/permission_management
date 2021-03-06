package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 用户类型角色资源清单表实体类.
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
public class TbTenantTypeRoleResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**清单id*/
	private String id;
	/**角色id*/
	private String roleId;
	/**资源id*/
	private String resourceId;
	
	private String appTypeCode;
	
	
	/**
	 *方法: 取得String
	 *@return: String  清单id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置String
	 *@param: String  清单id
	 */
	public void setId(String id){
		this.id = id;
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
	 *@return: String  资源id
	 */
	public String getResourceId(){
		return this.resourceId;
	}

	/**
	 *方法: 设置String
	 *@param: String  资源id
	 */
	public void setResourceId(String resourceId){
		this.resourceId = resourceId;
	}

	public String getAppTypeCode() {
		return appTypeCode;
	}

	public void setAppTypeCode(String appTypeCode) {
		this.appTypeCode = appTypeCode;
	}
	
}
