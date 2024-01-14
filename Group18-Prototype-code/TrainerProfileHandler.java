import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
public class TrainerProfileHandler implements TrainerProfile {

	private String userName;
	
	private String name;
	private LocalDate dateOfBirth;
	private String country;
	private String city;

	private ArrayList<String> skills;
	private ArrayList<String> qualifications;

	String id;
	/**
	 * 
	 * @param userName
	 */
	public TrainerProfileHandler(String userName) {
		this.userName=userName;
		this.id=this.findID(this.userName);
		this.name=this.findName(this.id);
		this.dateOfBirth=this.findDoB(this.id);
		this.country=this.findCountry(this.id);
		this.city=this.findCity(this.id);
		this.skills=findSkills(this.id);
		this.qualifications=this.findQualifications(this.id);

	}

	public String findID(String userName){
		TestData db = TestData.getInstance();
		ArrayList<String[]> userTable = db.getLogin();
		String id = db.getID(userName, userTable);
		//System.out.println(id);
		return id;
	}

	public String findName(String id){
		TestData db = TestData.getInstance();
		ArrayList<String[]> userTable = db.getUsers();
		String name=null;
		for (String [] x : userTable){
			if (x[0].equals(id)){
				name = x[1] + " " + x[2];
			}
		}

		return name;
	}

	//gets date of birth from database
	public LocalDate findDoB(String id){
		LocalDate bday = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		TestData db = TestData.getInstance();
		ArrayList<String[]> userTable = db.getUsers();

		for (String[] x : userTable){
			if (id.equals(x[0])){
				bday=LocalDate.parse(x[3], formatter);
			}
		}


		return bday;
	}

	public String findCountry(String id){
		TestData db = TestData.getInstance();
		ArrayList<String[]> userTable = db.getUsers();
		String country = null;
		for (String[] x : userTable){
			if (id.equals(x[0])){
				country = x[5];
			}
		}

		return country;
	}

	public String findCity(String id){
		TestData db = TestData.getInstance();
		ArrayList<String[]> userTable = db.getUsers();
		String city = null;
		for (String[] x : userTable){
			if (id.equals(x[0])){
				city = x[4];
			}
		}

		return city;
	}

	public ArrayList<String> findSkills(String id){
		TestData db = TestData.getInstance();
		ArrayList<String[]> trainerTable = db.getTrainer();
		ArrayList<String> skillsList = new ArrayList<String>();
		String skills = "";
		for (String [] x:trainerTable){
			if (x[0].equals(id)){
				skills = x[1];
			}
		}
		
		String[] skillArr = skills.split("!");

		for (String s : skillArr){
			skillsList.add(s);
		}

		return skillsList;
	}

	public ArrayList<String> findQualifications(String id){
		TestData db = TestData.getInstance();
		ArrayList<String[]> trainerTable = db.getTrainer();
		ArrayList<String> qualList = new ArrayList<String>();
		String quals = "";
		for (String [] x:trainerTable){
			if (x[0].equals(id)){
				quals = x[2];
			}
		}
		
		String[] skillArr = quals.split("!");

		for (String s : skillArr){
			qualList.add(s);
		}

		return qualList;
	}


	public void viewProfile(String username){
		System.out.println("Your username: " + this.userName);
		System.out.println("Your ID: " + this.id);
		System.out.println("Your name: " + this.name);
		System.out.println("Your date of birth: " + this.dateOfBirth);
		System.out.println("Your country: " + this.country);
		System.out.println("Your city: " + this.city);

		System.out.print("Your skill set: ");

		for (String s : this.skills){
			System.out.print(s + " ");
		}
		System.out.println();

		System.out.print("Your qualifications: ");
		for (String q : this.qualifications){
			System.out.print(q + " ");
		}
		System.out.println();

	}

	public String getName(){
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name=name;
	}

	public LocalDate getDateOfBirth(){
		return this.dateOfBirth;
	}
	

	/**
	 * 
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(LocalDate dateOfBirth){
		this.dateOfBirth=dateOfBirth;
	}

	public String getCountry(){
		return this.country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country){
		this.country=country;
	}

	public String getCity(){
		return this.city;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city){
		this.city=city;
	}

	public ArrayList<String> getSkills(){
		return this.skills;
	}

	public ArrayList<String> getQualifications(){
		return this.qualifications;
	}

}