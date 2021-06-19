import java.util.ArrayList;

public class Series {
	private String name = "";
	private ListOfEpisodes episodes = new ListOfEpisodes();
	private ListOfEpisodes watchedEpisodes = new ListOfEpisodes();

	private Episode lastWatchedEpisode = new Episode(null,null,null);
	private boolean fullWatched = false;
	
	public Series() {
	}
	
	public Series(Series s1) {
		this.name = s1.getName();
		this.episodes = s1.getEpisodes();
		this.lastWatchedEpisode = s1.getLastWatchedEpisode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Episode getLastWatchedEpisode() {
		return lastWatchedEpisode;
	}

	public void setLastWatchedEpisode(Episode lastWatchedEpisode) {
		this.lastWatchedEpisode = lastWatchedEpisode;
	}
	
	public void isWatchedAllSeries () {
		if (lastWatchedEpisode.equals(episodes.getEpisodeByIndex(episodes.getListOfEpisodes().length-1))) {
			fullWatched = true;
		}
	}
	
	public boolean isFullWatched() {
		return fullWatched;
	}

	public void setFullWatched(boolean fullWatched) {
		this.fullWatched = fullWatched;
	}

	public void addWatchedEpisode(Episode e) {
		watchedEpisodes.addToList(e);
	}
	
	public ListOfEpisodes getEpisodes() {
		return episodes;
	}

	public void setEpisodes(ListOfEpisodes episodes) {
		this.episodes = episodes;
	}

	public ListOfEpisodes getWatchedEpisodes() {
		return watchedEpisodes;
	}

	public void setWatchedEpisodes(ListOfEpisodes watchedEpisodes) {
		this.watchedEpisodes = watchedEpisodes;
	}
	
	public void addEpisode(Episode e) {
		episodes.addToList(e);
	}
	
	public Episode[] getListOfEpisodes() {
		return episodes.getListOfEpisodes();
	}
	
	public void setListOfEpisodes(Episode[] listOfEpisodes) {
		episodes.setListOfEpisodes(listOfEpisodes);
	}

	public Episode[] getListOfWatchedEpisodes() {
		return watchedEpisodes.getListOfEpisodes();
	}
	
	public void setListOfWatchedEpisodes(Episode[] listOfWatchedEpisodes) {
		watchedEpisodes.setListOfEpisodes(listOfWatchedEpisodes);
	}
	
	public void getSerialToString() {
		System.out.println("Name of choosen Serial is:  " + name);
		System.out.println("List of Episodes in this Serieal:  ");
		for (Episode episode : episodes.getListOfEpisodes()) {
			episode.getEpisodeToString();
		}


	}
	
	

}
