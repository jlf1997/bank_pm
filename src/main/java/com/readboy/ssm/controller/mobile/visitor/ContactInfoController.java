package com.readboy.ssm.controller.mobile.visitor;

import com.readboy.ssm.po.Res;
import com.readboy.ssm.po.VisitContactLog;
import com.readboy.ssm.service.ResService;
import com.readboy.ssm.service.VisitContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.lang.annotation.ElementType;
import java.util.List;


/**
 * Created by Wyd on 2018/1/12.
 * 联系人通话信息Controller
 */
@Controller
@RequestMapping("mobile/contactinfo")
public class ContactInfoController {

    private List<VisitContactLog> listContactLog;

    @Autowired
    private VisitContactInfoService visitContactInfoService;

    @Autowired
    private ResService resService;



    @RequestMapping(value = "/saveContactLog.action", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public int saveContactLog(VisitContactLog visitContactLog) {
        try {
            /*插入一条新数据*/
            visitContactInfoService.insertContactInfo(visitContactLog);
        } catch (Exception e) {
            System.out.println("插入数据失败！");
            return 0;
        }
        return 1;
    }

    @RequestMapping(value = "/findListContactLog.action",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<VisitContactLog> findListContactLog(@RequestParam(value = "clientNum",required = false)String clientNum) throws Exception {
        List<VisitContactLog> listContactLogByClientNum = visitContactInfoService.findListContactLogByClientNum(Integer.valueOf(clientNum));
        return listContactLogByClientNum;
    }


    @RequestMapping(value = "uploadPhoneRecordFile.action",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public void uploadPhoneRecordFile(
            @RequestParam("khbh") String khbh,
            @RequestParam("ghrgh") String ghrgh,
            @RequestParam("type") String type,
            @RequestParam("fileupload") CommonsMultipartFile file) throws Exception {

        String path = null;
        System.out.println(khbh + "/" + ghrgh + "/" + type + "/" + file.toString());
        if (!file.isEmpty()) {
            Res res = resService.findRes();
            if (res != null) {
                path = res.getPath();
            }
            path = path + "\\" + ghrgh + "\\" + khbh + "\\" + type;
            String file_name = file.getOriginalFilename();
            String fileName = path + "\\" + file_name;
            File localFile = new File(fileName);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
            }
            file.transferTo(localFile);
        }
    }

}