package com.dhcc.jn.tenant.common;

import java.util.ResourceBundle;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回值实体Bean
 * @author jlf
 */
public class ResponseMessage {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("messages_zh_CN");
	
    private Boolean success;  // 状态：true成功；false失败
    private Object result;    // 返回值
    private String errMsg;  // 系统异常信息，给开发人员使用
    private String tipMsg;  //提示信息

    /**
	 * 获取配置文件参数
	 * @param name
	 * @return
     * @throws Exception 
	 */
	public static final String getConfigByName(String name){
		
		try {
			String tip =  bundle.getString(name);
			String tipZh = new String(tip.getBytes("ISO-8859-1"),"Utf-8");
			return tipZh;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
	
	public ResponseMessage(Boolean success,Object result,String errMsg,String tipMsg) {
        super();
        this.success = success;
        this.result = result;
        this.errMsg = errMsg;
        this.tipMsg = tipMsg;
    }
	
	/**
	 * 统一返回信息，返回提示语要对应到配置文件中查找
	 * @param success
	 * @param result
	 * @param errMsg
	 * @param tipMsg
	 * @return
	 */
	public static JSONObject returnInfo(Boolean success,Object result,String errMsg,String tipMsg){
		
		JSONObject json = new JSONObject();
		
		//如果tipMsg值不为空，并且包含already_exists
		if(null != tipMsg && !tipMsg.equals("") && tipMsg.endsWith("already_exists")){
			
			int a = tipMsg.indexOf("already_exists");
			String beforeInfo = tipMsg.substring(0,a);
			String afterInfo = tipMsg.substring(a);
			
			String tipMsgZh = getConfigByName(""+afterInfo);
			json.put("tipMsg", beforeInfo+tipMsgZh);
		}
		//如果tipMsg值不为空，并且不包含already_exists
		else if(null != tipMsg && !tipMsg.equals("") && !tipMsg.endsWith("already_exists")){
			
			String tipMsgZh = getConfigByName(tipMsg);
			json.put("tipMsg", tipMsgZh);
		}
		//如果tipMsg值为空
		else {
			
			json.put("tipMsg", tipMsg);
		}
		
		json.put("success", success);
		json.put("result",result);
		json.put("errMsg", errMsg);
		
		return json;
	}
	
	/**
	 * 统一返回信息，提示语直接返回，特殊情况走该方法
	 * @param success
	 * @param result
	 * @param errMsg
	 * @param tipMsg
	 * @return
	 */
	public static JSONObject returnInfoSpecial(Boolean success,Object result,String errMsg,String tipMsg){
		
		JSONObject json = new JSONObject();
		json.put("success", success);
		json.put("result",result);
		json.put("errMsg", errMsg);
		json.put("tipMsg", tipMsg);
		return json;
	}
}
