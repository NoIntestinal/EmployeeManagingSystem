package project;

public class Performance {
    private int basicSalary;
    private int allowance;
    private int award;

    Performance(){
        basicSalary=0;
        allowance=0;
        award=0;
    }

    public int getBasicSalary(){return basicSalary;}

    public int getAllowance(){return allowance;}

    public int getAward(){return award;}

    public void setBasicSalary(int bs){basicSalary=bs;}

    public void setAllowance(int a){allowance = a;}

    public void setAward(int a){award = a;}

    public int total(){return (basicSalary+allowance+award);}

    public void show(){
        System.out.println("+-------------+--------------------+");
        System.out.printf("|             |Basic Salary:%-7s|\n",String.valueOf(this.getBasicSalary()));
        System.out.printf("| Performance |Allowance:%-10s|\n",String.valueOf(this.getAllowance()));
        System.out.printf("|             |Award:%-14s|\n",String.valueOf(this.getAward()));
        System.out.println("+-------------+--------------------+");
    }
}
