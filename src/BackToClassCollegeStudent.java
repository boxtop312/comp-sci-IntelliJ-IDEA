public class BackToClassCollegeStudent extends BackToClassStudent{
    private String myMajor;
    private int myYear;
    public BackToClassCollegeStudent(String name, int age, String gender, String idNum, double gpa, String major, int year) {
        super(name, age, gender, idNum, gpa);
        myMajor = major;
        myYear = year;
    }

    public String getMyMajor() {return myMajor;}

    public int getMyYear(){return myYear;}

    public void setMyMajor(String newMajor){myMajor = newMajor;}

    public void setMyYear(int newYear){myYear = newYear;}

    public String toString(){return super.toString() + ", Major: " + myMajor + ", year: " + myYear;}
}
