package com.dhcc.jn.tenant.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 企业类型实体类.
 * 
 * <pre>
 * 	历史记录：
 * 	2020-07-23 jlf
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
public class VCompantype implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**id*/
	private String id;
	/**字典编码*/
	private String typecode;
	/**字典名称*/
	private String typename;
	/**无用字段*/
	private String typepid;
	/**字典组ID*/
	private String typegroupid;
	/**创建时间*/
	private Date createDate;
	/**创建用户*/
	private String createName;
	/**序号*/
	private Integer orderNum;
	
	
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
	 *@return: String  字典编码
	 */
	public String getTypecode(){
		return this.typecode;
	}

	/**
	 *方法: 设置String
	 *@param: String  字典编码
	 */
	public void setTypecode(String typecode){
		this.typecode = typecode;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  字典名称
	 */
	public String getTypename(){
		return this.typename;
	}

	/**
	 *方法: 设置String
	 *@param: String  字典名称
	 */
	public void setTypename(String typename){
		this.typename = typename;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  无用字段
	 */
	public String getTypepid(){
		return this.typepid;
	}

	/**
	 *方法: 设置String
	 *@param: String  无用字段
	 */
	public void setTypepid(String typepid){
		this.typepid = typepid;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  字典组ID
	 */
	public String getTypegroupid(){
		return this.typegroupid;
	}

	/**
	 *方法: 设置String
	 *@param: String  字典组ID
	 */
	public void setTypegroupid(String typegroupid){
		this.typegroupid = typegroupid;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  创建时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  创建用户
	 */
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置String
	 *@param: String  创建用户
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	
	/**
	 *方法: 取得Integer
	 *@return: Integer  序号
	 */
	public Integer getOrderNum(){
		return this.orderNum;
	}

	/**
	 *方法: 设置Integer
	 *@param: Integer  序号
	 */
	public void setOrderNum(Integer orderNum){
		this.orderNum = orderNum;
	}
	
	
}
