
public class Employee implements java.io.Serializable{
	//serialVersionUID is getting calculated automatically
	//If the class has been changed with serialVersionUID automatically,
	//Reading the same object with some difference from other file will make an exception
	
	//private static final long serialVersionUID = 1123261121L;
	
	public String name;
	public String address;
	public int SSN;
	public int number;
	//public int a;
	public void mailCheck()
	{
	  System.out.println("Mailing a check to " + name
	                           + ", with address: " + address);
	}
}
