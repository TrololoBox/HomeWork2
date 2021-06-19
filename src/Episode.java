
public class Episode {
	String name;
	String info;
	String releaseDate;
	
	public Episode() {
		name = "";
		info = "";
		releaseDate = "";
	}
	
	public Episode (Episode e) {
		this.name = e.getName();
		this.info = e.getInfo();
		this.releaseDate = e.getReleaseDate();
	}
	
	public Episode (String name,String info,String releasedDate) {
		this.name = name;
		this.info = info;
		this.releaseDate = releasedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void getEpisodeToString() {
		System.out.println("= = = = = = = = = = = = = = = = =");
		System.out.println("Name of Episode:   " + this.name);
		System.out.println("Info about Episode:   " + info);
		System.out.println("Release date:   " + releaseDate);
		System.out.println("= = = = = = = = = = = = = = = = =");


	}
	
	
	
}
