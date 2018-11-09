package com.readboy.ssm.appjx.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.readboy.ssm.appjx.model.pk.ErpBasZbkPk;


@Table
@Entity(name="erp_bas_zbk")
@IdClass(ErpBasZbkPk.class)
public class ErpBasZbk{
    


    /**
    * 指标ID,不能为空
    */
    @NotEmpty(message = "指标ID不能为空")
    @Id
    private String ZBID;


    /**
    * 指标名称,不能为空
    */
    @NotEmpty(message = "指标名称不能为空")
    private String ZBMC;


    /**
    * 指标维度（MM 月、Q季、YYYY年）,不能为空
    */
    @NotEmpty(message = "指标维度（MM 月、Q季、YYYY年）不能为空")
    @Id
    private String ZBWD;
    @Id
    private Integer KHFS;

    private Integer BBLX;


    /**
    * 指标函数表达式,不能为空
    */
    @NotEmpty(message = "指标函数表达式不能为空")
    private String EXPRESSION;

    private Integer SFQY;


    /**
    * 备注,不能为空
    */
    @NotEmpty(message = "备注不能为空")
    private String BZ;

    private Date LRSJ;

    private Integer LRBZ;
    
    
    /**
     *	 机构业绩
     */
    @OneToMany(mappedBy = "zb")
	@org.hibernate.annotations.ForeignKey(name = "none")
	private List<ErpAssessDataJgPhjfk> erpAssessDataJgPhjfks;


    /**
    * ,不能为空
    */
    @NotEmpty(message = "不能为空")
    private String LRR;
    @Id
    private Integer ZBDX;

    private Integer ZBLB;

	public String getZBID() {
		return ZBID;
	}

	public void setZBID(String zBID) {
		ZBID = zBID;
	}

	public String getZBMC() {
		return ZBMC;
	}

	public void setZBMC(String zBMC) {
		ZBMC = zBMC;
	}

	public String getZBWD() {
		return ZBWD;
	}

	public void setZBWD(String zBWD) {
		ZBWD = zBWD;
	}

	public Integer getKHFS() {
		return KHFS;
	}

	public void setKHFS(Integer kHFS) {
		KHFS = kHFS;
	}

	public Integer getBBLX() {
		return BBLX;
	}

	public void setBBLX(Integer bBLX) {
		BBLX = bBLX;
	}

	public String getEXPRESSION() {
		return EXPRESSION;
	}

	public void setEXPRESSION(String eXPRESSION) {
		EXPRESSION = eXPRESSION;
	}

	public Integer getSFQY() {
		return SFQY;
	}

	public void setSFQY(Integer sFQY) {
		SFQY = sFQY;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String bZ) {
		BZ = bZ;
	}

	public Date getLRSJ() {
		return LRSJ;
	}

	public void setLRSJ(Date lRSJ) {
		LRSJ = lRSJ;
	}

	public Integer getLRBZ() {
		return LRBZ;
	}

	public void setLRBZ(Integer lRBZ) {
		LRBZ = lRBZ;
	}

	public String getLRR() {
		return LRR;
	}

	public void setLRR(String lRR) {
		LRR = lRR;
	}

	public Integer getZBDX() {
		return ZBDX;
	}

	public void setZBDX(Integer zBDX) {
		ZBDX = zBDX;
	}

	public Integer getZBLB() {
		return ZBLB;
	}

	public void setZBLB(Integer zBLB) {
		ZBLB = zBLB;
	}

	public List<ErpAssessDataJgPhjfk> getErpAssessDataJgPhjfks() {
		return erpAssessDataJgPhjfks;
	}

	public void setErpAssessDataJgPhjfks(List<ErpAssessDataJgPhjfk> erpAssessDataJgPhjfks) {
		this.erpAssessDataJgPhjfks = erpAssessDataJgPhjfks;
	}

    
    
    
}