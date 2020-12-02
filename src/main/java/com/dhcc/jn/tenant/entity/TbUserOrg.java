package com.dhcc.jn.tenant.entity;
import java.io.Serializable;

/**
 * 
 * 账户组织关系实体类.
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
public class TbUserOrg implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**授权id*/
	private String id;
	/**租户id*/
	private String zhId;
	/**账户id*/
	private String userId;
	/**组织id*/
	private String orgId;
	
	
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
	 *@return: String  组织id
	 */
	public String getOrgId(){
		return this.orgId;
	}

	/**
	 *方法: 设置String
	 *@param: String  组织id
	 */
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	
	
}
