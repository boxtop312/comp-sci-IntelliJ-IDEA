import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class
public class Test_Questions{
    public static void main(String[] args){
        WriteTest w = new WriteTest();
        w.PrintTest();
    }
}

class WriteTest{
    ArrayList<Question> questionList = new ArrayList<Question>();
    void PrintTest(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Number of questions: ");
        int num = myObj.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Type: ");
            myObj = new Scanner(System.in);  // Create a Scanner object
            String type = myObj.nextLine();
            if(Objects.equals(type, "Essay")){
                System.out.println("Question: ");
                myObj = new Scanner(System.in);  // Create a Scanner object
                String q = myObj.nextLine();
                System.out.println("Number of lines: ");
                myObj = new Scanner(System.in);  // Create a Scanner object
                questionList.add(new Essay(q,myObj.nextInt()));
            } else if(Objects.equals(type, "MultipleChoice")) {
                System.out.println("Number of Answers: ");
                myObj = new Scanner(System.in);  // Create a Scanner object
                int answerNum = myObj.nextInt();
                System.out.println("Answer 1: ");
                myObj = new Scanner(System.in);  // Create a Scanner object
                String a1 = myObj.nextLine();
                if(answerNum == 1){
                    System.out.println("Question: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    questionList.add(new MultipleChoice(myObj.nextLine(), answerNum, a1));
                } else if (answerNum==2) {
                    System.out.println("Answer 2: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a2 = myObj.nextLine();
                    System.out.println("Question: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    questionList.add(new MultipleChoice(myObj.nextLine(), answerNum, a1, a2));
                } else if (answerNum == 3) {
                    System.out.println("Answer 2: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a2 = myObj.nextLine();
                    System.out.println("Answer 3: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a3 = myObj.nextLine();
                    System.out.println("Question: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    questionList.add(new MultipleChoice(myObj.nextLine(), answerNum, a1, a2, a3));
                } else if (answerNum == 4) {
                    System.out.println("Answer 2: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a2 = myObj.nextLine();
                    System.out.println("Answer 3: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a3 = myObj.nextLine();
                    System.out.println("Answer 4: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a4 = myObj.nextLine();
                    System.out.println("Question: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    questionList.add(new MultipleChoice(myObj.nextLine(), answerNum, a1, a2, a3, a4));
                } else if (answerNum == 5){
                    System.out.println("Answer 2: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a2 = myObj.nextLine();
                    System.out.println("Answer 3: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a3 = myObj.nextLine();
                    System.out.println("Answer 4: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a4 = myObj.nextLine();
                    System.out.println("Answer 5: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    String a5 = myObj.nextLine();
                    System.out.println("Question: ");
                    myObj = new Scanner(System.in);  // Create a Scanner object
                    questionList.add(new MultipleChoice(myObj.nextLine(), answerNum, a1, a2, a3, a4, a5));
                }
            }
        }
        int count = 0;
        System.out.println("");
        for (Question q: questionList) {
            count++;
            System.out.println("Question "+count+": ");
            q.readQuestion();
        }
    }




}

abstract class Question{
    protected String question;

    protected abstract void readQuestion();

}

class Essay extends Question{
    protected int lines;
    Essay(String q, int l){
        question = q;
        lines =l;
    }
    protected void readQuestion() {
        System.out.println(question+"\n");
        for (int i = 0; i < lines; i++) {
            System.out.println("__________________________________________________");
        }

    }
}

class MultipleChoice extends Question{
    String[] answers = new String[1];
    MultipleChoice(String q, int anum, String a1){
        question = q;
        answers = new String[anum];
        answers[0] = a1;
    }

    MultipleChoice(String q, int anum, String a1, String a2){
        question = q;
        answers = new String[anum];
        answers[0] = a1;
        answers[1] = a2;
    }
    MultipleChoice(String q, int anum, String a1, String a2, String a3){
        question = q;
        answers = new String[anum];
        answers[0] = a1;
        answers[1] = a2;
        answers[2] = a3;
    }
    MultipleChoice(String q, int anum, String a1, String a2, String a3, String a4){
        question = q;
        answers = new String[anum];
        answers[0] = a1;
        answers[1] = a2;
        answers[2] = a3;
        answers[3] = a4;
    }
    MultipleChoice(String q, int anum, String a1, String a2, String a3, String a4, String a5){
        question = q;
        answers = new String[anum];
        answers[0] = a1;
        answers[1] = a2;
        answers[2] = a3;
        answers[3] = a4;
        answers[4] = a5;
    }
    protected void readQuestion() {
        System.out.println(question);
        String[] thing = new String[]{"A. ", "B. ", "C. ", "D. ", "E. ", "F. "};
        for (int i=0; i<answers.length;i++){
            System.out.println(thing[i]+answers[i]);
        }
    }
}
