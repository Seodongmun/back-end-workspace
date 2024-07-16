package music.model;

import java.util.Objects; 

public class Music implements Comparable<Music> {
	
	private String music;
	private String name;
	
	public Music() {
		super();
	}
	public Music(String music, String name) {
		super();
		this.music = music;
		this.name = name;
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return music + " - " + name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(music, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		return Objects.equals(music, other.music) && Objects.equals(name, other.name);
	}
	
//	정렬
//	정렬용 클래스 따로 생성해야함
	@Override
	public int compareTo(Music o) {
		// 음악 정렬
		return this.music.compareTo(o.music);
	}
	public int compareTo2(Music i) {
		// 이름 정렬
		return this.name.compareTo(i.name);
	}
	
	
	
}
