package com.readboy.ssm.controller.mobile.visitor;

import com.readboy.ssm.po.Res;
import com.readboy.ssm.po.VisitOtherInfo;
import com.readboy.ssm.service.ResService;
import com.readboy.ssm.service.VisitContactInfoService;
import com.readboy.ssm.service.VisitOtherInfoService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by Wyd on 2018/1/12.
 * 其他信息Controller
 */
@Controller
@RequestMapping("mobile/otherInfo")
public class OtherInfoController {

    @Autowired
    private VisitOtherInfoService visitOtherInfoService;

    @Autowired
    private ResService resService;

    @RequestMapping(value = "insertOtherInfo", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String insertOtherInfo(VisitOtherInfo visitOtherInfo){
        int result = visitOtherInfoService.Insert(visitOtherInfo);
        Integer id = visitOtherInfo.getId();
        System.out.println(id);
        if (result<=0){
            return "fail";
        }
        return String.valueOf(id);
    }

    @RequestMapping(value = "getListOtherInfo", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<VisitOtherInfo> getListOtherInfo(@RequestParam(value = "clientNum") String clientNum){
        List<VisitOtherInfo> listOtherInfo = visitOtherInfoService.findListOtherInfo(Integer.valueOf(clientNum));
        return listOtherInfo;
    }

    @RequestMapping(value = "deleteOtherInfoById",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String deleteOtherInfoByI(@RequestParam(value = "id") String id,
                                      @RequestParam(value = "fileName") String fileName,
                                      @RequestParam("khbh") String khbh,
                                      @RequestParam("ghrgh") String ghrgh) throws Exception {
        int result = visitOtherInfoService.deleteByPrimaryKey(Integer.valueOf(id));
        Res res = resService.findRes();
        String path = res.getPath()+"\\" + ghrgh + "\\" + khbh + "\\" + "image\\"+fileName;
        File file = new File(path);
        if (file.exists()){
            file.delete();
        }
        if (result<=0){
            return "fail";
        }
        return "success";
    }

    @RequestMapping(value = "uploadOtherInfoImageFile",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public void uploadOtherInfoImageFile(
            @RequestParam("khbh") String khbh,
            @RequestParam("ghrgh") String ghrgh,
            @RequestParam("type") String type,
            @RequestParam("fileName") String fileName,
            @RequestParam("fileupload") CommonsMultipartFile file) throws Exception {

        String path = null;
        if (!file.isEmpty()){
            Res res = resService.findRes();
            path = res.getPath() + "\\" + ghrgh + "\\" + khbh + "\\" + type + "\\" + fileName;
            File localFile = new File(path);
            if (!localFile.getParentFile().exists()) {
                localFile.getParentFile().mkdirs();
            }
            file.transferTo(localFile);
        }

    }
}
