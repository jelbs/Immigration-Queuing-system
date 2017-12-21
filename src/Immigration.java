public class Immigration {
	
    private LinkedList<Applicant> applicant;
    
    public Immigration() {
        applicant = new LinkedList<Applicant>();
    }
    
    public int getPosition(int ID) {
        return applicant.getIndex(new Applicant(null, null, null, null, ID, ID));
    }
    /*
    public void remove(int id) {
        applicant.removeByIndex(applicant.getIndex(new Applicant(id)));
    }
    public void removeLastNumbers(int num) {
        for (int i = 0; i < num; i++) {
            applicant.removeLast();
        }
    }
    */
    
    public void editById(String firstName, String lastName, String date, String passport, int ID, int priority) {
    	Applicant p = applicant.getByIndex(applicant.getIndex(new Applicant(firstName, lastName, date, passport, ID, priority)));
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDate(date);
        p.setPassport(passport);
        p.setID(ID);
        p.setPriority(priority);
    }
    
    public String toString() {
        return applicant.toString();
    }
}