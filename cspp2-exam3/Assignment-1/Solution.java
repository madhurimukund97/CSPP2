import java.util.Scanner;
class Quiz {

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static int questionCount;
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        // Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
        // if(tokens[1] != question) {

        // }
        // int choice = s.nextInt();
        String str = s.nextLine();
        // int choice = s.nextInt();
        // if(str != "question ") {
        //     System.out.println("----");
        // }
        // String str1= str.split(",");
        if(questionCount >= 0) {
            // System.out.println(".......");
            // if(str == "question about sony") {
            //     System.out.println("Invalid Penality for question about sony");
            // }
            // System.out.println("======");
            if(str != "question text") {
                System.out.println("Error! Malformed question");
            }
            // else{
            //     System.out.println("((((((");
            // }
            // if(str1 != 3) {
            //     System.out.println("trick question  does not have enough answer choices");
            // }
            // else if()
        }
        // else{
        //     System.out.println("............");
        // }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        // if(questionCount == 0) {
            // System.out.println("Error! Malformed question");
        // }
    }
}
