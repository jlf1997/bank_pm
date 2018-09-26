package com.readboy.ssm.controller.mobile.statistical;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.po.PageOption;
import com.readboy.ssm.service.EmployeeStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * 员工统计分析
 * Created by Wyd on 2018/4/4.
 */
@Controller()
@RequestMapping("mobile/employeeStatistics")
public class EmployeeStatisticsController {

    @Autowired
    private EmployeeStatisticsService employeeStatisticsService;


    private List<EmployeeStatistics> statisticsList;


    /**
     * 查询员工工资信息
     * @param gzrq  日期
     * @param zzmc  部门
     * @param yggh  工号
     * @param ygxm  姓名
     * @param page  分页
     * @return      查询到的结果
     * @throws Exception    异常信息
     */
    @RequestMapping(value = "/findEmployeeWagesInfo.action", method={RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findEmployeeWagesInfo(
            @RequestParam(value = "gzrq",required = true) String gzrq,
            @RequestParam(value = "zzmc",required = true) String zzmc,
            @RequestParam(value = "yggh",required = false) String yggh,
            @RequestParam(value = "ygxm",required = false) String ygxm,
            PageOption page) throws Exception {
        JSONObject jsonObject = new JSONObject();
        //初始化页面信息
        PageOption.initAppPage(page);
        //判断员工编号和姓名是否是一个人
        if (yggh!=null&&!yggh.equals("")&&ygxm!=null&&!ygxm.equals("")){
            boolean b = employeeStatisticsService.judgeEmployee(yggh, ygxm);
            if (!b){
                jsonObject.put("result","error");
                return jsonObject.toJSONString();
            }
        }
        //判断员工工号不存在但是员工姓名存在
        if ((ygxm!=null&&!ygxm.equals(""))&&(yggh==null||yggh.equals(""))){
            //根据员工姓名查询员工工号
            List<String> ygghs = employeeStatisticsService.findTELLIDByName(ygxm);
            if (ygghs.size()>1){
                //一个名字对应多个编号 出现重名的情况
                statisticsList = employeeStatisticsService.findByTDNNS(gzrq,zzmc,ygghs,page);
            }else {
                //根据姓名查询只得到一个编号
                statisticsList = employeeStatisticsService.findByTDNN(gzrq,zzmc,ygghs.get(0),page);
            }
        } else {
            statisticsList = employeeStatisticsService.findByTDNN(gzrq,zzmc,yggh,page);
        }
        jsonObject.put("result",statisticsList);
        String s = jsonObject.toJSONString();
        System.out.println(s);
        return s;
    }

    /**
     * 查询所有部门信息
     * @return  部门列表
     * @throws Exception    异常信息
     */
    @RequestMapping(value = "/findOrganization.action", method={RequestMethod.POST,RequestMethod.GET},produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String findOrganization() throws Exception {
        List<String> organization = employeeStatisticsService.findOrganization();
        System.out.println(JSONArray.toJSONString(organization));
        return JSONArray.toJSONString(organization);
    }
}
