import java.util.ArrayList;
import java.util.Date;
public class Trainer extends CourseMember {

	public Trainer(String username, String password) {
		super(username, password);
		profile = new TrainerProfileHandler(username);
	}

	public Profile getProfile(){
		return this.profile;
	}

	public void viewConsultantProfiles() {
		// TODO - implement Trainer.viewConsultantProfiles
		throw new UnsupportedOperationException();
	}

	public void contactCourseSchedulingTeam() {
		// TODO - implement Trainer.contactCourseSchedulingTeam
		throw new UnsupportedOperationException();
	}

	public Boolean addSkill() {
		// TODO - implement Trainer.addSkill
		throw new UnsupportedOperationException();
	
	}

	public Boolean addQualification() {
		// TODO - implement Trainer.addQualification
		throw new UnsupportedOperationException();
	}



}