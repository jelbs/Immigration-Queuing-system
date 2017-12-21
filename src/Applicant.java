public class Applicant {
	
	Applicant infront = null;
	Applicant behind = null;
	
	public Applicant getInfont() {
		return infront;
	}

	public void setInfont(Applicant infont) {
		this.infront = infont;
	}

	public Applicant getBehind() {
		return behind;
	}

	public void setBehind(Applicant behind) {
		this.behind = behind;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	private String firstName;
	private String lastName;
	private String date;
	private String passport;
	private int ID;
	private int priority;
	public int id;
	
	public Applicant (String firstName, String lastName, String date, String passport, int ID, int priority) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.passport = passport;
		this.ID = ID;
		this.priority = priority;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getPassport() {
		return passport;
	}
	
	public int getID () {
		return ID;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String toString() {
        return "{" + "id=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfArrival=" + date + ", PassportNumber=" + passport + '}';
    }
}