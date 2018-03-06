import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {

	final static String filename = "employee.txt";
	
	public static void main(String[] args) {
		
//		Employee e = new Employee();
//	      e.name = "Reyan Ali";
//	      e.address = "Phokka Kuan";
//	      e.SSN = 11122333;
//	      e.number = 101;
//	      e.mailCheck();
//	      
//	      WriteEmployeeObjectIntoFile(e,filename);
	      
	      Employee ee = GetEmployeeObjectFromFile(filename);
	      if(ee != null)
	    	  ee.mailCheck();
	}
	/**
	 * Writes an employee object into a file (Serializing)
	 * @param emp
	 * @param filename
	 */
	static void WriteEmployeeObjectIntoFile(Employee emp,String filename)
	{
		
	      try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream(filename);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         //Main write method
	         out.writeObject(emp);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in " + filename);
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	/**
	 * Gets an employee object from a file (Deserializing)
	 * @param filename
	 * @return
	 */
	static Employee GetEmployeeObjectFromFile(String filename)
	{
		Employee e = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream(filename);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         //Main read method
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	      }
		return e;
	}

}
