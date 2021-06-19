
public class ListOfEpisodes {

	private Episode[] listOfEpisodes;
	private int len = 1;
	
	public ListOfEpisodes() {
		this.listOfEpisodes = new Episode[len];
		
	}
	
	public void addToList (Episode o) {
		if (this.listOfEpisodes[0] == null) {
			this.listOfEpisodes[0] = o;
		}
		else {
			len++;
			Episode[] tempListEpisodes = new Episode[len];
			for (int i = 0; i < listOfEpisodes.length; i++) {
				tempListEpisodes[i] = this.listOfEpisodes[i];
			}
			tempListEpisodes[len-1] = o;
			this.listOfEpisodes = tempListEpisodes;

		}
		
		
	}
	
	public boolean isExsist(Episode o) {
		for (Episode Episode : listOfEpisodes) {
			if (Episode.equals(o)) {
				return true;
			}
		}
		return false;
		
	}
	
	public int getEpisodeIndex(Episode o) {
		int counter = 0;
		while (!this.listOfEpisodes[counter].equals(o)) {
			counter++;			
		}
		return counter;
	}
	
	public Episode getEpisodeByIndex(int index) {
		return this.listOfEpisodes[index];
	}

	public Episode[] getListOfEpisodes() {
		return listOfEpisodes;
	}

	public void setListOfEpisodes(Episode[] listOfEpisodes) {
		this.listOfEpisodes = listOfEpisodes;
	}

}

