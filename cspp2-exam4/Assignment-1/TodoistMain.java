import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
    // TodoistMain t1[];
    String title, assignedTo, status;
    int timeToComplete;
    Boolean important, urgent;
    String imp, ifurgent;

    Task(String title1, String assignedTo1, int timeToComplete1, Boolean important1, Boolean urgent1, String status1) {
        // t1 = new TodoistMain[10];
        this.title = title1;
        this.assignedTo = assignedTo1;
        this.timeToComplete = timeToComplete1;
        // if(important1) {
        //     this.important = "Important";
        // }
        // if(urgent) {
        //     this.ur
        // }
        this.urgent = urgent1;
        this.status = status1;
    }
    // public String getTitle(String title3) {
    //     return this.title;
    // }
    // public String getassigned(String name) {
    //     return this.assignedTo;
    // }
    // public int getTime(int time3) {
    //     return this.timeToComplete;
    // }
    // public String getimportant(Boolean imp) {
    //     // boolean getimportant =
        
    //     return this.important;
    // }

    // public Boolean geturgent(Boolean urg) {
    //     // boolean Urgent = true;
    //     // boolean false = ;

        
    //     return th;
    // }
    // public String getstatus(String stat) {
    //     // if (this.status == "todo" || this.status == "done") {
    //     //     System.out.println(this.status);
    //     // }
    //     return this.status;    
    // }
    public String toString() {
        if (important) {
            imp = "Important";
        }  
        else {
            imp = "Not Important";
        }
        if (urgent) {
            ifurgent = "Urgent";
        }  
        else {
            ifurgent = "Not Urgent";
        }
        return this.title + ", " + this.assignedTo + ", " + this.timeToComplete + ", " +  this.imp + ", " + this.ifurgent + ", " + this.status; 
    }

}

class Todoist {
    Task[] t;
    int size;
    Todoist() {
        t = new Task[10];
        size = 0;
    }
    public String addTask(Task t1) {
        // t[size++] = t1;
        return null;
    }
    public String getNextTask(String title) {
        // System.out.println(t.getNextTask());
        return null;
    }
    public int totalTime4Completion(int time) {
        return 1;
    }

    public Task[] getNextTask(String title, int n) {
        return null;
    }




}
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                // case "total-time":
                //     System.out.println(todo.totalTime4Completion());
                // break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
        // System.out.println();
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
