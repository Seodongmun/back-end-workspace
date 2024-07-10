package music.model;

import java.util.Objects;

public class Music {
	
	private String music;
	private String Name;
	
	public Music() {
	}
	public Music(String music, String name) {
		super();
		this.music = music;
		Name = name;
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "Music [music=" + music + ", Name=" + Name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Name, music);
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
		return Objects.equals(Name, other.Name) && Objects.equals(music, other.music);
	}
	
	
	

}
