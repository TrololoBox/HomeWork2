
public class ListOfSerials {

	Series[] listOfSerials;
	
	public ListOfSerials() {
		this.listOfSerials = new Series[1];
		
	}
	
	public void addToList (Series s) {
		if (this.listOfSerials[0] == null) {
			this.listOfSerials[0] = s;
		}
		else {
			Series[] tempListSerials = new Series[this.listOfSerials.length + 1];
			for (int i = 0; i < listOfSerials.length; i++) {
				tempListSerials[i] = this.listOfSerials[i];
			}
			tempListSerials[tempListSerials.length-1] = s;
			this.listOfSerials = tempListSerials;

		}
	}
	public void removeFromList(Series s) {
		this.listOfSerials[getSerialIndex(s)] = null;
		Series[] tempListSerials = new Series[this.listOfSerials.length - 1];
		int j = 0;
		for (int i = 0; i < listOfSerials.length; i++) {
			if (listOfSerials[i].equals(null)) {

			}
			else {
				tempListSerials[j] = listOfSerials[i];
				j++;
			}
		}
	}
	
	public boolean isExsist(Series o) {
		for (Series Serial : listOfSerials) {
			if (Serial.equals(o)) {
				return true;
			}
		}
		return false;
		
	}
	
	public int getSerialIndex(Series o) {
		int counter = 0;
		while (!this.listOfSerials[counter].equals(o)) {
			counter++;			
		}
		return counter;
	}
	
	public Series getSerialByIndex(int index) {
		return this.listOfSerials[index];
	}

	public Series[] getListOfSerials() {
		return listOfSerials;
	}

	public void setListOfSerials(Series[] listOfSerials) {
		this.listOfSerials = listOfSerials;
	}
	
}

