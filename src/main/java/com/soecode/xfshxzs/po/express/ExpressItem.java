package com.soecode.xfshxzs.po.express;

/**
 * 物流跟踪项
 */
public class ExpressItem {
	
	//时间
	private String time;

	//内容
	private String context;

	private String ftime;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	@Override
	public String toString() {
		return "ExpressItem [time=" + time + ", context=" + context + ", ftime=" + ftime + "]";
	}

}
