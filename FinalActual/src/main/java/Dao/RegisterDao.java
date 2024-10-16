package Dao;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.RegisterBean;
import sql.ConnectionProvider;

public class RegisterDao {

public String save(RegisterBean bean) {
	try {
		Connection con = ConnectionProvider.getConnection();
	int i = 0;
	PreparedStatement pst;
	try {
		pst = con.prepareStatement("insert into users values (?,?,?)");
		pst.setString(1, bean.getUsername());
		pst.setString(2, bean.getEmail());
		pst.setString(3,bean.getPassword());
		i = pst.executeUpdate();
		if(i>0)return "Success";
		else return "Failure";}
	catch(Exception e) {
		
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Failure";
}


public static String printBeanProperties(RegisterBean bean) {
	 String s = "";
    try {
        // Get the class of the bean
        Class<?> beanClass = bean.getClass();
       
        // Get all declared fields (properties) of the bean
        Field[] fields = beanClass.getDeclaredFields();

        // Iterate over the fields and print their names and values
        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields
            Object value = field.get(bean); // Get the field value
            s = s+(field.getName() + " = " + value); // Print field name and value
            return s;
        }
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    return s;
}

}


