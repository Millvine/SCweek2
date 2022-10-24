import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;

public class Main {
        public static Map whileLoops(BufferedReader br,String line,Map<String,Integer> something) throws IOException {
            String[] a = line.split(" ");
            String varName = a[Arrays.asList(a).indexOf("while") + 1];
            int times = something.get(varName);
            while (true) {
                String line1 = br.readLine();
                if (line1.contains("end;")) {
                    break;
                } else if (line1.contains("clear")) {
                    String[] b = line1.split("[ ;]");
                    something.put(b[Arrays.asList(b).indexOf("clear") + 1], 0);
                } else if (line1.contains("incr")) {
                    String[] b = line1.split("[ ;]");
                    int i = something.get(b[Arrays.asList(b).indexOf("incr") + 1]);
                    something.replace(b[Arrays.asList(b).indexOf("incr") + 1], i + times);
                } else if (line1.contains("decr")) {
                    String[] b = line1.split("[ ;]");
                    int i = something.get(b[Arrays.asList(b).indexOf("decr") + 1]);
                    something.replace(b[Arrays.asList(b).indexOf("decr") + 1], i - times);
                } else if (line1.contains("while")){
                    whileLoops(br,line1,something);
                }


            }
            return something;

        }


    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("INSERT YOUR BAREBONE INPUT FILE HERE");
        BufferedReader br = new BufferedReader(fr);
        Map<String,Integer> variables = new HashMap<String,Integer>();
        while (true) {
            String line = br.readLine();
            System.out.println(line);
            if(line == null){
                break;
            }
            else if (line.contains("clear")) {
                String[] a = line.split("[ ;]");
                variables.put(a[1],0);
            } else if (line.contains("incr")) {
                String[] a = line.split("[ ;]");
                int i = variables.get(a[1]);
                variables.replace(a[1], i + 1);
            } else if(line.contains("decr")) {
                String[] a = line.split("[ ;]");
                int i = variables.get(a[1]);
                variables.replace(a[1], i - 1);
            } else if(line.contains("while")){
                   variables = whileLoops(br,line,variables);
            }

        }
        System.out.println(variables);


    }



}








