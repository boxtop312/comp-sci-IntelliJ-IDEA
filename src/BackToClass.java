public class BackToClass {
    public static void main(String[] args){
        BackToClassPerson bob = new BackToClassPerson("Coach Bob", 27, "M");
        System.out.println(bob);

        BackToClassStudent lynne = new BackToClassStudent("Lynne Brooke", 16, "F", "HS95129", 3.5);
        System.out.println(lynne);

        BackToClassTeacher mrJava = new BackToClassTeacher("Duke Java", 34, "M", "Computer Science", 50000);
        System.out.println(mrJava);

        BackToClassCollegeStudent ima = new BackToClassCollegeStudent("Ima Frosh", 18, "F", "UCB123", 4.0, "English", 1);
        System.out.println(ima);
    }
}
