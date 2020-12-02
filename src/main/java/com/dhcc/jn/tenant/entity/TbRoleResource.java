package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 角色资源清单实体类.
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
public class TbRoleResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**清单id*/
	private String id;
	/**租户id*/
	private String zhId;
	/**角色id*/
	private String roleId;
	/**功能资源id*/
	private String resourceId;
	/**状态：1审批通过 2审批中*/
	private String state;
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
	 *@return: String  功能资源id
	 */
	public String getResourceId(){
		return this.resourceId;
	}

	/**
	 *方法: 设置String
	 *@param: String  功能资源id
	 */
	public void setResourceId(String resourceId){
		this.resourceId = resourceId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  状态：1审批通过 2审批中
	 */
	public String getState(){
		return this.state;
	}

	/**
	 *方法: 设置String
	 *@param: String  状态：1审批通过 2审批中
	 */
	public void setState(String state){
		this.state = state;
	}

	public String getAppTypeCode() {
		return appTypeCode;
	}

	public void setAppTypeCode(String appTypeCode) {
		this.appTypeCode = appTypeCode;
	}
	
}
