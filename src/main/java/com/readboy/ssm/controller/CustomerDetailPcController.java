package com.readboy.ssm.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.readboy.ssm.po.CellBankCustomer;
import com.readboy.ssm.po.CellBankCustomerPerson;
import com.readboy.ssm.po.CellBankCustomerProduct;
import com.readboy.ssm.po.Customer;
import com.readboy.ssm.po.CustomerDetail;
import com.readboy.ssm.po.DepositAccountFamily;
import com.readboy.ssm.po.DepositAccountPerson;
import com.readboy.ssm.po.DepositCustomer;
import com.readboy.ssm.po.EtcCustomerFamily;
import com.readboy.ssm.po.LoanCustomerFamily;
import com.readboy.ssm.po.LoanCustomerPerson;
import com.readboy.ssm.po.LoanCustomerProduct;
import com.readboy.ssm.po.RelatedPerson;
import com.readboy.ssm.service.CellBankCustomerPersonService;
import com.readboy.ssm.service.CellBankCustomerProductService;
import com.readboy.ssm.service.CustomerService;
import com.readboy.ssm.service.DepositAccountFamilyService;
import com.readboy.ssm.service.DepositAccountPersonService;
import com.readboy.ssm.service.EtcCustomerFamilyService;
import com.readboy.ssm.service.LoanCustomerPersonService;
import com.readboy.ssm.service.LoanCustomerProductService;
import com.readboy.ssm.service.RelatedPersonService;

/**
 *	返回我的客户详情页面信息
 * 	@author Administrator
 * 	这里全是响应PC端请求
 */
@Controller
public class CustomerDetailPcController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private RelatedPersonService relatedPersonService;
	@Autowired
	private DepositAccountFamilyService depositAccountFamilyService;
	@Autowired
	private DepositAccountPersonService depositAccountPersonService;
	@Autowired
	private LoanCustomerProductService loanCustomerProductService;
	@Autowired
	private LoanCustomerPersonService loanCustomerPersonService;
	@Autowired
	private CellBankCustomerProductService cellBankCustomerProductService;
	@Autowired
	private CellBankCustomerPersonService cellBankCustomerPersonService;
	@Autowired
	private EtcCustomerFamilyService etcCustomerFamilyService;
	
	@RequestMapping(value="/findCustomerDetail.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findCustomerDetail(
			@RequestParam("khbh") String khbh, 
			@RequestParam("ghrgh") String ghrgh,
			@RequestParam(value="condition",required=false) String condition,
			ModelAndView modelAndView) throws Exception{

		CustomerDetail customerDetail = new CustomerDetail();
		//基本信息
		Customer customer = customerService.findCustomerByKhbhAndGhrgh(khbh, ghrgh,condition);
		
		customerDetail.setCustomer(customer);

		//关联人信息
		if(customer != null &&customer.getJgdm() != null){
			String jgdm = customer.getJgdm();
			List<RelatedPerson> relatedPerson = relatedPersonService.findRelatedPersonByKhbhAndJgdm(khbh, jgdm);
			customerDetail.setRelatedPerson(relatedPerson);
			//存款产品信息
			DepositAccountFamily depositAccountFamily = depositAccountFamilyService.findOneDepositAccountFamilyByKhbhAndJgdm(khbh,jgdm);
			customerDetail.setDepositAccountFamily(depositAccountFamily);
			//存款管户人
			List<DepositAccountPerson> depositAccountPerson = depositAccountPersonService.findAllDepositAccountPersonByKhbhAndJgdm(khbh, jgdm);
			customerDetail.setDepositAccountPerson(depositAccountPerson);
			//贷款产品信息
			LoanCustomerProduct loanCustomerProduct = loanCustomerProductService.findOneLoanProductsByKhbhAndJgdm(khbh, jgdm);
			customerDetail.setLoanCustomerProduct(loanCustomerProduct);
			//贷款管户人信息
			String hth = "";
			if(loanCustomerProduct != null) 
				hth = loanCustomerProduct.getHth();
			List<LoanCustomerPerson> loanCustomerPerson = loanCustomerPersonService.findLoanPersonsByKhbhAndJgdm(khbh, jgdm, hth);
			customerDetail.setLoanCustomerPerson(loanCustomerPerson);
			
			//手机银行产品信息
			CellBankCustomerProduct cellBankCustomerProduct = cellBankCustomerProductService.findOneCellBankProductsByKhbhAndJgdm(khbh, jgdm);
			customerDetail.setCellBankCustomerProduct(cellBankCustomerProduct);

			//手机银行管户人
			List<CellBankCustomerPerson> cellBankCustomerPerson = cellBankCustomerPersonService.findCellBankPersonsByKhbhAndJgdm(khbh, jgdm);
			customerDetail.setCellBankCustomerPerson(cellBankCustomerPerson);

			//ETC产品信息
			EtcCustomerFamily etcCustomerFamily = etcCustomerFamilyService.findOneEtcCustomerFamilysByKhbhAndJgdm(khbh, jgdm);
			customerDetail.setEtcCustomerFamily(etcCustomerFamily);
		}
		modelAndView.addObject("one",customerDetail);
		modelAndView.setViewName("client/clientDetail");
		return modelAndView;
	}


	@RequestMapping(value="/findDepositCustomer.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView responseDepositCustomerJson(String khbh, String jgdm,ModelAndView modelAndView) throws Exception{
		DepositCustomer depositCustomer = new DepositCustomer();
		//存款产品信息
		List<DepositAccountFamily> depositAccountFamily = depositAccountFamilyService.findAllDepositAccountFamilyByKhbhAndJgdm(khbh, jgdm);
		depositCustomer.setDepositAccountFamilys(depositAccountFamily);
		//存款管户人
		List<DepositAccountPerson> depositAccountPerson = depositAccountPersonService.findAllDepositAccountPersonByKhbhAndJgdm(khbh, jgdm);
		depositCustomer.setDepositAccountPersons(depositAccountPerson);
		modelAndView.addObject("one",depositCustomer);
		modelAndView.setViewName("client/customerDeposit");
		return modelAndView;
	}

	@RequestMapping(value="/findCellBankCustomer.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView responseCellBankCustomerJson(String khbh, String jgdm,
			ModelAndView modelAndView) throws Exception{
		CellBankCustomer cellBankCustomer = new CellBankCustomer();
		//手机银行产品信息
		List<CellBankCustomerProduct> cellBankCustomerProducts = cellBankCustomerProductService.findCellBankProductsByKhbhAndJgdm(khbh, jgdm);
		cellBankCustomer.setCellBankCustomerProducts(cellBankCustomerProducts);
		//手机银行管户人
		List<CellBankCustomerPerson> cellBankCustomerPersons = cellBankCustomerPersonService.findCellBankPersonsByKhbhAndJgdm(khbh, jgdm);
		cellBankCustomer.setCellBankCustomerPersons(cellBankCustomerPersons);
		modelAndView.addObject("one",cellBankCustomer);
		modelAndView.setViewName("client/customerCellBank");
		return modelAndView;
	}


	@RequestMapping(value="/findLoanCustomer.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findLoanCustomer(String khbh, String jgdm,ModelAndView modelAndView) throws Exception{
		//贷款产品信息
		List<LoanCustomerFamily> list = new ArrayList<LoanCustomerFamily>();
		List<String> hths = loanCustomerProductService.findLoanProductsHthByKhbhAndJgdm(khbh, jgdm);
		for(String hth : hths){
			LoanCustomerFamily loanCustomerFamily = new LoanCustomerFamily();
			loanCustomerFamily.setHth(hth);
			loanCustomerFamily.setLoanCustomerProduct(loanCustomerProductService.findLoanProductsByHth(khbh, jgdm, hth));
			loanCustomerFamily.setLoanCustomerPerson(loanCustomerPersonService.findLoanPersonsByKhbhAndJgdm(khbh, jgdm, hth));
			list.add(loanCustomerFamily);
		}
		modelAndView.addObject("list",list);
		modelAndView.setViewName("client/customerLoan");
		return modelAndView;
	}

	@RequestMapping(value="/findEtcCustomer.action",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findEtcCustomer(String khbh, String jgdm,
			ModelAndView modelAndView) throws Exception{
		List<EtcCustomerFamily> list = etcCustomerFamilyService.findEtcCustomerFamilysByKhbhAndJgdm(khbh, jgdm);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("client/customerEtc");
		return modelAndView;
	}

}
