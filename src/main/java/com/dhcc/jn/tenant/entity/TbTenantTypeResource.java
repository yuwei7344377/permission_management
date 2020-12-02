package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 租户类型功能清单实体类.
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
public class TbTenantTypeResource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**租户类型id*/
	private String zhTypeId;
	/**功能资源id*/
	private String resourceId;
	/**资源应用code*/
	private String appTypeCode;

	public String getAppTypeCode() {
		return appTypeCode;
	}

	public void setAppTypeCode(String appTypeCode) {
		this.appTypeCode = appTypeCode;
	}

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
	
	
}
