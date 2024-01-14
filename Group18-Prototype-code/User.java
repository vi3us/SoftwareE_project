import java.util.ArrayList;
public class User {

	private String id;
	private String username;
	private String password;
	private String role;

	private TestData database = TestData.getInstance();

	public User(String username, String password){
		setUserName(username);
		setPassword(password);
		id = database.getID(username, database.getLogin());
		
		try {
			role = database.getRowByID(id, database.getUsers())[6];
		} catch (Exception e) {
			role = "";
		}
	}

	public void viewCourse() {
		// TODO - implement User.viewCourse
		//overridden
		throw new UnsupportedOperationException();
	}

	public void updateAccountDetails(String typeOfData, String data) {
		// TODO - implement User.updateAccountDetails

		String[] userData = database.getRowByID(id, database.getUsers());
		
		ArrayList<String[]> userArray = database.getUsers();

		if (typeOfData.equals("FirstName")){
			userData[1] = data;
		}
		else if (typeOfData.equals("Surname")){
			userData[2] = data;
		}
		else if (typeOfData.equals("DateOfBirth")){
			userData[3] = data;
		}
		else if (typeOfData.equals("City")){
			userData[4] = data;
		}
		else if (typeOfData.equals("Country")){
			userData[5] = data;
		}
		
		int counter = 0;
		for (String[] userRow : userArray) {
            if (id.equals(userRow[0])){
                userArray.set(counter, userData);
            }
			counter++;
        }
		database.setUsers(userArray);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean login() {
		// TODO - implement User.logIn

		if (id.equals("")) {
			return false;
		}

		String[] userLoginData = database.getRowByID(id, database.getLogin());

		String Password = userLoginData[2];

		if (password.equals(Password)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void signOut() {
		// TODO - implement User.signOut
		username = "";
		password = "";
		System.out.println("User successfully signed out");
		//throw new UnsupportedOperationException();
	}

	public String getId() {
		return id;
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	// public void viewPersonalSchedule(){
	// 	// TODO - implement User.signOut
	// 	throw new UnsupportedOperationException();
	// }

	/**
	 * 
	 * @param username
	 */

	public void setId(String id) {
		this.id = id;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}