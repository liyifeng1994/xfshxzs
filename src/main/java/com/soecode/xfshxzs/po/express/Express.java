package com.soecode.xfshxzs.po.express;

import java.util.List;

import com.soecode.xfshxzs.enums.ExpressStateEnum;

/**
 * 物流信息实体
 */
public class Express {

	// 状态码
	private int status;

	// 状态码信息
	private String message;

	private int ischeck;

	// 快递公司代码
	private String com;

	// 快递单号
	private String nu;

	private String condition;

	/**
	 * <pre>
	 * 快递单状态
	 * 
	 * 0：在途，即货物处于运输过程中
	 * 1：揽件，货物已由快递公司揽收并且产生了第一条跟踪信息
	 * 2：疑难，货物寄送过程出了问题
	 * 3：签收，收件人已签收
	 * 4：退签，即货物由于用户拒签、超区等原因退回，而且发件人已经签收
	 * 5：派件，即快递正在进行同城派件
	 * 6：退回，货物正处于退回发件人的途中
	 * 
	 * 订单状态枚举 {@link ExpressStateEnum}
	 * </pre>
	 * 
	 */
	private int state;

	// 物流跟踪项
	private List<ExpressItem> data;

	// WEB地址
	private String url;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getIscheck() {
		return ischeck;
	}

	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getNu() {
		return nu;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<ExpressItem> getData() {
		return data;
	}

	public void setData(List<ExpressItem> data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Express [status=" + status + ", message=" + message + ", ischeck=" + ischeck + ", com=" + com + ", nu="
				+ nu + ", condition=" + condition + ", state=" + state + ", data=" + data + ", url=" + url + "]";
	}

}
