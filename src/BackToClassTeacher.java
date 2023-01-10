public class BackToClassTeacher extends BackToClassPerson{
    private String mySubject;
    private double mySallary;
    public BackToClassTeacher(String name, int age, String gender, String subject, double sallary) {
        super(name, age, gender);
        mySubject = subject;
        mySallary = sallary;
    }

    public String getMySubject() {return mySubject;}
    public double getMySallary(){return mySallary;}

    public void setMySubject(String newSubject){mySubject=newSubject;}

    public void setMySallary(double newSallary){mySallary=newSallary;}

    public String toString(){
        return super.toString() + ", Subject: " + mySubject + ", Salary: " + mySallary;
    }
}
