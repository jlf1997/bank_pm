package com.readboy.ssm.controller.mobile.statistical;

import com.alibaba.fastjson.JSONObject;
import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.BranchStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.JsonObject;
import java.util.List;

/**
 * 支行统计分析
 * Created by Wyd on 2018/4/4.
 */
@Controller()
@RequestMapping("mobile/branchStatistics")
public class BranchStatisticsController {

    @Autowired
    private BranchStatisticsService branchStatisticsService;


    /**
     * 支行前十名
     * @param gzrq      日期
     * @param zzmc      支行
     * @return          支行前十名员工
     * @throws Exception    异常信息
     */
    @RequestMapping(value = "/findEmployeesByOraganization.action",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findEmployeesByOraganization(
            @RequestParam(value = "gzrq",required = true) String gzrq,
            @RequestParam(value = "zzmc",required = true) String zzmc
            ) throws Exception {
        JSONObject jsonObject = new JSONObject();
        List<EmployeeStatistics> statisticsList = branchStatisticsService.findEmployeesByOraganization(gzrq, zzmc);
        jsonObject.put("result",statisticsList);
        System.out.println("支行排名测试");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/findLastTenEmployees.action",method = {RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findLastTenEmployees(
            @RequestParam(value = "gzrq",required = true) String gzrq,
            @RequestParam(value = "zzmc",required = true) String zzmc) throws Exception{
        List<EmployeeStatistics> lastTen = null;
        JSONObject jsonObject = new JSONObject();
        int maxNum = branchStatisticsService.findBranchMaxNum(gzrq, zzmc);
        if (maxNum==0){
            jsonObject.put("result","[]");
        }else {
            lastTen = branchStatisticsService.findLastTen(gzrq, zzmc, maxNum);
            jsonObject.put("result",lastTen);
        }
        String s = jsonObject.toJSONString();
        System.out.println(s);
        return s;
    }
}
