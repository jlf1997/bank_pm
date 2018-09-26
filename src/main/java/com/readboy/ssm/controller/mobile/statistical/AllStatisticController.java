package com.readboy.ssm.controller.mobile.statistical;

import com.alibaba.fastjson.JSONObject;
import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.service.AllStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 全行统计分析
 * Created by Wyd on 2018/4/4.
 */
@Controller()
@RequestMapping("mobile/allStatistic")
public class AllStatisticController {

    @Autowired
    private AllStatisticService allStatisticService;
    
    /**
     * 全行前十名
     * @param gzrq      日期
     * @return          前十名信息
     * @throws Exception    异常信息
     */
    @RequestMapping(value = "/findEmployeesByTime.action",method = {RequestMethod.GET,RequestMethod.POST},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findEmployeesByTime(
            @RequestParam(value = "gzrq",required = true) String gzrq
    )throws Exception{
        JSONObject jsonObject = new JSONObject();
        List<EmployeeStatistics> statisticsList = allStatisticService.findEmployeesByTime(gzrq);
        jsonObject.put("result",statisticsList);
        System.out.println("全行排名");
        return jsonObject.toJSONString();
    }


    /**
     * 查询全行后十名
     * @param gzrq      日期
     * @return          后十名信息
     * @throws Exception    异常信息
     */
    @RequestMapping(value = "/findLastTenByTime.action",produces = "text/html;charset=UTF-8",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String findLastTenByTime(
            @RequestParam(value = "gzrq",required = true) String gzrq
    )throws Exception{
    	List<EmployeeStatistics> allLastTen = null;
        JSONObject jsonObject = new JSONObject();
        int maxNum = allStatisticService.findAllMaxNum(gzrq);
        if(maxNum==0){
        	jsonObject.put("result","[]");
        }else{
        	allLastTen = allStatisticService.findAllLastTen(gzrq, maxNum);
            jsonObject.put("result",allLastTen);
        }
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/test.action",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object test(){
        System.out.println("你是傻逼哟！");
        return "你是傻逼哦！";
    }

}
