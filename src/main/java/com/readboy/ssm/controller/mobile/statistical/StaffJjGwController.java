package com.readboy.ssm.controller.mobile.statistical;
import com.alibaba.fastjson.JSONObject;
import com.readboy.ssm.po.Organization;
import com.readboy.ssm.po.StaffJjGw;
import com.readboy.ssm.service.StaffJjGwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
/**
 * 柜员交接岗位
 */
@Controller()
@RequestMapping("mobile/staffJj")
public class StaffJjGwController {

    @Autowired
    private StaffJjGwService staffJjGwService;

    @RequestMapping(value="/findStaffJjGw",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<StaffJjGw> findStaffJjGw() throws Exception{
    	 List<StaffJjGw> list = staffJjGwService.findStaffJjGw();
    	 return list;
    }

    @RequestMapping(value = "/findOrganization",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findOrganization(@RequestParam("tellId") String tellId){
        Organization oz = null;
        try {
            oz = staffJjGwService.findOrganization(tellId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (oz!=null){
            return JSONObject.toJSONString(oz);
        }
        System.out.println(JSONObject.toJSONString(oz));
        return null;
    }

}
