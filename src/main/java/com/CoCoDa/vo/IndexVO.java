package com.CoCoDa.vo;

import java.util.Arrays;

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
		// TODO Auto-generated constructor stub
	}

	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}

	public String getCy() {
		return cy;
	}

	public void setCy(String cy) {
		this.cy = cy;
	}

	public String[] getSales_num() {
		return sales_num;
	}

	public void setSales_num(String[] sales_num) {
		this.sales_num = sales_num;
	}

	public String[] getSigungu_cd() {
		return sigungu_cd;
	}

	public void setSigungu_cd(String[] sigungu_cd) {
		this.sigungu_cd = sigungu_cd;
	}

	public String[] getSigungu_nm() {
		return sigungu_nm;
	}

	public void setSigungu_nm(String[] sigungu_nm) {
		this.sigungu_nm = sigungu_nm;
	}

	public String getSales_division_s_cd() {
		return sales_division_s_cd;
	}

	public void setSales_division_s_cd(String sales_division_s_cd) {
		this.sales_division_s_cd = sales_division_s_cd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getSales_nm() {
		return sales_nm;
	}

	public void setSales_nm(String[] sales_nm) {
		this.sales_nm = sales_nm;
	}

	@Override
	public String toString() {
		return "IndexVO [cx=" + cx + ", cy=" + cy + ", sales_num=" + Arrays.toString(sales_num) + ", sigungu_cd="
				+ Arrays.toString(sigungu_cd) + ", sigungu_nm=" + Arrays.toString(sigungu_nm) + ", sales_division_s_cd="
				+ sales_division_s_cd + ", address=" + address + ", sales_nm=" + Arrays.toString(sales_nm) + "]";
	}

} // class
