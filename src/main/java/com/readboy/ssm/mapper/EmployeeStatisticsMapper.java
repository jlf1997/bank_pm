package com.readboy.ssm.mapper;

import com.readboy.ssm.po.EmployeeStatistics;
import com.readboy.ssm.po.PageOption;
import org.apache.ibatis.annotations.Param;

import java.rmi.server.ExportException;
import java.util.List;

/**
 * 用工工资查询统计分析Mapper
 * Created by Wyd on 2018/4/4.
 */
public interface EmployeeStatisticsMapper {


    /**
     * 根据员工工号查询员工工资详情
     * @param gzrq  时间日期
     * @param zzmc  组织编号
     * @param ygghs 员工工号
     * @param page  分页信息
     * @return      工资信息列表
     * @throws Exception    异常信息
     */
    public List<EmployeeStatistics> findByTDNN(@Param("GZRQ")String gzrq,@Param("ZZMC")String zzmc,@Param("YGGH")String ygghs,@Param("page")
            PageOption page) throws Exception;



    /**
     * 根据多个员工工号查询员工工资详情
     * @param gzrq  时间日期
     * @param zzmc  组织编号
     * @param ygghs 员工工号集合
     * @param page  分页信息
     * @return      工资信息列表
     * @throws Exception    异常信息
     */
    public List<EmployeeStatistics> findByTDNNS(@Param("GZRQ")String gzrq,@Param("ZZMC")String zzmc,@Param("YGGHS")List<String> ygghs,@Param("page")
            PageOption page) throws Exception;

    /**
     * 根据员工姓名查询员工编号
     * @param name  员工姓名
     * @return      员工编号
     * @throws Exception    异常信息
     */
    public List<String> findTELLIDByName(@Param("name") String name) throws Exception;


    /**
     * 判断员工编号的姓名对应的是否是一个人
     * @param yggh  员工编号
     * @param ygxm  员工姓名
     * @throws Exception    异常信息
     */
    public int judgeEmployee(@Param("yggh") String yggh, @Param("ygxm") String ygxm) throws Exception;

    /**
     * 查询所有部门
     * @return  部门列表
     * @throws Exception 异常信息
     */
    public List<String> findOrganization() throws Exception;
}
