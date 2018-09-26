package com.readboy.ssm.po;

public class DataCalendar {
	private Long data_id;			//数据处理id
    private String data_time;		//数据日期
    private String start_time;		//数据处理开始时间
    private String end_time;		//数据处理结束时间
    private Integer data_type;		//数据处理类型，导入：1，导出0
    private String fail_cause;		//数据处理失败原因，空就是没出错
    private Integer consume_time;	//数据处理耗时 单位分钟
    private Integer data_status;    //数据处理完成标识，成功：1，失败0
    
	
	public Long getData_id() {
		return data_id;
	}
	public void setData_id(Long data_id) {
		this.data_id = data_id;
	}
	public String getData_time() {
		return data_time;
	}
	public void setData_time(String data_time) {
		this.data_time = data_time;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer getData_type() {
		return data_type;
	}
	public void setData_type(Integer data_type) {
		this.data_type = data_type;
	}
	public String getFail_cause() {
		return fail_cause;
	}
	public void setFail_cause(String fail_cause) {
		this.fail_cause = fail_cause;
	}
	public Integer getConsume_time() {
		return consume_time;
	}
	public void setConsume_time(Integer consume_time) {
		this.consume_time = consume_time;
	}
	public Integer getData_status() {
		return data_status;
	}
	public void setData_status(Integer data_status) {
		this.data_status = data_status;
	}
}
