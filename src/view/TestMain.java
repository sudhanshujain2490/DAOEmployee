
package view;
import DAO.*;
import Model.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestMain 
{
    public static void main(String[] args) throws Exception
    {
        int ch;
        do 
        {            
            System.out.println("----------------------");
            System.out.println("Employee Application");
            System.out.println("----------------------");
            System.out.println("1. Insert Data \n 2 Search Data \n 3 Delete Data \n 4 Search All Data\n 5 Exit"); 
            System.out.println("------------------------");
            System.out.println("Enter Your Choice");
            Scanner scan=new Scanner(System.in);
            ch=scan.nextInt();
            switch(ch)
            {
                case 1: insert();break;
                case 2: search();break;
                case 3: deleteId();break;
                case 4: searchAll();break;
                case 5: System.exit(0);break;
                    default: System.out.println("Invalid choice.....");
            }
        } 
        while (ch!=5);
    }        
        public static void searchAll() throws SQLException
        {    
             EmployeeDAO E=new EmployeeDAO();
              List<Employee>mylist1;
              mylist1 = E.SearchAll();
              for(Employee E1:mylist1)
              {
                System.out.print(E1.getEno() + " ");
                System.out.print(E1.getEname() + " ");
                System.out.print(E1.getPhno() + " ");
                System.out.println(E1.getDepartment() + " ");
              }     
        }
        
        public  static void insert() throws Exception
        {
            //Insert Code
           
            int eno, phno;
            String ename, gen, dept;
            
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Enter Employee Id");
            eno =scan.nextInt();
            System.out.println("Enter Employee Name");
            ename=scan.next();
            System.out.println("Enter Employee Phno");
            phno=scan.nextInt();
//            System.out.println("Enter Employee gen");
//            gen = scan.next().charAt(0);
            System.out.println("Enter Employee Departement");
            dept = scan.next();
        
        
        Employee E = new Employee();
        E.setEno(eno);
        E.setEname(ename);
        E.setPhno(phno);
//        E.setGen(gen);
        E.setDepartment(dept);
        
        EmployeeDAO pd= new EmployeeDAO();
        
        if(pd.inseartEmployee(E))
            System.out.println("Record Inserted..........."); 
        else
            System.out.println("Record Not Inserted...........");
      }
                
      public static void deleteId() throws Exception
      {
          int id;
          Scanner scan = new Scanner(System.in);
          System.out.println("Enter Employee No. to Delete");
          id = scan.nextInt();
          EmployeeDAO E = new EmployeeDAO();
          if (E.deleteById(id)) {
              System.out.println("Record Deleted.......");
          }
          else
              System.out.println("Record not Found.....");
      }
      
      public static void search() throws SQLException
      {
          int id;
          Scanner scan = new Scanner(System.in);
          System.out.println("Enter Employee No.");
          id = scan.nextInt();
          EmployeeDAO e = new EmployeeDAO();
          Employee e1;
          e1 = e.SearchById(id);
          if (e1==null) {
              System.out.println("Record Not Found....");
          } 
          else {
              System.out.print(e1.getEno() + " | ");
              System.out.print(e1.getEname() + " | ");
              System.out.print(e1.getPhno() + " | ");
              System.out.println(e1.getDepartment() + " | ");
          }
      }
  
    
}
