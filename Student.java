
package javaphase3;

import javaphase3.Member;
import java.io.*;

public class Student extends Member implements Serializable {


public Student(String firstName , String lastName, String email) {
super(firstName, lastName, email); }



public String toString() {
return "Student first Name= " + firstName + ", last Name= " + lastName + "\n"; }


}