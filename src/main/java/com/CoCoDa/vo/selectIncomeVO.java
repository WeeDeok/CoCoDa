package com.CoCoDa.vo;

public class selectIncomeVO {
			
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
		
		public selectIncomeVO() {}

		public selectIncomeVO(int fixed_month, int incomerate, int month_income, int food, int cloth, int living, int medi,
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

		public int getFixed_month() {
			return fixed_month;
		}

		public void setFixed_month(int fixed_month) {
			this.fixed_month = fixed_month;
		}

		public int getIncomerate() {
			return incomerate;
		}

		public void setIncomerate(int incomerate) {
			this.incomerate = incomerate;
		}

		public int getMonth_income() {
			return month_income;
		}

		public void setMonth_income(int month_income) {
			this.month_income = month_income;
		}

		public int getFood() {
			return food;
		}

		public void setFood(int food) {
			this.food = food;
		}

		public int getCloth() {
			return cloth;
		}

		public void setCloth(int cloth) {
			this.cloth = cloth;
		}

		public int getLiving() {
			return living;
		}

		public void setLiving(int living) {
			this.living = living;
		}

		public int getMedi() {
			return medi;
		}

		public void setMedi(int medi) {
			this.medi = medi;
		}

		public int getTransport() {
			return transport;
		}

		public void setTransport(int transport) {
			this.transport = transport;
		}

		public int getHobby() {
			return hobby;
		}

		public void setHobby(int hobby) {
			this.hobby = hobby;
		}

		public int getCulture() {
			return culture;
		}

		public void setCulture(int culture) {
			this.culture = culture;
		}

		public int getEdu() {
			return edu;
		}

		public void setEdu(int edu) {
			this.edu = edu;
		}

		public int getPlay() {
			return play;
		}

		public void setPlay(int play) {
			this.play = play;
		}

		@Override
		public String toString() {
			return "selectincome [fixed_month=" + fixed_month + ", incomerate=" + incomerate + ", month_income="
					+ month_income + ", food=" + food + ", cloth=" + cloth + ", living=" + living + ", medi=" + medi
					+ ", transport=" + transport + ", hobby=" + hobby + ", culture=" + culture + ", edu=" + edu + ", play="
					+ play + "]";
		}
		
	}


