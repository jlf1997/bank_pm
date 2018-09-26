package com.readboy.ssm.po;

import java.util.List;

/**
 * 对应我的客户详情页面
 * 包含 基本信息，关联人信息和持有产品，其中持有产品包含存款、贷款、手机银行和ETC四部分
 *
 */
public class CustomerMultipleQuery {
	private Customer customer;
	private List<RelatedPerson> relatedPerson;
	private List<DepositAccountFamily> depositAccountFamily;
	private List<LoanCustomerProduct> loanCustomerProduct;
	private List<CellBankCustomerProduct> cellBankCustomerProduct;
	private List<EtcCustomerFamily> etcCustomerFamily;
	
	public List<DepositAccountFamily> getDepositAccountFamily() {
		return depositAccountFamily;
	}
	
	public List<LoanCustomerProduct> getLoanCustomerProduct() {
		return loanCustomerProduct;
	}
	public List<CellBankCustomerProduct> getCellBankCustomerProduct() {
		return cellBankCustomerProduct;
	}
	public List<EtcCustomerFamily> getEtcCustomerFamily() {
		return etcCustomerFamily;
	}
	public void setDepositAccountFamily(
			List<DepositAccountFamily> depositAccountFamily) {
		this.depositAccountFamily = depositAccountFamily;
	}
	public void setLoanCustomerProduct(List<LoanCustomerProduct> loanCustomerProduct) {
		this.loanCustomerProduct = loanCustomerProduct;
	}
	public void setCellBankCustomerProduct(
			List<CellBankCustomerProduct> cellBankCustomerProduct) {
		this.cellBankCustomerProduct = cellBankCustomerProduct;
	}
	public void setEtcCustomerFamily(List<EtcCustomerFamily> etcCustomerFamily) {
		this.etcCustomerFamily = etcCustomerFamily;
	}
	public Customer getCustomer() {
		return customer;
	}
	public List<RelatedPerson> getRelatedPerson() {
		return relatedPerson;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setRelatedPerson(List<RelatedPerson> relatedPerson) {
		this.relatedPerson = relatedPerson;
	}
	
}
