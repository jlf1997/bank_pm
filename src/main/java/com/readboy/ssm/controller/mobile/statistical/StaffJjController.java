package com.readboy.ssm.controller.mobile.statistical;

import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.po.StaffJj;
import com.readboy.ssm.po.StaffJjCustom;
import com.readboy.ssm.service.StaffJjService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * 柜员交接
 * Created by Administrator on 2018/5/14.
 */
@Controller()
@RequestMapping("mobile/staffJj")
public class StaffJjController {

    @Autowired
    private StaffJjService staffJjService;

    @RequestMapping(value = "/insertStaffJj",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String insertStaffJj(StaffJj staffJj){
        Integer rs = 0;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        staffJj.setLrsj(sdf.format(date));
        try {
            rs = staffJjService.insertStaffJj(staffJj);
            rs = (rs == null) ? 0 : rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs>0){
            return "OK";
        }else {
            return "ERROR";
        }
    }
    
    @RequestMapping(value="/findStaffJjCustom",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<StaffJjCustom> findStaffJjCustomByCond(@RequestParam("yggh") String yggh,
    		@RequestParam(value="jjrq",required=false)String jjrq,@RequestParam(value="jjgw",required=false)String jjgw,
    		PageOption page) throws Exception{

        //初始化页面信息
        PageOption.initAppPage(page);
    	 List<StaffJj> staffJjList = staffJjService.findStaffJjbyCond(yggh, jjrq, jjgw,page);
    	 List<StaffJjCustom> list = new ArrayList<StaffJjCustom>();
    	 for(StaffJj sj : staffJjList){
    		 StaffJjCustom sjCustom = staffJjService.findStaffJjCustom(sj.getZzbz(), sj.getYggh());
    		 if(sjCustom != null){
    			 sjCustom.setStaffJj(sj);
        		 list.add(sjCustom);
    		 }
    	 }
    	 return list;
    }
}
