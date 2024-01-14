import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import javax.management.remote.TargetedNotification;

/*
role type:
	0 admin
	1 scheduling team
	2 trainers
	3 consultants
*/

public class SchedulingTeam extends User {

	private static TestData td = TestData.getInstance();
	
	public SchedulingTeam(String username, String password) {
		super(username,password);
	}

	public static ArrayList<String> returnSingleProfile(String id) {

		ArrayList<String[]> users = td.getUsers();		//table that has all users.csv data
		ArrayList<String[]> consultant = td.getConsultant();	//table that has all consultant.csv data
		ArrayList<String[]> trainer = td.getTrainer();	//table that has all trainer.csv data

		ArrayList<String> userProfile = new ArrayList<String>();	//data of user being looked into
			
		String[] userRow = td.getRowByID(id, users);

		//adds [UserID, FirstName, Surname, DateOfBirth, City, Country]
		for (int j = 0; j < 6; j++){
			userProfile.add(userRow[j]);
		}			
	
		//if user is a trainer
		if(Integer.valueOf(userRow[6]) == 2){
			String[] trainerData = td.getRowByID(id, trainer);
			userProfile.add(separateWithComma(trainerData[1]));//skills
			userProfile.add(separateWithComma(trainerData[2]));//qualifications

		//if user is a consultant
		}else if (Integer.valueOf(userRow[6]) == 3){
			String[] consultantData = td.getRowByID(id, consultant);
			userProfile.add(separateWithComma(consultantData[1]));//grades
			userProfile.add(separateWithComma(consultantData[2]));//consultant type
			
		}

		userProfile.add(userRow[6]);//adds roleID to the end of list
		return userProfile;
	}

	public static String separateWithComma(String a){
		String[] b = a.split("!");
		String stringArray = Arrays.toString(b);
		return stringArray.substring(1, stringArray.length()-1);
	}

	public static ArrayList<String> returnFullNames(){
		ArrayList<String> nameList = new ArrayList<String>();	//array that stores all users profiles

		ArrayList<String[]> users = td.getUsers();		//table that has all users.csv data

		//traverses on the users.csv file 
		for (int i=0;i<users.size();i++){
			String[] current = users.get(i);
			String name = current[1] +  " " + current[2];
			String id = current[0];
			
			//if user is a trainer
			if(Integer.valueOf(current[6]) == 2){
				nameList.add(id + ": " + name + " - Expert Trainer");
			//if user is a consultant
			}else if (Integer.valueOf(current[6]) == 3){
				nameList.add(id + ": " + name + " - Consultant");
			}
			
		}

		return nameList;
	}

	public void createCourse(String name, String location, String numberofweeks, String consultantrole, String date) throws IOException {
		ArrayList<String[]> currentcourses = td.getCourse();
		String id = String.format("%04d", currentcourses.size()+1);
		String content = "";
        File file = new File("Prototype-code/dataTables/course.csv");
		Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            content += line+"\n";
        }
        content += id+","+name+","+location+","+numberofweeks+","+consultantrole+","+date;
        FileWriter myWriter = new FileWriter("Prototype-code/dataTables/course.csv");
        myWriter.write(content);
        myWriter.close();
        scanner.close();
	}

	public ArrayList<String> viewAllCourses(){
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String[]> temp = td.getCourse();

		for (int i=0;i<temp.size();i++){
			String[] tempArr = new String[5];
			for (int j=1; j<6;j++){
				tempArr[j-1] = temp.get(i)[j];
			}
			output.add(String.join(", ", tempArr));
		}

		return output;
	}

	public ArrayList<String> viewModulesByCourseID(String id) {

		for(int i = id.length(); i <4; i++){
			id = "0"+id;
		}

		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String[]> temp = td.getModule();

		for (int i=0;i<temp.size();i++){
			if (String.valueOf(temp.get(i)[2]).equals(id)) {
				String[] tempArr = new String[6];
				for (int j=0; j<6;j++){
					tempArr[j] = temp.get(i)[j];
				}
				output.add(String.join(", ", tempArr));
			}
		}
		return output;
	}

	public void assignTrainer() {
		// TODO - implement SchedulingTeam.assignTrainer
		throw new UnsupportedOperationException();
	}

	public Trainer searchByName() {
		// TODO - implement SchedulingTeam.searchByName
		throw new UnsupportedOperationException();
	}

	public Trainer searchBySkill() {
		// TODO - implement SchedulingTeam.searchBySkill
		throw new UnsupportedOperationException();
	}

	public void editCourse() {
		// TODO - implement SchedulingTeam.editCourse
		throw new UnsupportedOperationException();
	}

	public void verifyTrainer() {
		// TODO - implement SchedulingTeam.verifyTrainer
		throw new UnsupportedOperationException();
	}

	public void verifyConsultant() {
		// TODO - implement SchedulingTeam.verifyConsultant
		throw new UnsupportedOperationException();
	}

	public void verifySkill() {
		// TODO - implement SchedulingTeam.verifySkill
		throw new UnsupportedOperationException();
	}

	public void verifyQualification() {
		// TODO - implement SchedulingTeam.verifyQualification
		throw new UnsupportedOperationException();
	}

	public void assignConsultant() {
		// TODO - implement SchedulingTeam.assignConsultant
		throw new UnsupportedOperationException();
	}

}