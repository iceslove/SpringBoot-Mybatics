package com.wx.example.common.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangxiong on 2017/3/18.
 */
public class PageResult implements Serializable {

	private static final long serialVersionUID = -415196579462215370L;

	private int draw;

	private int page;

	private int recordsTotal;

	private int recordsFiltered;

	private List<?> items;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}
}

