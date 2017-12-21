import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;
 
public class Main
{
	int size = 0;
	Applicant top = null;
	@SuppressWarnings("rawtypes")
	Vector vec = new Vector();
	Immigration im = new Immigration();
	private static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {//main function, where the program starts
       
    	new Main();
        //display main page and get user selection
    }
 
    public Main(){
    	load();
    	Menu();
    }
    public void Menu() {
        //Takes user input for the main page.
        System.out.println("Immigration Department\n"  // Welcome message
                 + "\n1: To add a new applicant press 1"
                 + "\n2: To check the current list of applicants press 2"
                 + "\n3: To search for a particular applicant press 3"
                 + "\n4: To exit press 4"
                 + "\n6: To print the top linked list entry press 5");
         
        System.out.println("Please enter your selection.");
       
        //takes an user input and save it to memory
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        //have user input string null at the start
        String mainPageOptions = null;
        try { //try do something
 
        	//passes in the string and saves it as a variable
            mainPageOptions = br.readLine();
         
        }catch(IOException e){System.out.println(e); } // catch any error
        // options menu
        String input = mainPageOptions;
        int test = Integer.parseInt(input);
       
        //invoke the relevant method depending on what option is selected
        if(test == 1 ){
            newEntry();  
        }
        else if(test == 2){
            printLinkedList();
        }
        else if(test == 3){
            findEntry();
        }
        else if(test == 4) {
        	quit();
        }
        else if(test == 5){
        	showLinkedList(top);
        }
        //if the user inputs the wrong option
        else if(test != 1|test != 2|test != 3|test != 4|test != 5){//catch an error
            System.out.println("Invalid input");
            quit();
        }
    }
    
    String readFile(String data) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
 
    public void showLinkedList(Applicant current){
    	
    	//get the name of the applicant that is top in the linked list
        System.out.println(current.getFirstName());
        System.out.println(current.getLastName());
         
        if(current.getBehind() != null){
        	showLinkedList(current.getBehind());
        }
    }
    public void newEntry() {
    	// informs the user that this is our new entry menu
        System.out.println("New entry - Please enter the applicant's details");        
       
        System.out.println ("Enter first name:");
        
        BufferedReader bre = new BufferedReader(new InputStreamReader(System.in));
        //buffer reader for user input
        String firstnameinput = null;
        try { // try do something
 
        	firstnameinput = bre.readLine();
         
        }catch(IOException e){System.out.println(e); } // catch any error
     
        String input = firstnameinput;//
        
        System.out.println ("Enter last name:");
        
        //buffer reader for user input
        String lastnameinput = null;
        try { // try do something
 
        	lastnameinput = bre.readLine();
         
        }catch(IOException e){System.out.println(e); } // catch any error
     
        String input2 = lastnameinput;
        
        System.out.println ("Enter date of arrival:");
        
        //buffer reader for user input
        String dateinput = null;
        try { // try do something
 
        	dateinput = bre.readLine();
         
        }catch(IOException e){System.out.println(e); } // catch any error
     
        String input3 = dateinput;//
        
        System.out.println ("Enter passport number:");
               
        //buffer reader for user input
        String passportinput = null;
        try { // try do something
 
        	passportinput = bre.readLine();
         
        }catch(IOException e){System.out.println(e); } // catch any error
     
        String input4 = passportinput;//
        
        System.out.println("Enter ID for user reference");
        
        //buffer reader for user input
        String IDinput = null;
        try { // try do something
 
        	IDinput = bre.readLine();
         
        }catch(IOException e){System.out.println(e); } // catch any error
     
        String ID = IDinput;//
        int input5 = Integer.parseInt(ID);
        
        System.out.println("Do you have a child accompanying you? (Y/N)");
        
        //declare the string called option and have it null for now
      	String quitOption = null;
      	//start a try and catch to prevent any errors from crashing the program
              try
              { 
              	//the option string variable will be filled with the user input now
              	quitOption = bre.readLine();
              }
        //this is to catch any errors and prevent the program from crashing
        catch(IOException e){System.out.println(e);}
        //if the user picks the "Yes" option
        if(quitOption.equals("Y") || (quitOption.equals("y")))
        {
          		//the child's age will be used to define the priority of the queue
          		System.out.println("How old is this child?");
          		
          		//buffer reader for user age
                String ageOfChild = null;
                try { // try do something
         
                	ageOfChild = bre.readLine();
                 
                }catch(IOException e){System.out.println(e); } // catch any error
               
                String priority = ageOfChild;
                //parse age from the string as an integer
                int input6 = Integer.parseInt(priority);
                
                //print out the details you have entered
                System.out.println(input + System.lineSeparator());
                System.out.println(input2 + System.lineSeparator());
                System.out.println(input3 + System.lineSeparator());
                System.out.println(input4 + System.lineSeparator());
                System.out.println(input5 + System.lineSeparator());
                System.out.println(input6 + System.lineSeparator());                
                
                Applicant temp = new Applicant(firstnameinput, lastnameinput, dateinput, passportinput, Integer.valueOf(ID), Integer.valueOf(priority));
                                          
                if(this.top == null){
                	top = temp;
                } else {
                	
                	Applicant currentTop = top;
                	
                	top = temp;
                	
                	temp.setBehind(currentTop);
                }
                //method to write this to the text file
                writeToPreviousOrders(temp);
        }
        //if the user picks the "No" option
        else if(quitOption.equals("N") || (quitOption.equals("n")))
        {
            Applicant temp = new Applicant(firstnameinput, lastnameinput, dateinput, passportinput, Integer.valueOf(ID), Integer.valueOf(100));
            
            if(this.top == null){
            	top = temp;
            } else {
            	
            	Applicant currentTop = top;            	
            	top = temp;            	
            	temp.setBehind(currentTop);
            }
            //method to write this to the text file
            writeToPreviousOrders(temp);        
        }
        //if the user picks an option other than Yes or No, the prompt will tell the user to input a valid option
        else {
          		//prompt the user to input a valid option
          		System.out.println("Incorrect input. Now terminating.");
          		//revert back to the start of the quit method so the program won't hang and can still receive user input
          		quit();
        }
        Menu();
    }
    
    public void printLinkedList () {
    	System.out.println(im);
    	Menu();
    }
   
    @SuppressWarnings("resource")
	public void listOfApplicants() {
		//start the try and catch to prevent crashing
    	try
    	{
    		//initialize a buffered reader to receive text from a text file with the list of previous bookings
			BufferedReader br3 = new BufferedReader(new FileReader("data.txt"));
			//initialize a string to receive the buffered reader content
			String line = br3.readLine();
			//the line starts out as null. While this is true, start this bit of code in the brackets
			while(line != null) 
			{
				//print out the list of films in the console window
			   System.out.println(line);
			   line = br3.readLine();
			}
			
			//Takes user input for the main page.
	        System.out.println("Applicant List\n"
	                 + "\n1: To delete an applicant press 1"
	                 + "\n2: To modify an applicant press 2"
	                 + "\n3: To go back to the main menu press 3");
	       
	        System.out.println("Please enter your selection ");
	       
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//takes an user input and save it to memory
	       
	        String mainPageOptions = null;
	        try {
	            mainPageOptions = br.readLine();//passes in the string and saves it as a variable
	         
	        }catch(IOException e){System.out.println(e); } // catch any error
	        
	        // options menu
	        String input = mainPageOptions;
	        int test = Integer.parseInt(input);
	       
	        if(test == 1 ){
	        	//INSERT THE DELETE ENTRY METHOD
	            newEntry();  
	        }
	        else if(test == 2){
	        	//INSERT THE MODIFY ENTRY METHOD
	            listOfApplicants();
	        }
	        else if(test == 3){
	        	Menu();
	        }
	        else if(test != 1|test != 2|test != 3){//catch an error
	            System.out.println("Invalid input");
	            quit();
	        }
	        return;
		}
    	//the catch prevents crashing
    	catch(IOException e){System.out.println(e);}
	}
   
   //function that gets all users input and saves it into a file
   public static void writeToPreviousOrders(Applicant temp) {
	   		//start the try and catch to prevent crashing
	 		try {
	 		//use File to locate the Bookings text file
	 		File bookings = new File("data.txt");
	 		//use PrintWriter in this manner, so every time you make an order it does not overwrite the previous one
	 		PrintWriter bookingConfirm = new PrintWriter(new FileWriter(bookings, true));
	 		//port the string to the Bookings file
	 		bookingConfirm.println(temp.getFirstName());
	 		bookingConfirm.println(temp.getLastName());
	 		bookingConfirm.println(temp.getDate());
	 		bookingConfirm.println(temp.getPassport());
	 		bookingConfirm.println(temp.getID());
	 		bookingConfirm.println(temp.getPriority());
	 		
	 		//close the file writer
	 		bookingConfirm.close();
	 		}
	 		//the catch prevents crashing
	 		catch(IOException e) {System.out.println(e);}
   }
   
   public void findEntry() {
	   int id = getID();
       System.out.println("The person in question " + id + " is " + im.getPosition(id) + " ");
       Menu();
   }
   
   private static int getID() {
       System.out.print("Enter id: ");
       String id = sc.nextLine();
       while (!id.matches("\\d+")) {
           System.out.print("ID does not exist, please enter again: ");
           id = sc.nextLine();
       }
       return Integer.parseInt(id);
   }
   
   @SuppressWarnings({ "unchecked" })
   public void load() {
		//put the linked list text into memory form
	   try {
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		while(br.ready()) {
			
			String line1 = br.readLine();
			String line2 = br.readLine();
			String line3 = br.readLine();
			String line4 = br.readLine();
			String line5 = br.readLine();
			String line6 = br.readLine();
			
			int input5 = Integer.parseInt(line5);
			int input6 = Integer.parseInt(line6);			
			
			System.out.println("Adding.." +line1 + " "+line2 );
			Applicant temp = new Applicant(line1,line2,line3,line4,input5,input6);
			
			vec.add(temp);
			System.out.println(vec.size());
		}
		for(int i =0; i < vec.size(); i++) {
			Applicant t = (Applicant)vec.elementAt(i);
			
			if (size == 0) {
				this.top = t;
				System.out.println(t);
			} 
			else {
				addElementToQ(t);
				System.out.println(t);
			}
			size++;
		}

		}catch(Exception e) {System.out.println(e);}	   
	   }
   
   public void addElementToQ(Applicant newNode){
	   		//find the top!!! (or anchor)
			Applicant current = top;
			
	        //loop until we hit the end, then add.		
			while(current.behind != null) {
					
				current = current.behind;
			   // if there is no node behind us, 
			   // add the node to the end.
			   if(current.behind == null) {
					current.behind = newNode;
					newNode.infront = current;
					break;
				}
			}
				printAll();	
   }
   
   public void printAll() {
		
		// Step 1 - find the top!!! (or anchor)
		Applicant next = top;
		
		// loop over until their is no more
		while( next!= null) {
			System.out.println(next.id);
			// get the next node
			next = next.behind;
		}
	}
   public static int quit(){// quit function, asking the user if the person wants to quit or return to main page
       
       System.out.println("Do you want to quit the program? Y/N");// message to user
   
       BufferedReader brQuit = new BufferedReader(new InputStreamReader(System.in));
       String quit = null;
       try { //try do something
       
       quit = brQuit.readLine();
       System.out.println(quit + "\n");
       
       if (quit.contains("Y")){//Only accepts capital letters
            System.out.println("System is now shut down");
            System.exit(0);
       }
       else if(quit.contains("N")){//Only accepts capital letters
            //mainPage(); // Returns it to main menu
       }
       
       }catch(IOException e){System.out.println(e);} // catch any error
   
    return 0;     
   }
}