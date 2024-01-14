import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class testrun {

    public static void main(String[] args) throws IOException {
        String username = "schedTeam1";
        String password = "Password1";

        SchedulingTeam user = new SchedulingTeam(username, password);

        String name = "Extra advanced java";
        String location = "London England";
        String numberofweeks = "5";
        String consultantrole = "Graduates";
        String date = "01/01/1980";

        System.out.println(user.viewModulesByCourseID("2").get(0));
        //user.viewModulesByCourseID("1");

        String input = "33/12/2005";

        boolean isValid = input.matches("^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$");
        System.out.println(isValid);

    }
}