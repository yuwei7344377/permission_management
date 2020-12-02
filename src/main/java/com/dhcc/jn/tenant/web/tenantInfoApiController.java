package com.dhcc.jn.tenant.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * Controller
 * 
 * @author
 *
 */
@RequestMapping("/tenantInfoApi")
@Controller
public class tenantInfoApiController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private InfoService infoService;

    @RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getByUsername(String userName) {
        JSONObject json = new JSONObject();
        boolean success = true;
        String message = "";
        Map<String, String> result = null;
        try {
            result = new HashMap<>();//infoService.getUserInfoByUsername(userName);
            result.put("username",userName);

        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.getStackTrace();
            success = false;
            message = e.getMessage();
        }
        json.put("success", success);
        json.put("data", result);
        json.put("msg", message);

        return json;
    }
}
