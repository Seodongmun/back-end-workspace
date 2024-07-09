package com.kh.example.practice1;

public class Lotto implements Comparable<Lotto>{
	
	private int lottoNum;
	private int myNum;
	
	public Lotto() {
	}
	public Lotto(int lottoNum, int myNum) {
		super();
		this.lottoNum = lottoNum;
		this.myNum = myNum;
	}

	public int getLottoNum() {
		double lottoNum = Math.random();
		lottoNum = Math.random() * 45;
		return (int) lottoNum;
	}
	public void setLottoNum(int lottoNum) {
		this.lottoNum = lottoNum;
		
	}
	
	public int getMyNum() {
		double MyNum = Math.random();
		MyNum = Math.random() * 45;
		
		return (int) MyNum ;
	}
	public void setMyNum(int myNum) {
		this.myNum = myNum;
	}

	@Override
	public String toString() {
		return "Lotto [lottoNum=" + lottoNum + ", myNum=" + myNum + "]";
	}
	@Override
	public int compareTo(Lotto o) {
		return this.lottoNum == o.lottoNum ? 0 : this.lottoNum > o.lottoNum ? 1 : -1;
	}
	
	
	
}
