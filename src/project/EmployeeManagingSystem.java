package project;


import java.util.*;

class Menu{
    public void showMainMenu(){
        System.out.println("+-----------------------------------------+");
        System.out.println("|         Employee Managing System        |");
        System.out.println("+-----------------------------------------+");
        System.out.println("|    (Please press your choice number)    |");
        System.out.println("+---+-------------------------------------+");
        System.out.println("| 1 | Show specific department.           |");
        System.out.println("+---+-------------------------------------+");
        System.out.println("| 2 | All staff sorted by performance.    |");
        System.out.println("+---+-------------------------------------+");
        System.out.println("| 3 | Query employee performance by name. |");
        System.out.println("+---+-------------------------------------+");
        System.out.println("| 4 | Quit system.                        |");
        System.out.println("+---+-------------------------------------+");
    }
    public void showDepartmentMenu(){
        System.out.println("+---------------------------------------------------+");
        System.out.println("|              Employee Managing System             |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("|         (Please press your choice number)         |");
        System.out.println("+---+-----------------------------------------------+");
        System.out.println("| 1 | Just show all the staff                       |");
        System.out.println("+---+-----------------------------------------------+");
        System.out.println("| 2 | Staff in the department sorted by performance |");
        System.out.println("+---+-----------------------------------------------+");
        System.out.println("| 3 | Query employee performance by name.           |");
        System.out.println("+---+-----------------------------------------------+");
        System.out.println("| 4 | Return to main menu                           |");
        System.out.println("+---+-----------------------------------------------+");
    }
}

public class EmployeeManagingSystem {
    public static void main(String[] args){
        //随机生成部门和员工
        ArrayList<Employee> employee = new ArrayList<>(100);
        ArrayList<Department> department = new ArrayList<>(5);

        Random ran1=new Random();
        int r1=ran1.nextInt(13)+10;
        int r2=ran1.nextInt(14)+10;
        int r3=ran1.nextInt(13)+10;
        int r4=ran1.nextInt(14)+10;
        int r5=100-r1-r2-r3-r4;

        Department d1= new Department("D1000","Personnel");
        Department d2= new Department("D1001","Sales");
        Department d3= new Department("D1002","Export");
        Department d4= new Department("D1003","Research");
        Department d5= new Department("D1004","Import");
        department.add(d1);
        department.add(d2);
        department.add(d3);
        department.add(d4);
        department.add(d5);

        String[] boyName={"Carl","Roman","Abner","Baron","Hardy","Matt","Gene","Ives",
                "Hale","Devin","Alex","Austin","Liam","Ethan","Ryan","Lucas","Justin",
                "Edward","Earl","Elon","Jared"};
        String[] girlName={"Fiona","Eva","Zoey","Alyssa","Jessica","Violet","Kate",
                "Natalie","Evelyn","Serenity","Daisy","Mia","Ava","Riley","Emma","Vivian",
                "Hailey","Alexa","Alice","Ruby"};
        String[] lastName={"Abby","Adams","Adolf","Camp","Cole","Dale","Dodge",
                "Ford","Gates","Green","Hamlet","Henley","Lane","Mac","Morgan","Norton",
                "Pike","Sidney","Taylor","York"};
        for(int i=0;i<100;i++){
            Employee e=new Employee();
            Random ran2=new Random();
            e.setID(String.format("%05d",ran2.nextInt(100000)));

            StringBuffer name=new StringBuffer();
            if(ran2.nextInt()>=0.5){
                e.setSex(Gender.male);
                name.append(boyName[ran2.nextInt(boyName.length)]);
            }
            else{
                e.setSex(Gender.female);
                name.append(girlName[ran2.nextInt(girlName.length)]);
            }
            name.append(" ");
            name.append(lastName[ran2.nextInt(lastName.length)]);
            e.setName(name.toString());

            Performance p=new Performance();
            p.setBasicSalary(ran2.nextInt(18501)+1500);
            p.setAllowance(ran2.nextInt(5000));
            p.setAward(ran2.nextInt(2000));
            e.setPerformance(p);

            //链接员工表与部门表
            Department dpm;
            if(i<r1)
                dpm=department.get(0);
            else if(i<r1+r2)
                dpm=department.get(1);
            else if(i<r1+r2+r3)
                dpm=department.get(2);
            else if(i<r1+r2+r3+r4)
                dpm=department.get(3);
            else
                dpm=department.get(4);


            if(dpm.getStaffNum()==0)
                dpm.setOfficer(e);
            e.setDepartment(dpm);
            dpm.addEmployee(e);


            employee.add(e);

        }

        Menu menu=new Menu();

        while(true){
            menu.showMainMenu();
            Scanner input1 = new Scanner(System.in);
            int choice1 = input1.nextInt();
            if(choice1==4)
                break;
            switch(choice1){
                case 1://Show specific department.
                {
                    System.out.println("0 for searching by name, 1 for searching by ID");
                    Scanner input2 =new Scanner(System.in);
                    int choice2=input2.nextInt();
                    boolean Found=false;
                    Department d=new Department();
                    if(choice2==0){//search by name
                        System.out.println("Please input the name:");
                        Scanner input3 =new Scanner(System.in);
                        String s3= input3.nextLine();
                        for(int i=0;i<5;i++) {
                            if (department.get(i).getName().equalsIgnoreCase(s3)) {
                                Found=true;
                                d=department.get(i);
                                break;
                            }
                        }
                        if(!Found){
                            System.out.println("NOT FOUND");
                            break;
                        }

                    }
                    else{//search by number
                        System.out.println("Please input the ID number:");
                        Scanner input3 =new Scanner(System.in);
                        String s3=input3.nextLine();
                        for(int i=0;i<5;i++) {
                            if (department.get(i).getID().equalsIgnoreCase(s3)) {
                                Found=true;
                                d=department.get(i);
                                break;
                            }
                        }
                        if(!Found) {
                            System.out.println("NOT FOUND");
                            break;
                        }
                    }
                    //Go to department menu
                    while (true) {
                        d.show();
                        menu.showDepartmentMenu();
                        Scanner input4 = new Scanner(System.in);
                        int choice4 = input4.nextInt();
                        if (choice4 == 4)
                            break;
                        switch (choice4) {
                            case 1: {
                                d.showStaff();
                                break;
                            }
                            case 2: {
                                d.sort();
                                d.showStaff();
                                break;
                            }
                            case 3: {
                                System.out.println("Please input the employee name:");
                                Scanner input5 = new Scanner(System.in);
                                String s2 = input5.nextLine();
                                d.getEmployeeByName(s2).show();
                                break;
                            }
                            default: {
                                System.out.println("Please input[1-3]");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2://All staff sorted by performance.
                {
                    Collections.sort(employee,new SortByPerformance());
                    for(Employee e:employee){
                        e.show();}
                    break;
                }
                case 3://Query employee performance by name.
                {
                    boolean Found=false;
                    System.out.println("Please input the department name:");
                    Scanner input2=new Scanner(System.in);
                    String s2=input2.nextLine();
                    for(Employee e:employee){
                        if(e.getName().toLowerCase().equals(s2.toLowerCase())){
                            Found=true;
                            e.show();
                            break;
                        }
                    }
                    if(!Found)
                        System.out.println("NOT FOUND");
                    break;
                }
                default:{
                    System.out.println("Please input[1-4]");
                    break;
                }
            }
        }
    }

}
