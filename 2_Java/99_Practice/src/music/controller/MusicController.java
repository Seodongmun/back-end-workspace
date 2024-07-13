package music.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import music.model.Music;

public class MusicController {
	
	
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
		for (Music a : musicList) {
			System.out.println(a.getName() + " - " + a.getMusic());
		}
		return "출력 완료";
	}
	
//	4. 특정 곡 검색
	public void menu4(String serch) {
		for (Music a : musicList) {
			if (serch.equals(a.getMusic())) {
				System.out.println(a.getName() + " - " + a.getMusic() + " 을 검색하였습니다");
			} else if (!serch.equals(a.getMusic())) {
				System.out.println("리스트에 검색한 곡이 없습니다");
			}
			
		}
	}
	
//	5. 특정 곡 삭제
//	remove값 미구현
	public void menu5(String serch) {
//		Contains 의 value 값을 검색 후 삭제
		for (Music a : musicList) {
			// musicList 의 배열 인덱스 : a
			if (!serch.equals(a.getMusic())) {
				System.out.println("리스트에 검색한 곡이 없습니다");
			} else if (serch.equals(a.getMusic())) {
				musicList.remove(serch.equals(a.getMusic()));
				musicList.remove(serch.equals(a.getName()));
				System.out.println(a.getName() + " - " + a.getMusic() + " 을 삭제하였습니다");
			}
		}
	}

	
//	6. 특정 곡 수정
//	remove값 미구현
	public void menu6(String serch, String changeSong, String changeSinger) {
		for (Music a : musicList) {
			if (serch.equals(a.getMusic())) {
				System.out.println(a.getName() + " - " + a.getMusic() + " 을 검색하였습니다");
			} else {
				System.out.println("리스트에 검색한 곡이 없습니다");
			}
		}
		for (Music a : musicList) {
			// serch에 입력한 곡 명과 같은 이름을가진 인덱스를
			// changeSong 에 입력한 값으로 변환
			boolean check = true;
//			1. 검색결과가 true이면~
			if (serch.equals(a.getMusic()) == check) {
//				serch.equals(a.getMusic())의 반환값은 boolean
//				boolean 값을 int 로 형변환?
//				2. 검색결과와 일치한 음악을 삭제한다
				musicList.remove(musicList.equals(serch));
//				3. 하지만 remove의 반환값은 int
				musicList.add(new Music(changeSong, changeSinger));
				System.out.println(changeSong + " - " + changeSinger + "의 값이 변경되었습니다");
				System.out.println(musicList);
			}
		}
		System.out.println("수정할 곡을 찾지 못했습니다.");
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
