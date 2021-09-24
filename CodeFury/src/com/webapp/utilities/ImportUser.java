package com.webapp.utilities;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.webapp.models.User;
import com.webapp.services.UserService;
import com.webapp.services.impl.UserServiceImpl;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.regex.*;

public class ImportUser {
	
	public static String validateName(String name) {
		String regex = "[A-Za-z ]{5,29}";
		Pattern p = Pattern.compile(regex);
		if (name == null) {
			return "";
		}
		Matcher m = p.matcher(name);
		if(m.matches()) {
			return name;
		}
		else {
			return "";
		}
	}
	
	public static String validateEmail(String email) {
		String regex="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		Pattern p = Pattern.compile(regex);
		if (email == null) {
			return "";
		}
		Matcher m = p.matcher(email);
		if(m.matches()) {
			return email;
		}
		else {
			System.out.println("Wrong email address Provided");
			return "";
		}
	}
	
	public static String validatePhone(String phone) {
		String regex = "^[1-9]{1}[0-9]{10}";
		Pattern p = Pattern.compile(regex);
		if (phone == null) {
			return "";
		}
		Matcher m = p.matcher(phone);
		if(m.matches()) {
			return phone;
		}
		else {
			System.out.println("Wrong Phone number Provided");
			return "";
		}
	}
	
	public static String validateRole(String role) {
		if (role.equalsIgnoreCase("Manager")) {
			return "Manager";
		}
		else if(role.equalsIgnoreCase("Admin")) {
			return "Admin";
		}
		else if (role.equalsIgnoreCase("Admin")) {
			return "Admin";
		}
		else {
			System.out.println("Wrong Role Provided");
			return "";
		}
	}
	
	public static String printUser(String name,String email,String phone,String role) {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone + ", role=" + role + "]";
	}

   public static void main(String[] args) {

      try {
    	 UserService service=new UserServiceImpl();
         File inputFile = new File("C:\\Users\\smrit\\Desktop\\HSBC_Training\\CodeFury\\CodeFury\\src\\com\\webapp\\files\\input.txt");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("user");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               String name= eElement
                       .getElementsByTagName("name")
                       .item(0)
                       .getTextContent();
               String email=  eElement
                       .getElementsByTagName("email")
                       .item(0)
                       .getTextContent();
               String phone= eElement
                       .getElementsByTagName("phone")
                       .item(0)
                       .getTextContent();
               String role= eElement
                       .getElementsByTagName("role")
                       .item(0)
                       .getTextContent();
               System.out.println("Name : " +name); 
               System.out.println("Email : "  + email);
               System.out.println("Phone : "  + phone);
               System.out.println("Role : "  + role);
               
               User user=new User();
               user.setName(validateName(name));
               user.setEmail(validateEmail(email));
               user.setPhone(validatePhone(phone));
               user.setRole(validateRole(role));
               
               if (user.getName()=="" || user.getPhone()=="" || user.getRole()=="" || user.getEmail()=="") {
            	   System.out.println("The data of the user doesnot match the specification..");
            	   System.out.println("Skiping the user: "+ printUser(name,email,phone,role));
               }
               else {
            	   service.createUserDAO(user);
            	   System.out.println("User created for user details: "+user.toString());
               }
               
               
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
