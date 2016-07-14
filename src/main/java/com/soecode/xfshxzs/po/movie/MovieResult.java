package com.soecode.xfshxzs.po.movie;

/**
 * 基本电影结果实体
 *
 * @param <T>
 */
public class MovieResult<T> {

	private int res;

	private T data;

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BaseResult [res=" + res + ", data=" + data + "]";
	}

}
