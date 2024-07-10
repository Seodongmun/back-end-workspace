package music.controller;

import java.util.ArrayList;
import java.util.Scanner;

import music.model.Music;

public class MusicController {
	
	private Music music = new Music();
	Scanner sc = new Scanner(System.in);
	ArrayList<String> musicList = new ArrayList<>();
	
	public void musicSelect1 () {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.println("노래 이름 입력 : ");
		String musicName = sc.nextLine();
		musicList.add(musicName);
		music.setMusic(musicName);
	
		System.out.println("가수 이름 입력 : ");
		String Name = sc.nextLine();
		musicList.add(Name);
		music.setName(Name);
		
		System.out.println("노래 이름 : " + musicName);
		System.out.println("가수 이름 : " + Name);
		System.out.println("추가 성공");
	}
	
	public void musicSelect2 () {
		System.out.println("****** 첫 위치에 곡 추가 ******");

		System.out.println("노래 이름 입력 : ");
		String musicName = sc.nextLine();
		System.out.println("가수 이름 입력 : ");
		String Name = sc.nextLine();
		musicList.add(0,Name);
		music.setMusic(musicName);
		music.setName(Name);
		
		System.out.println("노래 이름 : " + musicName);
		System.out.println("가수 이름 : " + Name);
		System.out.println("추가 성공");
	}
	
	public void musicSelect3 () {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println("저장된 노래 : " + musicList);
	}
	
	public void musicSelect4 () {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.println("검색할 곡 입력 : ");
		String serch = sc.nextLine();
//		Contains
		if (serch.equals(music.getMusic())) {
			
		}
		
	}
	
	public void musicSelect5 () {
		
	}
	
	public void musicSelect6 () {
		
		
	}
	
	public void musicSelect7 () {
		
		
	}
	
	public void musicSelect8 () {
		
		
	}
	
	
	
	
	
	
}
