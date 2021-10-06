package project;

import java.util.Comparator;

public class SortByPerformance implements Comparator {
    public int compare(Object o1,Object o2){
        Employee e1=(Employee) o1;
        Employee e2=(Employee) o2;
        if(e1.getPerformance().total()>e2.getPerformance().total())
            return -1;
        else
            return 1;
    }
}
