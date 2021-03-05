import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int count =0;
        int nextStep = -1;
        ArrayDeque<Integer>stack = new ArrayDeque<>();

        while (++nextStep<steps){
            boolean isValley = path.charAt(nextStep) == 'D';
            stack.push(0);
            while (!stack.isEmpty() && ++nextStep<steps){
                if(isValley) {
                    if (path.charAt(nextStep) == 'D') {
                        stack.push(0);
                    } else {
                        stack.pop();
                    }
                }else{
                    if (path.charAt(nextStep) == 'D') {
                        stack.pop();
                    } else {
                        stack.push(0);
                    }
                }
            }
            if (isValley){
                count++;
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
        System.out.println(result);
    }
}
