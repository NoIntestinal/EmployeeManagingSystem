package project;

public enum Gender {
    female(0),male(1);

    private int value;

    private Gender(int i){
        this.value=i;
    }

    public String toString(){
        if(this.value==1)
            return "male";
        else
            return "female";
    }
}
