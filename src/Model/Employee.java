
package Model;

public class Employee 
{
    private int eno;
    private String ename;
    private int phno;
    //private char gen;
    private String department;

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }

//    public char getGen() {
//        return gen;
//    }
//
//    public void setGen(char gen) {
//        this.gen = gen;
//    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}
