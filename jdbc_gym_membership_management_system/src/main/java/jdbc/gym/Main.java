package jdbc.gym;

import java.util.Scanner;

public class Main {

public static void main(String[] args){

Scanner sc=new Scanner(System.in);

System.out.println("Enter name membershipType fee");

String name=sc.next();
String type=sc.next();
double fee=sc.nextDouble();

MemberDAO.addMember(name,type,fee);

}

}