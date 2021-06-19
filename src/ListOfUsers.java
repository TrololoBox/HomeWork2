
public class ListOfUsers {
	User[] listOfUsers;
	int len = 1;
	public ListOfUsers() {
		listOfUsers = new User[len];
	}
	
	public void addToList (User o) {
		if (this.listOfUsers[0] == null) {
			this.listOfUsers[0] = o;
		}
		else {
			len++;
			User[] tempListUsers = new User[len];
			for (int i = 0; i < listOfUsers.length; i++) {
				tempListUsers[i] = this.listOfUsers[i];
			}
			tempListUsers[len-1] = o;
			this.listOfUsers = tempListUsers;
		}
	}
	
	public boolean isExsist(User o) {
		for (User user : listOfUsers) {
			if (user.equals(o)) {
				return true;
			}
		}
		return false;
		
	}
	
	public int getUserIndex(User o) {
		int counter = 0;
		while (!this.listOfUsers[counter].equals(o)) {
			counter++;			
		}
		return counter;
	}
	
	public User getUserByIndex(int index) {
		return this.listOfUsers[index];
	}

	public User[] getListOfUsers() {
		return this.listOfUsers;
	}

	public void setListOfUsers(User[] listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

}