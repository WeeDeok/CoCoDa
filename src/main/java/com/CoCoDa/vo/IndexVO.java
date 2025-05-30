package com.CoCoDa.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IndexVO {

	private String cx;
	private String cy;
	private String[] sales_num;
	private String[] sigungu_cd;
	private String[] sigungu_nm;
	private String sales_division_s_cd;
	private String address;
	private String[] sales_nm;

	public IndexVO(String cx, String cy, String[] sales_num, String[] sigungu_cd, String[] sigungu_nm,
			String sales_division_s_cd, String address, String[] sales_nm) {
		super();
		this.cx = cx;
		this.cy = cy;
		this.sales_num = sales_num;
		this.sigungu_cd = sigungu_cd;
		this.sigungu_nm = sigungu_nm;
		this.sales_division_s_cd = sales_division_s_cd;
		this.address = address;
		this.sales_nm = sales_nm;
	}

	public IndexVO() {
		super();
	}

} // class
