package music.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import music.model.Music;

public class MusicController {
	
	boolean check = true;
	
	Scanner sc = new Scanner(System.in);
	private ArrayList<Music> musicList = new ArrayList<Music>();

//	1. 마지막 위치에 곡 추가
	public String menu1(String musicName, String name) {
		musicList.add(new Music(musicName, name));
		return "추가 성공!";
	}
	
//	1. 마지막 위치에 곡 추가
//	public String menu1(Music music) {
//		
//		musicList.add(music);
//		return "추가 성공!";
//	}
	
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
		return str ;
	}
	
	
	
//	4. 특정 곡 검색
//	menu4 는 검색 메서드
	public String menu4(String search) {
		String str = "";
		for (Music music : musicList) {
//			contains를 사용하면 포함만 되어도 검색이 가능
			if (music.getMusic().contains(search)) {
				str += music.getName() + " - " + music.getMusic() + " 을 검색하였습니다";
			}
		}
		return str;
	}
	
//	5. 특정 곡 삭제

	public String menu5(String search) {
		Music delete = null;
		int index = 0;
		for(Music music : musicList) {
			if(music.getMusic().equals(search)) {
				index = musicList.indexOf(music);
			}
		} 
		delete = musicList.remove(index);
		return delete.getName() + " - " + delete.getMusic() + " 을 삭제하였습니다";
	}

//	6. 특정 곡 수정
//	삭제 & 검색 메서드
	public String menu6(String search, String changeSong, String changeSinger) {
		for (Music music : musicList) {
			if (music.getMusic().contains(search)) {
				musicList.set(musicList.indexOf(music), new Music(changeSong, changeSinger));
			}
		}
//		set은 굳이 삭제하지 않아도
//		조건에 맞는 index값의 value 값을 수정해준다
		return search + " 을 " + changeSong + " 의 " + changeSinger + "으로 변경하였습니다";
	}

//	7. 가수 명 내림차순 정렬
	public String menu7() {
//		ArrayList<Music> cloneList =( ArrayList<Music> )musicList.clone();
//		Colloections.sort(cloneList, new 정렬용 파일명)
		
		musicList.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(name -> System.out.println(name + " "));
	
		return "정렬 완료";
	}
	
//	8. 곡 명 오름차순 정렬
	public String menu8() {
//		ArrayList<Music> cloneList =( ArrayList<Music> )musicList.clone();
//		Colloections.sort(cloneList, new 정렬용 파일명)
		
		musicList.stream()
		.sorted()
		.forEach(musicName -> System.out.println(musicName + " "));
		return "정렬 완료";
		
	}
}






