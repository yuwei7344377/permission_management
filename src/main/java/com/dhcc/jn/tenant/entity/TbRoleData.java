package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 角色数据资源清单表实体类.
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
public class TbRoleData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**清单id*/
	private String id;
	/**租户id*/
	private String zhId;
	/**角色id*/
	private String roleId;
	/**数据类型id*/
	private String dataId;
	/**状态：1审批通过 2审批中*/
	private String state;
	/**目录数据资源ID上级或者产品数据资源ID上级*/
	private String parentId;
	/**数据来源 0 目录资源表，1 产品资源表**/
	private String dataFrom;
	
	
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
	 *@return: String  数据类型id
	 */
	public String getDataId(){
		return this.dataId;
	}

	/**
	 *方法: 设置String
	 *@param: String  数据类型id
	 */
	public void setDataId(String dataId){
		this.dataId = dataId;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}
	
	
}
