package com.CoCoDa.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SelectIncomeVO {
			
		private int fixed_month;
		private int incomerate;
		private int month_income;
		private int food;
		private int cloth;
		private int living;
		private int medi;
		private int transport;
		private int hobby;
		private int culture;
		private int edu;
		private int play;
		
		public SelectIncomeVO() {}

		public SelectIncomeVO(int fixed_month, int incomerate, int month_income, int food, int cloth, int living, int medi,
				int transport, int hobby, int culture, int edu, int play) {
			super();
			this.fixed_month = fixed_month;
			this.incomerate = incomerate;
			this.month_income = month_income;
			this.food = food;
			this.cloth = cloth;
			this.living = living;
			this.medi = medi;
			this.transport = transport;
			this.hobby = hobby;
			this.culture = culture;
			this.edu = edu;
			this.play = play;
		}

	}


