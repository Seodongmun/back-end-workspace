package com.kh._interface.step2;

public class Tv implements RemoteControl {

	private int volume;
	
	// Searchable
	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
		
	}
	
	// Volume
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Tv 볼륨 : " + this.volume);
	}
	
	// RemoteControl
	@Override
	public void turnOn() {
		System.out.println("Tv를 켭니다.");
		
	}
	
	// RemoteControl
	@Override
	public void turnOff() {
		System.out.println("Tv를 끕니다.");
	}

	
}
