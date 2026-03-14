package jdbc.gym;

import java.sql.*;

public class MemberDAO {

public static void addMember(String name,String membershipType,double fee){

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement(
"INSERT INTO member(name,membershipType,fee) VALUES(?,?,?)",
Statement.RETURN_GENERATED_KEYS);

ps.setString(1,name);
ps.setString(2,membershipType);
ps.setDouble(3,fee);

ps.executeUpdate();

System.out.println("Member added successfully");

ResultSet rs=ps.getGeneratedKeys();

if(rs.next()){

int id=rs.getInt(1);

searchMember(id);

}

}catch(Exception e){
e.printStackTrace();
}

}

public static void searchMember(int id){

try{

Connection con=DBConnection.getConnection();

PreparedStatement ps =
con.prepareStatement("SELECT * FROM member WHERE id=?");

ps.setInt(1,id);

ResultSet rs=ps.executeQuery();

while(rs.next()){

System.out.println("ID: "+rs.getInt("id"));
System.out.println("Name: "+rs.getString("name"));
System.out.println("Membership Type: "+rs.getString("membershipType"));
System.out.println("Fee: "+(int)rs.getDouble("fee"));

}

}catch(Exception e){
e.printStackTrace();
}

}

}