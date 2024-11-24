
package javaphase3;


import java.util.Scanner;  
import javax.swing.JOptionPane;


public class Course {  
private Student[] student; 
private String courseName;  
private String courseCode;  
private int courseCapasity;  
private int numOfStudents;  
private Teacher teacher; 

  

Scanner input=new Scanner(System.in);  
private String firstName;  
private String LastName;  
private String email;  


public Course (String courseName, String courseCode, int courseCapasity,String firstName, String lastNmae, String email, double salary) {  
this.courseCode=courseCode;  
this.courseName=courseName;  
this.courseCapasity=courseCapasity; 
this.student=new Student[courseCapasity]; 
this.teacher = new Teacher(firstName,  lastNmae,  email,  salary);   
this.numOfStudents=0; } 

  
 

public boolean CanSignIn() {  
// Check if the course is full  
if (numOfStudents >= courseCapasity) {  
JOptionPane.showMessageDialog(null,"Course is full. Cannot sign in ");  
   return false;  }
else  
return true;    }  

 
 

public void fillCourse() throws Exception {  
// fills an arrary of student at once  
 for (int i = 0; i < courseCapasity; i++) {
        // Get student input
        firstName = input.next();
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }

        LastName = input.next();
        if (LastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }

        email = input.next();
        if (email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }

        // Add the student to the array
        student[i] = new Student(firstName, LastName, email);
        numOfStudents++;
    } } 



 // Method to add a student to the course
    public void addStudent() {
        if (CanSignIn()) {
            if (numOfStudents >= courseCapasity) {
                // Unchecked ArrayIndexOutOfBoundsException if trying to add beyond the array size
                throw new ArrayIndexOutOfBoundsException("Cannot add more students. The course is full.");
            }

            // Adding a student to the course
            System.out.println("Enter student first name, last name, and email:");
            firstName = input.next();
            LastName = input.next();
            email = input.next();

            student[numOfStudents] = new Student(firstName, LastName, email);
            numOfStudents++;
        }
    }
 
 

boolean SearchForStudent() {  
//System.out.println("please enter the first name of the student you want to find"); 
String target=input.next(); 
for( int i = 0 ;i < numOfStudents ; i++ )  
if( student[i].firstName.equals(target) ) { 
JOptionPane.showMessageDialog(null,target +"is found"); 
return true; } 
JOptionPane.showMessageDialog(null,"not found"); 
return false;}  

 
 

public boolean deleteStudent() {	  
//System.out.println("please enter the first name of the student you want to delete"); 
String target=input.next(); 
for( int i = 0 ; i < numOfStudents ; i++ ) {  
if (student[i].getFirstName().equals(target)) {  
student[i] = student[ numOfStudents - 1] ;  
numOfStudents-- ;  
JOptionPane.showMessageDialog(null,"Student deleted successfully."); 
return true;  }  
} 
JOptionPane.showMessageDialog(null,"Student not found."); 

return false;} 

 

 

public String display() {  
// fills an arrary of student at once  
//System.out.println("Students enrolled in " + courseName + ":"); 
String display = "Students enrolled in " + courseName + ":";
for (int i = 0; i < numOfStudents; i++)  
display+=student[i].toString();
return display;
} 

 

 

public Teacher getTeacher() { 
return teacher; 

} 

 
 

} 