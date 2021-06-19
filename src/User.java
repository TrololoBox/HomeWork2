import java.awt.List;
import java.net.PasswordAuthentication;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class User {
	private String userName;
	private String password;
	
	private String creationDate;
	private String expirationDate;
	private Calendar creationCalendar;
	private Calendar expirationCalendar;
	
	private ListOfSerials finishedSeries;
	private ListOfSerials startedSeries;
	private ListOfSerials allSeries;
	
	private ListOfEpisodes watchedEpisodes;
	
	private int finishedSeriesCount = 0;
	private int startedSeriesCount = 0;
	private int watchedEpisodesCount = 0;

	
	
	
	public User() {
		this.userName = "";
		this.password = "";
		this.creationCalendar = Calendar.getInstance();
		this.expirationCalendar  = Calendar.getInstance();
		this.expirationCalendar.add(Calendar.MONTH, 1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		creationDate = dateFormat.format(creationCalendar.getTime());
		expirationDate = dateFormat.format(expirationCalendar.getTime());

		
		finishedSeries = new ListOfSerials();
		startedSeries = new ListOfSerials();
		allSeries = new ListOfSerials();
		watchedEpisodes = new ListOfEpisodes();
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Calendar getCreationCalendar() {
		return creationCalendar;
	}

	public void setCreationCalendar(Calendar creationCalendar) {
		this.creationCalendar = creationCalendar;
	}

	public Calendar getExpirationCalendar() {
		return expirationCalendar;
	}

	public void setExpirationCalendar(Calendar expirationCalendar) {
		this.expirationCalendar = expirationCalendar;
	}


	public Series[] getFinishedSeries() {
		return finishedSeries.getListOfSerials();
	}

	public void setFinishedSeries(Series[] finishedSeries) {
		this.finishedSeries.setListOfSerials(finishedSeries);
	}

	public Series[] getStartedSeries() {
		return startedSeries.getListOfSerials();
	}

	public void setStartedSeries(Series[] startedSeries) {
		this.startedSeries.setListOfSerials(startedSeries);
	}

	public Series[] getAllSeries() {
		return allSeries.getListOfSerials();
	}

	public void setAllSeries(Series[] allSeries) {
		this.allSeries.setListOfSerials(allSeries);
	}

	public Episode[] getWatchedEpisodes() {
		return watchedEpisodes.getListOfEpisodes();
	}

	public void setWatchedEpisodes(Episode[] watchedEpisodes) {
		this.watchedEpisodes.setListOfEpisodes(watchedEpisodes);
	}

	public int getFinishedSeriesCount() {
		return finishedSeriesCount;
	}

	public void setFinishedSeriesCount(int finishedSeriesCount) {
		this.finishedSeriesCount = finishedSeriesCount;
	}

	public int getStartedSeriesCount() {
		return startedSeriesCount;
	}

	public void setStartedSeriesCount(int startedSeriesCount) {
		this.startedSeriesCount = startedSeriesCount;
	}

	public int getWatchedEpisodesCount() {
		return watchedEpisodesCount;
	}

	public void setWatchedEpisodesCount(int watchedEpisodesCount) {
		this.watchedEpisodesCount = watchedEpisodesCount;
	}


	
	public void addWatchedEpisode(Episode e) {
		watchedEpisodes.addToList(e);
	}
	
	public void addStartedSerial(Series s) {
		startedSeries.addToList(s);
		startedSeriesCount++;
	}
	
	public void removeStartedSerial(Series s) {
		startedSeries.removeFromList(s);
		startedSeriesCount--;

	}
	
	public void addFinishedSerial(Series s) {
		finishedSeries.addToList(s);
		finishedSeriesCount++;
	}
	
	public void removeFinishedSerial(Series s) {
		finishedSeries.removeFromList(s);
		finishedSeriesCount--;

	}
	public boolean isSerialStartedWatching(String nameOfSerial) {
		try {
			for (Series series : startedSeries.getListOfSerials()) {
				if(series.getName().equals(nameOfSerial)) return true;
			}
		} catch (NullPointerException e) {
			return false;
		}
		return false;
		
	}
	
	public Series getStartedSeriesByName(String name) {
		for (Series series : startedSeries.getListOfSerials()) {
			if(series.getName().equals(name)) return series;
			}
		return null;
	}
	

	public void ProfileToString() {//not final
		System.out.println("Creation date:   " + creationDate);
		System.out.println("Expiration date: " + expirationDate);
		System.out.println("Count of started serials: " + startedSeriesCount);//not final
		System.out.println("Count of finished serials: " + finishedSeriesCount);//not final
		System.out.println("Count of watched episodes: " + watchedEpisodesCount);//not final

	}


}
