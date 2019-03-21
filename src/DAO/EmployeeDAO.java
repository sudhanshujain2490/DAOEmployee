package DAO;
import Connection.MyConnection;
import Model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAO 
{
    private String sql;
    private ResultSet rs;
    
    public boolean inseartEmployee(Employee E) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        con = MyConnection.getConnection();
        
        String sql;
        sql = "insert into employee values(?,?,?,?)";
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, E.getEno());
        ps.setString(2, E.getEname());
        ps.setInt(3, E.getPhno());
//        ps.setByte(4, (byte) E.getGen());
        ps.setString(4, E.getDepartment());
        
        if(ps.executeUpdate()>0) 
            return true;
        else 
            return false;
                    
    }
    
    public Employee SearchById(int id) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = MyConnection.getConnection();
        String sql;      
           
        sql = "select * from employee where eno = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        Employee e = new Employee();
            if (rs.next()) 
            {                
                e.setEno(rs.getInt(1));
                e.setEname(rs.getString(2));
                e.setPhno(rs.getInt(3));
                e.setDepartment(rs.getString(4));
                                
            }
            else    
                e = null;
        
            return e;
    }
    
    public List<Employee> SearchAll() throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = MyConnection.getConnection();
        String sql;
        sql = "select * from employee";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        List<Employee>mylist = new ArrayList<Employee>();
        
        while (rs.next()) 
        {            
            Employee e = new Employee();
            e.setEno(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setPhno(rs.getInt(3));
            e.setDepartment(rs.getString(4));
            mylist.add(e);
            e=null;
        }
        return mylist;
    }
    
    public boolean deleteById(int id) throws SQLException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = MyConnection.getConnection();
        String sql;
        sql = "delete from employee where eno =?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        if (ps.executeUpdate()>0) 
        {
            return true;  
        } 
        return false;
    }      
}
