package com.dhcc.jn.tenant.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 组织表实体类.
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
public class TbOrg implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**组织Id*/
	private String orgId;
	/**租户id*/
	private String zhId;
	/**组织编码*/
	private String orgCode;
	/**组织名称*/
	private String orgName;
	/**上级组织id*/
	private String parentOrgId;
	private String parentOrgName;
	/**组织级别*/
	private String orgType;
	/**组织排序*/
	private String orgOrder;
	/**创建人ID*/
	private String createId;
	/**创建人*/
	private String createName;
	/**创建时间*/
	private Date createDate;
	/**更新人ID*/
	private String updateId;
	/**更新人*/
	private String updateName;
	/**更新时间*/
	private Date updateDate;

	private List<TbOrg> children = new ArrayList<TbOrg>();
	
	public List<TbOrg> getChildren() {
		return children;
	}

	public void setChildren(List<TbOrg> children) {
		this.children = children;
	}

	/**
	 *方法: 取得String
	 *@return: String  组织Id
	 */
	public String getOrgId(){
		return this.orgId;
	}

	/**
	 *方法: 设置String
	 *@param: String  组织Id
	 */
	public void setOrgId(String orgId){
		this.orgId = orgId;
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
	 *@return: String  组织编码
	 */
	public String getOrgCode(){
		return this.orgCode;
	}

	/**
	 *方法: 设置String
	 *@param: String  组织编码
	 */
	public void setOrgCode(String orgCode){
		this.orgCode = orgCode;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  组织名称
	 */
	public String getOrgName(){
		return this.orgName;
	}

	/**
	 *方法: 设置String
	 *@param: String  组织名称
	 */
	public void setOrgName(String orgName){
		this.orgName = orgName;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  上级组织id
	 */
	public String getParentOrgId(){
		return this.parentOrgId;
	}

	/**
	 *方法: 设置String
	 *@param: String  上级组织id
	 */
	public void setParentOrgId(String parentOrgId){
		this.parentOrgId = parentOrgId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  组织级别
	 */
	public String getOrgType(){
		return this.orgType;
	}

	/**
	 *方法: 设置String
	 *@param: String  组织级别
	 */
	public void setOrgType(String orgType){
		this.orgType = orgType;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  组织排序
	 */
	public String getOrgOrder(){
		return this.orgOrder;
	}

	/**
	 *方法: 设置String
	 *@param: String  组织排序
	 */
	public void setOrgOrder(String orgOrder){
		this.orgOrder = orgOrder;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  创建人ID
	 */
	public String getCreateId(){
		return this.createId;
	}

	/**
	 *方法: 设置String
	 *@param: String  创建人ID
	 */
	public void setCreateId(String createId){
		this.createId = createId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  创建人
	 */
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置String
	 *@param: String  创建人
	 */
	public void setCreateName(String createName){
		this.createName = createName;
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
	 *@return: String  更新人ID
	 */
	public String getUpdateId(){
		return this.updateId;
	}

	/**
	 *方法: 设置String
	 *@param: String  更新人ID
	 */
	public void setUpdateId(String updateId){
		this.updateId = updateId;
	}
	
	/**
	 *方法: 取得String
	 *@return: String  更新人
	 */
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置String
	 *@param: String  更新人
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	
	/**
	 *方法: 取得Date
	 *@return: Date  更新时间
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置Date
	 *@param: Date  更新时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	public String getParentOrgName() {
		return parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}
	
}
