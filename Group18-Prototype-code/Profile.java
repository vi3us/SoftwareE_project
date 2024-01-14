import java.time.LocalDate;
import java.util.Date;
public interface Profile {
	

	

	/**
	 * 
	 * @param username
	 */

	void viewProfile(String username);

	String getName();

	/**
	 * 
	 * @param name
	 */
	void setName(String name);

	LocalDate getDateOfBirth();

	/**
	 * 
	 * @param dateOfBirth
	 */
	void setDateOfBirth(LocalDate dateOfBirth);

	String getCountry();

	/**
	 * 
	 * @param country
	 */
	void setCountry(String country);

	String getCity();

	/**
	 * 
	 * @param city
	 */
	void setCity(String city);

	

}