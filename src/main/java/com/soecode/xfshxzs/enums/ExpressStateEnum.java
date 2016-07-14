package com.soecode.xfshxzs.enums;

/**
 * 物流状态枚举
 */
public enum ExpressStateEnum {

	ON(0, "在途"), PULL(1, "揽件"), DOUBT(2, "疑难"), SIGN(3, "签收"), RETURN_SIGN(4, "退签"), DELIVER(5, "派件"), SEND_BACK(6,
			"退回");

	// 状态码
	private int state;

	// 状态码信息
	private String stateInfo;

	private ExpressStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static ExpressStateEnum stateOf(int index) {
		for (ExpressStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
