import java.util.ArrayList;

public class CourseMember extends User {

	Profile profile;
	TestData db = TestData.getInstance();

	public CourseMember(String username, String password){
		super(username, password);			
	}
	
	public ArrayList<String> viewPersonalSchedule() {
		ArrayList<String[]> modules = db.getModule();
		ArrayList<String> schedule = db.getAllRowsFromModuleByTrainerID(this.getId(), modules);
		return schedule;
	}

	public void SendActivityNotification() {
		// TODO - implement CourseMember.SendActivityNotification
		throw new UnsupportedOperationException();
	}

	public Profile getProfile() {
		return this.profile;
	}

}