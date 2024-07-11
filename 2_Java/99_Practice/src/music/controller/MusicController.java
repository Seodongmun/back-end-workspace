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

	public void musicSelect1() {
		// music과 name 필드에 app에서 받은 데이터 lise에 저장
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.println("노래 이름 입력 : ");
		String musicName = sc.nextLine();
		music.setMusic(musicName);
		System.out.println("가수 이름 입력 : ");
		String name = sc.nextLine();
		music.setName(name);
		musicList.add(new Music(musicName,name));
		System.out.println("노래 이름 : " + music.getMusic());
		System.out.println("가수 이름 : " + music.getName());
		System.out.println("추가 성공");

	}
	
	public void musicSelect2() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.println("노래 이름 입력 : ");
		String musicName = sc.nextLine();
		music.setMusic(musicName);
		System.out.println("가수 이름 입력 : ");
		String name = sc.nextLine();
		music.setName(name);
		musicList.add(0,new Music(musicName,name));
		System.out.println("노래 이름 : " + music.getMusic());
		System.out.println("가수 이름 : " + music.getName());
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
		for(Music a : musicList) {
			if (serch.equals(a.getMusic())) {
				System.out.println(a.getName() + " - " + a.getMusic() + " 을 검색하였습니다");
			} else if (!serch.equals(a.getMusic())){
				System.out.println("리스트에 검색한 곡이 없습니다");
			}
			
		}
		
	}
	
	public void musicSelect5 () {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.println("삭제할 곡 입력 : ");
		String remove = sc.nextLine();
//		Contains 의 value 값을 검색 후 삭제
		for(Music a : musicList) {
			if (remove.equals(a.getMusic())) {
				// 0번째 인덱스가아닌 remove.equals(의 값이 삭제되어야 함)
				musicList.remove(0);
				System.out.println(a.getName() + " - " + a.getMusic() + " 을 삭제하였습니다");
			} else if (!remove.equals(a.getMusic())){
				System.out.println("리스트에 검색한 곡이 없습니다");
			}
		}
		
	}
	
	public void musicSelect6 () {
		System.out.println("****** 특정 곡 수정 ******");
//		value 값을 검색후
		System.out.println("검색할 곡 명 : ");
		String serch = sc.nextLine();
		for(Music a : musicList) {
			if (serch.equals(a.getMusic())) {
				System.out.println(a.getName() + " - " + a.getMusic() + " 을 검색하였습니다");
			} else if (!serch.equals(a.getMusic())){
				System.out.println("리스트에 검색한 곡이 없습니다");
			}
			
		}
//		key값과
		System.out.println("수정할 곡 명 : ");
		String changeSong = sc.nextLine();
//		value값을 수정
		System.out.println("수정할 가수 명 : ");
		String changeSinger = sc.nextLine();
		
		System.out.println("수정할 곡을 찾지 못했습니다.");

	}
	
	public void musicSelect7 () {
		
		
	}
	
	public void musicSelect8 () {
		
		
	}
	
	
	
	
	
	
}
