package music.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import music.model.Music;

public class MusicController {
	
	boolean check = true;
	
	
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Music> musicList = new ArrayList<Music>();

//	1. 마지막 위치에 곡 추가
	public String menu1(String musicName, String name) {
		musicList.add(new Music(musicName, name));
		return "추가 성공!";
	}
	
//	2. 첫 위치에 곡 추가
	public String menu2(String musicName, String name) {
		musicList.add(0, new Music(musicName, name));
		return "추가 성공!";
	}
	
//  매개변수는 app에서 입력한 값 = String musicName 과 String name
//	3. 전체 곡 검색
	public String menu3() {
		String str = "";
		for (Music a : musicList) {
			str += a.getName() + " - " + a.getMusic() + "\n";
		}
		return str;
	}
	
//	4. 특정 곡 검색
//	menu4 는 검색 메서드
	public String menu4(String serch) {
		String str = "";
		for (Music a : musicList) {
			if (serch.equals(a.getMusic())) {
				str = a.getName() + " - " + a.getMusic() + " 을 검색하였습니다";
			}
		}
		return str;
	}
//	5. 특정 곡 삭제

	public String menu5(String serch) {
		Music delete = null;
		for(Music music : musicList) {
			if(serch.equals(music.getMusic())) {
				int index = musicList.indexOf(music);
				delete = musicList.remove(index);
			}
		}
		return delete.getName() + " - " + delete.getMusic() + " 을 삭제하였습니다";
	}

//	6. 특정 곡 수정
//	삭제 & 검색 메서드
	public String menu6(String serch, String changeSong, String changeSinger) {
		Music delete = null;
		String str = "";
		for (Music music : musicList) {
			if (serch.equals(music.getName())) {
				int index = musicList.indexOf(music);
//				musicList.set(index, music.getName());
				delete = musicList.remove(index);
				
			} 
		}
		return str;
	}
//	7. 가수 명 내림차순 정렬
	public String menu7() {
		musicList.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(name -> System.out.println(name + " "));
		return "정렬이 완료되었습니다";
	}
//	8. 곡 명 오름차순 정렬
	public String menu8() {
		musicList.stream()
		.sorted()
		.forEach(music -> System.out.println(music + " "));
		return "정렬이 완료되었습니다";
	}
}
