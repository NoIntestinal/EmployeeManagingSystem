package project;

public class Employee {
    private String ID;
    private String name;
    private Gender sex;
    private Performance performance;
    private Department department;

    Employee(){
        ID="NULL";
        name="NULL";
    }
    Employee(String _ID,String _name,Gender _sex,Performance p){
        ID=_ID;
        name=_name;
        sex=_sex;
        performance=p;
    }

    public String getID(){return ID;}

    public String getName(){return name;}

    public Gender getSex(){return sex;}

    public Performance getPerformance(){return performance;}

    public Department getDepartment(){return department;}

    public void setID(String _ID){ID=_ID;}

    public void setName(String _name){name=_name;}

    public void setSex(Gender _sex){sex=_sex;}

    public void setPerformance(Performance p){performance=p;}

    public void setDepartment(Department d){department=d;}

    public void show(){
        System.out.println();
        System.out.println("+----------------------------------+");
        System.out.println("|        Employee Information      |");
        System.out.println("+-------------+--------------------+");
        System.out.printf("|     ID      |%-20s|\n",this.ID);
        System.out.println("+-------------+--------------------+");
        System.out.printf("|    Name     |%-20s|\n",this.name);
        System.out.println("+-------------+--------------------+");
        System.out.printf("|    Gender   |%-20s|\n",sex.toString());
        System.out.println("+-------------+--------------------+");
        System.out.printf("|  Department |%-20s|\n",this.department.getName());
        System.out.println("+-------------+--------------------+");
        System.out.printf("|             |Basic Salary:%-7s|\n",String.valueOf(this.performance.getBasicSalary()));
        System.out.printf("| Performance |Allowance:%-10s|\n",String.valueOf(this.performance.getAllowance()));
        System.out.printf("|             |Award:%-14s|\n",String.valueOf(this.performance.getAward()));
        System.out.println("+-------------+--------------------+");
    }
}
