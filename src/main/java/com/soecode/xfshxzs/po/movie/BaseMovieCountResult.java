package com.soecode.xfshxzs.po.movie;

import java.util.List;

/**
 * 基本电影含数量结果实体
 *
 * @param <T>
 */
public class BaseMovieCountResult<T> {

	// 结果数量
	private int count;

	// 结果集合
	private List<T> data;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BaseMovieCountResult [count=" + count + "]";
	}

}
