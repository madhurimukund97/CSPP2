import java.io.FileReader;
import java.lang.Math;
import java.io.*;
import java.util.*;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        // File t;
        try {
            Scanner inp = new Scanner(System.in);
            File t = new File(inp.nextLine());
            File[] tes = t.listFiles();
            // System.out.print("\t\t");
            for (File n : tes) {
                System.out.print("\t" + n.toString().split("\\\\")[1]);
            }
            for (File k : tes) {
                String inp1 = k.getAbsolutePath();
                // System.out.println(inp1);
                System.out.println();

                System.out.print(k.toString().split("\\\\")[1] + "\t");
                for (File n1 : tes) {
                    String inp2 = n1.getAbsolutePath();
                    // System.out.println(inp2);
                    try {
                        FileReader ip = new FileReader(inp1);
                        FileReader ip2 = new FileReader(inp2);

                        BufferedReader b = new BufferedReader(ip);
                        BufferedReader b2 = new BufferedReader(ip2);
                        HashMap<String, Integer> f = new HashMap<>();
                        HashMap<String, Integer> f2 = new HashMap<>();

                        String lines;
                        while ((lines = b.readLine()) != null) {
                            String[] line = lines.replaceAll("[^a-zA-Z0-9_ ]",
                                "").toLowerCase().split(" ");
                            // String[] line = lines.toLowerCase().split(" ");
                            for (String ele : line) {
                                if (f.containsKey(ele)) {
                                    f.put(ele, f.get(ele) + 1);

                                } else {
                                    f.put(ele, 1);
                                }
                                if (!f2.containsKey(ele)) {
                                    f2.put(ele, 0);

                                }

                            }
                            // System.out.println(f);

                        }

                        while ((lines = b2.readLine()) != null) {
                            String[] line = lines.replaceAll(
                                "[^a-zA-Z0-9_ ]", "").toLowerCase().split(" ");


                            // String [] line = lines.toLowerCase().split(" ");

                            for (String ele : line) {
                                if (f2.containsKey(ele)) {
                                    f2.put(ele, f2.get(ele) + 1);

                                } else {
                                    f2.put(ele, 1);
                                }
                                if (!f.containsKey(ele)) {
                                    f.put(ele, 0);

                                }

                            }
                            // System.out.println(f2);

                        }
                        // System.out.print(plag_percent(f, f2) + "\t");

                        int res = 0, res2 = 0, temp = 0;
                        // System.out.println(f + "    " + f2);
                        for (String k1 : f.keySet()) {
                            res += f.get(k1) * f.get(k1);
                            // System.out.println(res);
                            res2 += f2.get(k1) * f2.get(k1);
                            // System.out.println(res2);
                            temp += f.get(k1) * f2.get(k1);
                            // System.out.println(temp);

                        }
                        final int hun = 100;
                        System.out.print((int) ((temp
                            / (Math.sqrt(res)
                            * Math.sqrt(res2))) * hun) + "\t\t");

                    } catch (FileNotFoundException e) {
                        System.out.println("File not Found");

                    } catch (IOException e) {
                        System.out.println("Invalid Input");
                    }
                }
            }
            System.out.println();
            } catch (Exception e) {
                System.out.println("empty directory");
            }
    }
}
