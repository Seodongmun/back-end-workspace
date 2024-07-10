package music.controller;

import java.util.ArrayList;
import java.util.Scanner;

import music.model.Music;

public class MusicController {
	
	private Music music = new Music();
	Scanner sc = new Scanner(System.in);
	ArrayList<Music> musicList = new ArrayList<>();
	
	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public ArrayList<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(ArrayList<Music> musicList) {
		this.musicList = musicList;
	}

	public void musicSelect1 (String musicName, String name) {
		// music과 name 필드에 app에서 받은 데이터 lise에 저장
		musicList.add(new Music(musicName,name));
		
	
	}
	
	public void musicSelect2 (String musicName, String name) {
		music.setMusic(musicName);
		music.setName(name);
		musicList.add(0,name);
		System.out.println("노래 이름 : " + musicName);
		System.out.println("가수 이름 : " + name);
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
