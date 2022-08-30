public class Classroom_quiz {
    public static void main(String[]args){
        Student first = new Student("Tae Hee Lee", "71", "I'm 16", "I have 2 brothers", "I love whippleworld");
        Student second = new Student("Ryan Vauk", "71", "I play three instruments", "I toured around the country to see a band six times last summer.", "I have never left the country.");
//        Student third = new Student("David Yin", "510");
        System.out.println(first);
        System.out.println(second);
//        System.out.println(third);
    }
}

class Student{
    private String student_name;
    private String student_height;
    private String truth_1;
    private String truth_2;
    private String lie;
    public Student(String student_name, String student_height, String truth_1, String truth_2, String lie){
        student_name = "_____";
        student_height = "00";
        truth_1 = "_____";
        truth_2 = "_____";
        lie = "_____";
    }
    public void setStudent_name(String str){student_name = str;}
    public void setTruth_1(String str){truth_1 = str;}
    public void setTruth_2(String str){truth_2 = str;}
    public void setStudent_height(String str){student_height = str;}
    public void setLie(String str){lie = str;}
    public String getStudent_name(){return student_name;}
    public String getTruth_1(){return truth_1;}
    public String getTruth_2(){return truth_2;}
    public String getStudent_height(){return student_height;}
    public String getLie(){return lie;}
    public String toString(){return "\nStudent Name: "+this.getStudent_name()+"\nHeight(Inches): "+this.getStudent_height()+"\nTwo truths: 1) "+this.getTruth_1()+" 2) "+this.getTruth_2()+"\nLie: "+this.getLie();}
}
