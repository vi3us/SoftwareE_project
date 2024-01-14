import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter; 



public class TestData {
    //class uses csv files stored in ./dataTables and will store the data in an arraylist containing arrays of Strings, each table has getters and setters 

    public static TestData instance = null;
    //[UserID, Username, Password]
    private ArrayList<String[] > login = new ArrayList<String[]>();
    //[UserID, FirstName, Surname, DateOfBirth, City, Country, RoleID (0 - admin, 1 - scheduling team, 2- trainer, 3 - consultant)]
    private ArrayList<String[]  > users = new ArrayList<String[] >();
    //[UserID, Skills, Qualifications]
    private ArrayList<String[]  > trainer = new ArrayList<String[] >();
    //[UserID, Grades, Type, CourseID]
    private ArrayList<String[]  > consultant = new ArrayList<String[] >();
    //[CourseID, Name, Location, Length in Weeks, Consultant type (graduate, ex forces, returners to work), Start date]
    private ArrayList<String[]  > course = new ArrayList<String[] >();
    //[ModuleID, Name, CourseID, TrainerID (simply the userID of the trainer), Week, Date - will be replaced with dateTime]
    private ArrayList<String[]  > module = new ArrayList<String[] >();




    //private so only one instance can be made using getInstance()
    private TestData(){
        //initialise all tables with data
        fileToArrayList("login", login);
        fileToArrayList("users", users);
        fileToArrayList("trainer", trainer);
        fileToArrayList("consultant", consultant); 
        fileToArrayList("course", course);
        fileToArrayList("module", module);
        
        /*old functions
        
        //another test comment

        
        loginData();
        userData();
        trainerData();
        consultantData();
        courseData();
        moduleData();*/

    }


    // for singleton principle - checks if instance has been made before making one.
    public static TestData getInstance(){
        if(instance==null){
            instance = new TestData();
        }
        return instance;
    }





    public void fileToArrayList(String fileName, ArrayList<String[]> table){
        try (BufferedReader br = new BufferedReader(new FileReader("Prototype-code/dataTables/" +fileName + ".csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                table.add(values);
            }
            br.close();
        } catch(FileNotFoundException e){
            e.getCause();
            System.out.println("File not found");
        } catch(IOException e1){
            e1.getCause();
            System.out.println("IO error");
        }
        
    }

    //search by userName or by course name or module name, use to search tables: Login, Course and Module
    public String getID(String searchParameter, ArrayList<String[]> table){
        for (String[] x : table) {
            //System.out.println(Arrays.toString(x));
            //System.out.println(x[1]);
            if (searchParameter.equals(x[1]) ){
                return x[0];
            }
        }
        return ""; //returns empty if not found

    }


    public ArrayList<String> getAllRowsFromModuleByTrainerID(String trainerID, ArrayList<String[]> table){
        ArrayList<String> output = new ArrayList<String>();
        int count = 0;
        for (String[] x : table){
            if (trainerID.equals(x[3])){
                output.add(Arrays.toString(x));
                count++;
            }
        }
        return output;
    }

    // returns a row by using ID to search, ID must be a string of 4 characters (0001,0002,0012, etc)
    public String[] getRowByID(String id, ArrayList<String[]> table){
        String[] str = {};
        for (String[] x : table) {
            if (id.equals(x[0])){
                return x;
            }
        }
        return str;//returns empty array if not found
    }

    //overwrites whole file with new array - work in progress
    public void writeArrayListToFile(String fileName, ArrayList<String[]> table){
        try (FileWriter fw = new FileWriter("Prototype-code/dataTables/" +fileName + ".csv")) {
            for (String[] x : table) {
                String line = Arrays.toString(x);
                fw.append(line.substring(1, line.length()-1) + "\n");
            }
            fw.close();
        } catch(FileNotFoundException e){
            e.getCause();
            System.out.println("File not found");
        } catch(IOException e1){
            e1.getCause();
            System.out.println("IO error");
        }

        

    }

    //public void writeRowToFile(String fileName, String[] row, int RowNumber){}

    //testing method
    public void testArrayList(ArrayList<String[]> table){
        for (String[] x : table) {
            System.out.println(Arrays.toString(x));
        }
    }

    public ArrayList<String[]> getLogin() {
        return login;
    }

    public ArrayList<String[]> getUsers() {
        return users;
    }

    public ArrayList<String[]> getTrainer() {
        return trainer;
    }

    public ArrayList<String[]> getConsultant() {
        return consultant;
    }

    public ArrayList<String[]> getCourse() {
        course = new ArrayList<String[]>();
        fileToArrayList("course", course);
        return course;
    }

    public ArrayList<String[]> getModule() {
        return module;
    }


    //Setters will overwite the whole file using writeArrayListToFile() - please make sure if you are setting then you must pass through the whole arraylist, not just a row
    public void setLogin(ArrayList<String[]> login) {
        this.login = login;
        writeArrayListToFile("login", login);
    }
    
    public void setUsers(ArrayList<String[]> users) {
        this.users = users;
        writeArrayListToFile("users", users);
    }

    public void setTrainer(ArrayList<String[]> trainer) {
        this.trainer = trainer;
        writeArrayListToFile("trainer", trainer);
    }

    public void setConsultant(ArrayList<String[]> consultant) {
        this.consultant = consultant;
        writeArrayListToFile("consultant", consultant);
    }

    public void setCourse(ArrayList<String[]> course) {
        this.course = course;
        writeArrayListToFile("course", course);
    }

    public void setModule(ArrayList<String[]> module) {
        this.module = module;
        writeArrayListToFile("module", module);
    }


    /*public void loginData(){
        //login data - UserID, Username, Password
        String a[][] = {{"0001", "admin", "password"},{"0002", "schedTeam1","Password1"}, {"0003","schedTeam2", "Password2"},{"00034","schedTeam3", "Password3"},{"0005","trainer1", "Password4"},{"0006","trainer2", "Password5"},{"0007","trainer3", "Password6"},{"0008","consultant1", "Password7"},{"0009","consultant2", "Password8"},{"0010","consultant3", "Password9"},{"0011","consultant4", "Password10"},{"0012","consultant5", "Password11"},{"0013","consultant6", "Password12"},{"0014","consultant7", "Password13"},{"0015","consultant8", "Password14"},{"0016","consultant9", "Password15"}};
        for (String[] x : a) {
            login.add(x);
        }
    }

    public void userData(){
        //user data - UserID, FirstName, Surname, DoB, City, Country, RoleID
        String a[][] = {{"0001", "admin", "admin","29/03/2022", "London", "England","0"},{"0002", "John", "Smith","29/03/1980", "London", "England","1"},{"0003", "Frederico", "Kirkland","21/03/1995", "Manchester", "England","1"},{"0004", "Gracie", "Cain","12/07/1975", "London", "England","1"},{"0005", "Brian", "Shaw",	"London", "England", "2"},{"0007", "Olivia", "Schmidt", "Frankfurt", "Germany", "2"},{},{},{},{},{},{},{},{},{},{},{},{},{}};
        for (String[] x : a) {
            users.add(x);
        }
    }

    public void trainerData(){
        //trainer data - UserID, Skills, Qualifications
        String a[][] = {{"0005","trainer1", "Qwertyuiop1"},{"0006","trainer2", "Qwertyuiop2"},{"0007","trainer3", "Qwertyuiop3"}};
        for (String[] x : a) {
            trainer.add(x);
        }
    }

    public void consultantData(){
        //consultant data - UserID, Grades, Type, CourseID
        String a[][] = {{"0008","90.1, 87.8, 95.0", "ReturnerToWork"},{"0009","70.1, 77.8, 75.0", "Ex-forces"},{"0010","52.1, 49.8, 65.0", "Graduate"}};
        for (String[] x : a) {
            consultant.add(x);
        }
    }

    public void courseData(){
        //course data - CourseID, Name, Location, LengthInWeeks, ConsultantType, StartDate
        String a[][] = {{"0001", "johnSmith", "password"},{"0002", "jeremyClarkson","password2"},
        {"0003","richardMay", "password3"}};
        for (String[] x : a) {
            course.add(x);
        }
    }

    public void moduleData(){
        //module data - Name, CourseID, Trainer, Week, Dates - we assume that each week only contains one module
        String a[][] = {{"0001", "johnSmith", "password"},{"0002", "jeremyClarkson","password2"},
        {"0003","richardMay", "password3"}};
        for (String[] x : a) {
            module.add(x);
        }
    }*/
    


}

    
