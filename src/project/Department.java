package project;

import java.util.ArrayList;
import java.util.Collections;


public class Department {
    private String ID;
    private String name;
    private int staffNum;
    private Employee officer;
    private ArrayList<Employee> arr;

    Department(){
        ID="NULL";
        name="NULL";
        staffNum=0;
        officer=new Employee();
        arr=new ArrayList<Employee>();
    }
    Department(String _ID,String _name){
        ID=_ID;
        name=_name;
        staffNum=0;
        officer=new Employee();
        arr= new ArrayList<>();
    }

    public String getID(){return ID;}

    public String getName(){return name;}

    public int getStaffNum(){return staffNum;}

    public Employee getOfficer(){return officer;}

    public void setID(String ID){this.ID = ID;}

    public void setName(String _name){this.name=_name;}

    public void setStaffNum(int n){this.staffNum=n;}

    public void setOfficer(Employee o){this.officer=o;}

    public void addEmployee(Employee e){
        arr.add(e);
        staffNum++;
    }

    public Employee getEmployeeByName(String s){
        for(Employee e:arr){
            if(e.getName().equalsIgnoreCase(s))
                return e;
        }
        return new Employee();
    }

    public void show(){
        System.out.println("+──────────────────+──────────────────+");
        System.out.printf("|    Department    |%-18s|\n",this.ID);
        System.out.println("+──────────────────+──────────────────+");
        System.out.printf("| Name             |%-18s|\n",this.name);
        System.out.println("+──────────────────+──────────────────+");
        System.out.printf("| Number of staff  |%-18s|\n",this.staffNum);
        System.out.println("+──────────────────+──────────────────+");
        System.out.printf("| Manager          |%-18s|\n",this.officer.getName());
        System.out.println("+──────────────────+──────────────────+");
    }

    public void showStaff(){
        for(Employee e:arr){
            e.show();
        }
    }

    public void sort(){
        Collections.sort(arr,new SortByPerformance());
    }
}
