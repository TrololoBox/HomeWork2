import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.PrimitiveIterator.OfDouble;
import java.util.jar.Attributes.Name;

public class Main {
	

	private static User currentUser;
	private static Series currentSeries;
	
	private static ListOfUsers listOfUsers = new ListOfUsers();
	private static ListOfSerials listOfSerials = new ListOfSerials();


	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		User user1 = new User();
		user1.setUserName("ololo");
		user1.setPassword("1234");
		
		User user2 = new User();
		user2.setUserName("bebebe");
		user2.setPassword("1234");
		

		listOfUsers.addToList(user1);
		listOfUsers.addToList(user2);
		

		Series s1 = new Series();
		Series s2 = new Series();

		s1.setName("Game of Thrones");
		s2.setName("Rick and Morty");

		Episode e1 = new Episode("First chapter", "Hello all", "01/01/2020");
		Episode e2 = new Episode("Second chapter", "Peace all", "02/01/2020");
		Episode e3 = new Episode("Third chapter", "Kill all", "03/01/2020");
		Episode e4 = new Episode("Fourth chapter", "War all", "04/01/2020");
		
		Episode e11 = new Episode("Madness", "Hello all", "01/01/2020");
		Episode e22 = new Episode("More Madness", "He mad", "02/01/2020");
		Episode e33 = new Episode("Double Madness", "They mad", "03/01/2020");
		Episode e44 = new Episode("Triple Madness", "All mad", "04/01/2020");
		
		
		s1.addEpisode(e1);
		s1.addEpisode(e2);
		s1.addEpisode(e3);
		s1.addEpisode(e4);

		s2.addEpisode(e11);
		s2.addEpisode(e22);
		s2.addEpisode(e33);
		s2.addEpisode(e44);

		listOfSerials.addToList(s1);
		listOfSerials.addToList(s2);

		MainMenu();
	}
	
	public static void MainMenu() {
		System.out.println("1 - Create account");
		System.out.println("2 - Enter to account");

		Scanner scanner= new Scanner(System.in);
		int choice;
		
		try {
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				CreateAccount();
				break;
			
			case 2:
				JoinToAccount();
				break;
			default:
				System.out.println("Wrong choice. Try Again!");
				MainMenu();
			} 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something goes wrong. Try again!");
			MainMenu();
		}
	}
	
	public static void CreateAccount() {
		System.out.println("Enter Nickname you want:");
		Scanner scanner= new Scanner(System.in);
		String nickname = scanner.next();		
		
		while (IsAlreadyTaken(nickname)) {
			System.out.println("This Nickname already taken. Please choose another one.");
			nickname = scanner.next();
		}

		System.out.println("Enter Password you want. password needs to be at least one english letter and one number.");
		String password = scanner.next();
		
		while (!isPasswordGood(password)) {
			System.out.println("Your password not safe enought. Password needs to be at least one english letter and one number.");
			password = scanner.next();
		}
		
		User toAdd = new User(); 
		toAdd.setUserName(nickname);
		toAdd.setPassword(password);
		listOfUsers.addToList(toAdd);
		System.out.println("Account created!");
		MainMenu();
	}

	public static boolean IsAlreadyTaken (String nickName) {
		for (User user1 : listOfUsers.getListOfUsers()) {
			if (user1.getUserName().equals(nickName)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPasswordGood(String password) {
		boolean containsLetter = false;
		boolean containsNumber = false;
		
		for (char char1 : password.toCharArray()) {
			if(Character.isAlphabetic(char1)) {
				containsLetter = true;
			}
			
			if(Character.isDigit(char1)){
				containsNumber = true;
			}
		}
		
		if (containsNumber && containsLetter && password.length() > 5 ) {
			return true;
		}			
		return false;
	}
	
	public static void JoinToAccount() {
		System.out.println("Enter Nickname");
		Scanner scanner= new Scanner(System.in);
		String nickname = scanner.nextLine();
		currentUser = new User();
		
		if (!IsAlreadyTaken(nickname)) {
			System.out.print("No account with this nickname");
			MainMenu();	
		}
		
		currentUser = GiveMeThisUser(nickname); 
		
		System.out.println("Enter Password");
		String password = scanner.next();
		int failTries = 0;
		while (failTries <5) {
			if (currentUser.getPassword().equals(password)) {
				System.out.println("Succesfull enter. Hello, " + currentUser.getUserName());
				UserActivity();
				}
			System.out.println("Wrong password. Enter Password again");
			password = scanner.next();
			failTries++;
		}
		
		System.out.println("You entered the wrong password 5 times. Back to previous menu.");
		MainMenu();
	}
	
	public static User GiveMeThisUser(String nickName) {
		User user = new User();
		listOfUsers.getListOfUsers();
		for (User user1 : listOfUsers.getListOfUsers()) {
			if (user1.getUserName().equals(nickName)) {
				System.out.println("Trying");
				user = user1;
			}
		}
		return user;
	}
	
	public static void UserActivity() {
		System.out.println("1 - Show all series");
		System.out.println("2 - Show series I saw");
		System.out.println("3 - Show My profile");
		System.out.println("4 - Select series to watch");
		System.out.println("5 - Log off");
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		try {
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				ShowAllSeries();
				break;

			case 2:
				ShowSeriesISaw();
				break;

			case 3:
				ShowMyProfile();
				break;

			case 4:
				SelectSeriesToWatch();
				break;

			case 5:
				System.out.println("Test showing all episodes");
				ShowSeriesISaw();
				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println("Wrong choice. Try again!");
			UserActivity();
		}

	}
	public static void ShowAllSeries() {
		for (Series series2 : listOfSerials.getListOfSerials()) {
			System.out.println("Name of Serial: " + series2.getName());
		}
	}
	
	public static void ShowAllSeriesAndEpisodes() {//not final
		for (Series series2 : listOfSerials.getListOfSerials()) {
			System.out.println("" + series2.getName());
			for (Episode episode2 : series2.getListOfEpisodes()) {
				episode2.getEpisodeToString();
			}
		}
	}
	
	public static void ShowSeriesISaw() {
		if (currentUser.getStartedSeries()[0] != null) {
			System.out.println("Entering here");
			for (Series series2 : currentUser.getStartedSeries()) {
				System.out.println("Name" + series2.getName());
				for (Episode episode2 : series2.getListOfWatchedEpisodes()) {
					System.out.println("" + episode2.getName());

				}
			}
		}
		else {
			System.out.println("No series you watched!");
			UserActivity();
		}
		
	}
	
	public static void ShowMyProfile() {//not final
		currentUser.ProfileToString();
		UserActivity();
	}
	
	public static void SelectSeriesToWatch() {//not final
		Scanner scanner = new Scanner(System.in);
		String seriesNameString = scanner.nextLine();
		String episodeNameString;
		
		for (Series series2 : listOfSerials.getListOfSerials()) {//not final
			System.out.println(series2.getName());

			if (series2.getName().equals(seriesNameString)) {//not final
				System.out.println("Created serial");
				currentSeries = new Series(series2);
			}
		}
		try {
			System.out.println("Write the Name of Serial");
			if (currentUser.isSerialStartedWatching(currentSeries.getName())) {
				currentSeries = currentUser.getStartedSeriesByName(currentSeries.getName());
				System.out.println("The serial exsist in Watched List");
				System.out.println("Last episode you watched is: " + currentSeries.getLastWatchedEpisode().getName());

			}
			
			Episode tempEpisode;
			currentSeries.getSerialToString();
			System.out.println("Wich Episode you want to watch?");
			episodeNameString= scanner.nextLine();

			for (Episode episode2 : currentSeries.getListOfEpisodes()) {//not final
				if (episode2.getName().equals(episodeNameString)) {//not final

					tempEpisode = new Episode(episode2);
					currentUser.addWatchedEpisode(tempEpisode);
					currentUser.setWatchedEpisodesCount(currentUser.getWatchedEpisodesCount() + 1);
					System.out.println("Added episode to List");

					if (currentUser.isSerialStartedWatching(currentSeries.getName())) {
						currentSeries.setLastWatchedEpisode(tempEpisode);
					}

					else {
						Series s1 = new Series(currentSeries);

						s1.addWatchedEpisode(tempEpisode);
						s1.setLastWatchedEpisode(tempEpisode);
						currentUser.addStartedSerial(s1);
						currentUser.setStartedSeriesCount(currentUser.getStartedSeriesCount() + 1);
						s1.isWatchedAllSeries();
						if (s1.isFullWatched()) {
							currentUser.removeStartedSerial(s1);
							currentUser.addFinishedSerial(s1);
						}
					}

				}
			}

			try {
				System.out.println("Added episode to List");
				System.out.println("You choose Episode: " + currentSeries.getLastWatchedEpisode().getName());
				System.out.println("Start watching!");
				UserActivity();


			} catch (NullPointerException e) {
				System.out.println("Wrong choice. Episode with this name doesnt exsist.");
				UserActivity();
			}

		} catch (NullPointerException e) {
			System.out.println("Wrong choice. Serial with this name doesnt exsist.");
			UserActivity();

		}

	}
	
	
	
	public static void WatchSerial() {
		System.out.println("Name of Serial: " + currentSeries.getName());
		int eNumber = 1;
		System.out.println("Episodes: ");

		for (Episode episode1 : currentSeries.getListOfEpisodes()) {
			System.out.println(eNumber + episode1.getName());
			System.out.println(episode1.getInfo());
			System.out.println("Date Of release: " + episode1.getReleaseDate());
			eNumber++;
		}
		if (currentSeries.getLastWatchedEpisode() != null) {
			System.out.println("You saw this Serial. Last Episode watched is:  " + currentSeries.getLastWatchedEpisode().getName());
		}
		System.out.println("Wich episode you want to watch?");
	}
	
	
	
	public static void LogOff () {
		currentSeries = null;
		currentUser = null;
		MainMenu();	
		}


}
