package com.CoCoDa.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SelectKeyVO {

	private int allpop1;
	private int allpop2;
	private int allpop3;
	private int allpop4;
	private int manpop;
	private int womanpop;
	private int agepop10;
	private int agepop20;
	private int agepop30;
	private int agepop40;
	private int agepop50;
	private int agepop60;
	private int timepop1;
	private int timepop2;
	private int timepop3;
	private int timepop4;
	private int timepop5;
	private int timepop6;
	private int onweekpop;
	private int weekendpop;
	private int monpop;
	private int tuepop;
	private int wedpop;
	private int thrpop;
	private int fripop;
	private int satpop;
	private int sunpop;
	private int fixed_month;

	public SelectKeyVO() {
	}

	public SelectKeyVO(int allpop1, int allpop2, int allpop3, int allpop4, int manpop, int womanpop, int agepop10,
			int agepop20, int agepop30, int agepop40, int agepop50, int agepop60, int timepop1, int timepop2,
			int timepop3, int timepop4, int timepop5, int timepop6, int onweekpop, int weekendpop, int monpop,
			int tuepop, int wedpop, int thrpop, int fripop, int satpop, int sunpop, int fixed_month) {
		super();
		this.allpop1 = allpop1;
		this.allpop2 = allpop2;
		this.allpop3 = allpop3;
		this.allpop4 = allpop4;
		this.manpop = manpop;
		this.womanpop = womanpop;
		this.agepop10 = agepop10;
		this.agepop20 = agepop20;
		this.agepop30 = agepop30;
		this.agepop40 = agepop40;
		this.agepop50 = agepop50;
		this.agepop60 = agepop60;
		this.timepop1 = timepop1;
		this.timepop2 = timepop2;
		this.timepop3 = timepop3;
		this.timepop4 = timepop4;
		this.timepop5 = timepop5;
		this.timepop6 = timepop6;
		this.onweekpop = onweekpop;
		this.weekendpop = weekendpop;
		this.monpop = monpop;
		this.tuepop = tuepop;
		this.wedpop = wedpop;
		this.thrpop = thrpop;
		this.fripop = fripop;
		this.satpop = satpop;
		this.sunpop = sunpop;
		this.fixed_month = fixed_month;
	}

}
