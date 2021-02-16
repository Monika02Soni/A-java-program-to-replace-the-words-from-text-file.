package CSV_Read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ReadCSVExample {
	
	static boolean nameValidator(String value) {
		String regex = "^[a-zA-z]{1,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	static boolean dobValidator(String date){
		String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
 		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
        return  matcher.matches());
	}
	static boolean ageValidator(String value){
		String regex = "^\d+$";
		if(value< 70 || value>24){
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value);
        	return  matcher.matches());
		}
	}
	
	static boolean addressValidator1(String value){
		String regex =  "^[a-zA-Z0-9]+$";
 		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
        return  matcher.matches());
	}
	
	static boolean addressValidator2(String value){
		String regex =  "^[a-zA-Z0-9]+$";
 		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
        return  matcher.matches());
	}
	
	
	
	static boolean postalValidator(long num){
		String regex = "^\d{3}\s?\d{3}$";
 		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(num);
        return  matcher.matches());;
 		
	}
	
	

	
	static void insertEmployeeToDB(List<Employee> employeeList) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","123");
			Statement smt=cn.createStatement();
			for(Emeployee employee : employeeList){
				String firtName= employee.getFirstName();
				String lastName= employee.getLastName();
				String DOB = employee.getDob();
				int age = employee.getAge();
				String add1 = employee.getAdd1();
				String add2 = employee.getAdd2();
				String city = employee.getCity();
				String state = employee.getState();
				String country = employee.getCountry();
				String postal_code = employee.getPostalCode();
				String query="insert into employees values('"+firtName +"','"+lastName+"','"+DOB+"','"+age+"','"+add1+"','"+add2+"','"+city+"','"+state+"','"+country+"','"+postal_code+"')";
				smt.executeUpdate(query);
				System.out.println("Record Submitted....");
			}
			cn.close();
		}catch(Exception e){
			System.out.println(e);  
		}		
	}
	
		
	
	
	public static void main(String[] args) {
		String line = "";
		try {
			List<Employee> employeeList = new ArrayList<Employee>();
			BufferedReader bufferReader = new BufferedReader(new FileReader("C://data.csv"));
			while ((line = bufferReader.readLine()) != null) {
				String[] employee = line.split(",");
				Employee employeeVO = new Employee();
				if(nameValidator(employee[0])) {
					employeeVO.setFirstName(employee[0]);	
				}
				
				if(nameValidator(employee[1])) {
					employeeVO.setLastName(employee[1]);	
				}
				
				if(dobValidator(employee[2])){
					employeeVO.setDob(employee[2]);
				}
				if(ageValidator1(employee[3])){
					employeeVO.setAge(employee[3]);
				}
				
				if(addressValidator1(employee[4])){
					employeeVO.setAdd1(employee[4]);
				}
				
				if(addressValidator2(employee[5])){
					employeeVO.setAdd2(employee[5]);
				}
				
				if(postalValidator(employee[9])){
					employeeVO.setPostalCode(employee[9]);
				}
				employeeVO.setCity(employee[6]);
				employeeVO.setState(employee[7]);
				employeeVO.setCountry(employee[8]);
				employeeList.add(employeeVO);
			}
			employeeList.remove(0);
			employeeList.forEach(emp->{
				System.out.println(emp.getFirstName() + " " +  emp.getLastName() + " " +  emp.getDob() + " " +  emp.getAge() 
					+ " " +  emp.getAdd1() + " " +  emp.getAdd2() + " " +  emp.getCity() + " " +  emp.getState() +
						" " +  emp.getCountry() + " " +  emp.getPostalCode() );
			});
			insertEmployeeToDB(employeeList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
