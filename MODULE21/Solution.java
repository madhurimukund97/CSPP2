import java.util.Scanner;
class Log {
    private FoodLog[] flog;
    private WaterLog[] wlog;
    private Activity[] act;
    private Weight[] weightc;
    private Sleep[] sleep;
    private int fsize, wasize, asize, wsize, ssize;
    private final int ten = 10;

    Log() {
        flog = new FoodLog[ten];
        wlog = new WaterLog[ten];
        act = new Activity[ten];
        weightc = new Weight[ten];
        sleep = new Sleep[ten];
        fsize = 0;
        wasize = 0;
        asize = 0;
        wsize = 0;
        ssize = 0;
    }

    public void addfoodLog(String n, String q, String t) {
        // flog[fsize++] = n;
        FoodLog fl = new FoodLog(n, q, t);
        flog[fsize++] = fl;
    }

    public void addwaterLog(double consumed) {
        WaterLog wl = new WaterLog(consumed);
        wlog[wasize++] = wl;
    }

    public void addactivityLog(String actname, String d1, String sTime, String eTime, String n) {
        Activity a = new Activity(actname, d1, sTime, eTime, n);
        act[asize++] = a;
    }

    public void addweightLog(double weigh, double fpercent, String weighdate) {
        Weight w = new Weight(weigh, fpercent, weighdate);
        weightc[wsize++] = w;
    }

    public void addsleepLog(String sleepS, String sleepE) {
        Sleep s = new Sleep(sleepS, sleepE);
        sleep[ssize++] = s; 
    }
    public void printdetails() {

        for (int i = 0; i < fsize; i++) {
        // int i = 0;
        System.out.println(flog[i].getFoodName() + "\n" + flog[i].getQuantity() + "\n" + flog[i].getTime());
        // i++;
            // return;
        }

        for (int j = 0; j < wasize; j++) {
            System.out.println(wlog[j].getWaterConsumed());
            // break;
        }

        for (int k = 0; k < asize; k++) {
            System.out.println(act[k].getActivityName() + "\n" + act[k].getDate() + "\n" + act[k].getStartTime() + "\n" + act[k].getEndTime() + "\n" + act[k].getNotes());            
        }

        for (int a = 0; a < wsize; a++) {
            System.out.println(weightc[a].getWeight() + "\n" + weightc[a].getfatpercent() + "\n" + weightc[a].getWDate());
        }

        for (int m = 0; m < ssize; m++) {
            System.out.println(sleep[m].getsleepstart() + "\n" + sleep[m].getsleepend());
        }

    }



}

class FoodLog {
    private String name;
    private String quantity;
    private String time;

    FoodLog(String name1, String quantity1, String time1) {
        this.name = name1;
        this.quantity = quantity1;
        this.time = time1;
    }


    public String getFoodName() {
        return this.name;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getTime() {
        return this.time;
    }

}

class WaterLog {
    private double waterConsumed;

    WaterLog(double waterConsumed1) {
        this.waterConsumed = waterConsumed1;
    }

    public double getWaterConsumed() {
        return this.waterConsumed;
    }
}

class Activity {
    private String activityName;
    private String date;
    private String startTime;
    private String endTime;
    private String notes;

    Activity(String activityName1, String date1, String startTime1, String endTime1, String notes1) {
        this.activityName = activityName1;
        this.date = date1;
        this.startTime = startTime1;
        this.endTime = endTime1;
        this.notes = notes1;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getDate() {
        return this.activityName;
    }
    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getNotes() {
        return this.notes;
    }

}

class Weight {
    private double weight;
    private double fatpercent;
    private String wdate;

    Weight(double weight1, double fatpercent1, String wdate1) {
        this.weight = weight1;
        this.fatpercent = fatpercent1;
        this.wdate = wdate1;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getfatpercent() {
        return this.fatpercent;
    }

    public String getWDate() {
        return this.wdate;
    }

}

class Sleep {
    private String sleepStart;
    private String sleepEnd;
    Sleep(String sleepStart1, String sleepEnd1) {
        this.sleepStart = sleepStart1;
        this.sleepEnd = sleepEnd1;
    }
    public String getsleepstart() {
        return this.sleepStart;
    }
    public String getsleepend() {
        return this.sleepEnd;
    }
}

public final class Solution {
    public static void main(String[] args) {
        Log l = new Log();
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String line = s.nextLine();
            String[] tokens = line.split(" ", 2);
            switch(tokens[0]) {
                case "Food":
                String[] tokensf = tokens[1].split(",");
                l.addfoodLog(tokensf[0], tokensf[1], tokensf[2]);
                break;
                case "Water":
                // String[] tokenswa = tokens[1].split(",");
                l.addwaterLog(Integer.parseInt(tokens[1]));
                break;
                case "PhysicalActivity":
                String[] tokensa = tokens[1].split(",");
                l.addactivityLog(tokensa[0], tokensa[1], tokensa[2], tokensa[3], tokensa[4]);
                break;
                case "Weight":
                String[] tokensw = tokens[1].split(",");
                l.addweightLog(Double.parseDouble(tokensw[0]), Double.parseDouble(tokensw[1]), tokensw[2]);
                break;
                case "Sleep":
                String[] tokenss = tokens[1].split(",");
                l.addsleepLog(tokenss[0], tokenss[1]);
                break;
                case "print":
                l.printdetails();
                default:
                break;
            }
        }
    }
}
