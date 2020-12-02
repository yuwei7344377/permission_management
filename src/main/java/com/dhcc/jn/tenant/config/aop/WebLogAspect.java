package com.dhcc.jn.tenant.config.aop;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.jn.tenant.common.Constants;
import com.dhcc.jn.tenant.entity.TbUser;
import com.dhcc.jn.tenant.utils.HttpDeal;

@Aspect
@Component
public class WebLogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    @Value("${authServiceUrl}")
    private String authServiceUrl;

    
    /**
     * 定义切入点，以controller下所有包的请求为切入点
     */
    @Pointcut("execution(public * com.dhcc.jn.tenant.controller..*.*(..))*")
    public void webLog() {

    }

    /**
     * 前置通知：在切入点之前执行的通知
     * 
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

//        startTime.set(System.currentTimeMillis());
//
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//
//        // 打印请求相关参数
//        logger.info("==== Start ====");
//
//        logger.info("URL：" + request.getRequestURL().toString());
//
//        logger.info("HTTP_METHOD：" + request.getMethod());
//
//        // header第一种格式展示
//        Enumeration<String> enumeration = request.getHeaderNames();
//        Map<String, String> headerMap = new HashMap<>();
//        while (enumeration.hasMoreElements()) {
//            String headerName = enumeration.nextElement();
//            headerMap.put(headerName, request.getHeader(headerName));
//        }
//        String headerJsonStr = JSON.toJSONString(headerMap);
//        if (headerJsonStr.length() > 0) {
//            logger.info("HTTP_HEADERS INFO IS: {}", headerJsonStr);
//        }
//
//        // header第二种格式展示
//        logger.info("HTTP_HEADERS: ");
//        Enumeration<?> enumeration1 = request.getHeaderNames();
//        while (enumeration1.hasMoreElements()) {
//            String key = (String) enumeration1.nextElement();
//            String value = request.getHeader(key);
//            logger.info("     {}: {}", key, value);
//        }
//
//        logger.info("IP：" + this.getIP(request));
//
//        logger.info("CLASS_METHOD："
//                + joinPoint.getSignature().getDeclaringTypeName() + "."
//                + joinPoint.getSignature().getName());
//        try {
//            logger.info("REQUEST BODY : [{}]",
//                    JSON.toJSONString(joinPoint.getArgs()[0]));
////            LOG.info("ARGS：{}", Arrays.toString(joinPoint.getArgs()));
//        }
//        catch (Exception e) {
//            logger.error("REQUEST BODY PARSE ERROR!");
//        }
//
//        HttpSession session = (HttpSession) servletRequestAttributes
//                .resolveReference(RequestAttributes.REFERENCE_SESSION);
//        logger.info("SESSION ID：" + session.getId());

    }

    /**
     * 
     * @Title: getIP @Description: 获取IP地址信息 @param request @return
     *         String @throws
     */
//    public String getIP(HttpServletRequest request) {
//        String ipAddress = null;
//        ipAddress = request.getHeader("x-forwarded-for");
//        if (ipAddress == null || ipAddress.length() == 0
//                || "unknown".equalsIgnoreCase(ipAddress)) {
//            ipAddress = request.getHeader("Proxy-Client-IP");
//        }
//        if (ipAddress == null || ipAddress.length() == 0
//                || "unknown".equalsIgnoreCase(ipAddress)) {
//            ipAddress = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ipAddress == null || ipAddress.length() == 0
//                || "unknown".equalsIgnoreCase(ipAddress)) {
//            ipAddress = request.getRemoteAddr();
//            if ("127.0.0.1".equals(ipAddress)) {
//                // 根据网卡取本机配置的IP
//                InetAddress inet = null;
//                try {
//                    inet = InetAddress.getLocalHost();
//                }
//                catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//                ipAddress = inet.getHostAddress();
//            }
//        }
//
//        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
//        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
//            if (ipAddress.indexOf(",") > 0) {
//                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
//            }
//        }
//        return ipAddress;
//    }

//    /**
//     * 后置通知
//     * @param ret
//     * @throws Throwable
//     */
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        LOG.info("RESPONSE : " + ret);
//        LOG.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//
//    }

    /**
     * 后置最终通知
     * 
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
//        logger.info("======== End =======");
//        // 每个请求之间空一行
//        logger.info("");
    }

    /**
     * 环绕通知 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     * 
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        JSONObject json = new JSONObject();
        json.put("success", false);
        json.put("data", "");
        json.put("msg", "没有权限！");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        try {
            //登录获取的key
            String key = "";    
            //设置活跃时间 tenant
            String appFlag = "tenantCenter";//new String(request.getParameter("appFlag"));   
            String resourceId = "";  
            String flag = "";//"function";
            if(StringUtils.isEmpty(request.getParameter("key"))
                    ||StringUtils.isEmpty(request.getParameter("resourceId"))
                    ||StringUtils.isEmpty(request.getParameter("flag"))) {
                json.put("success", false);
                json.put("msg", "参数不正确！");
                //暂时不进行拦截
                //进行拦截时要处理BaseController中getCurrentUser方法
                return proceedingJoinPoint.proceed();
                //return json;
            }
            key = new String(request.getParameter("key"));    
            resourceId = new String(request.getParameter("resourceId"));  
            flag = new String(request.getParameter("flag"));//"function";
            
            HttpDeal hd = new HttpDeal();
            String urlAfter = "/getUserByUsername?key="+key+"&appFlag="+appFlag +"&resourceId="+resourceId+"&flag="+flag;//resourceFlag
            String url = authServiceUrl + urlAfter;
            JSONObject resultUserInfo = JSONObject
                    .parseObject(hd.get(url));
            if ((boolean) resultUserInfo.get("success") && resultUserInfo.get("data")!= null &&  resultUserInfo.get("data")!= "") {
                Map<String, Object> userInfo = (Map<String, Object>) resultUserInfo.get("data");
               TbUser tbUser = new TbUser();
                
               tbUser.setUserId(userInfo.get("userId").toString());
               tbUser.setUsername(userInfo.get("username").toString());
               tbUser.setRealname(userInfo.get("realname").toString());
               Constants.tbUser =tbUser;
                
                return proceedingJoinPoint.proceed();
            }else {
                json.put("success", false);
                json.put("msg", "未登录！");
                return json;
            }
            
        }catch(Exception e) {
            e.printStackTrace();
            logger.info("aop拦截="+e.getMessage());
            json.put("success", false);
            json.put("msg", "系统异常，请联系管理员！");
            return json;
        }
       

//         Object result = proceedingJoinPoint.proceed();
//         return result;
        // String resultStr = JSON.toJSONString(result);
        // 打印出参
        // logger.info("RESPONSE ARGS : {}", resultStr);

        // 执行耗时
//        logger.info("TIME-CONSUMING : {} ms",
//                System.currentTimeMillis() - startTime);
//        return json;
    }
}
