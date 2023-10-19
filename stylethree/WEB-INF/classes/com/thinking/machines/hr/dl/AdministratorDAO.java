package com.thinking.machines.hr.dl;
import java.sql.*;
import com.thinking.machines.hr.dl.*;

public class AdministratorDAO
{
public AdministratorDTO getByUsername(String username) throws DAOException{
if(username==null) throw new DAOException("Username cannot be empty");

String uname="";
String password="";
Connection connection=null;
PreparedStatement preparedStatement=null;

try{
connection=DAOConnection.getConnection();
preparedStatement=connection.prepareStatement("select * from administrator where uname=?");
preparedStatement.setString(1,username);

ResultSet resultSet=preparedStatement.executeQuery();

resultSet.next();
if(resultSet==null){
preparedStatement.close();
connection.close();
throw new DAOException("Invalid username");
}

uname=resultSet.getString(1);
password=resultSet.getString(2);
preparedStatement.close();
connection.close();

}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}

AdministratorDTO admin=new AdministratorDTO(uname,password);
return admin;
}
}