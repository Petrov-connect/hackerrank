package FrequencyQueries;
//created by J.M.

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        /*HashMap<Integer, Integer> values = new HashMap<>();
        HashMap<Integer, Set<Integer>> count = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (List<Integer> query : queries) {

            int operation = query.get(0);
            int number = query.get(1);

            int oldCount = values.getOrDefault(number, 0);
            int newCount;

            switch (operation) {
                case 1:
                    newCount = oldCount + 1;
                    values.put(number, newCount);

                    if (count.containsKey(oldCount)) {
                        count.get(oldCount).remove(number);
                    }
                    count.putIfAbsent(newCount, new HashSet<>());
                    count.get(newCount).add(number);
                    break;
                case 2:
                    newCount = (oldCount > 1) ? oldCount - 1 : 0;
                    values.put(number, newCount);

                    if (count.containsKey(oldCount)) {
                        count.get(oldCount).remove(number);
                    }

                    count.putIfAbsent(newCount, new HashSet<>());
                    count.get(newCount).add(number);
                    break;
                case 3:
                    output.add((number == 0 || count.getOrDefault(number, Collections.emptySet()).size() > 0) ? 1 : 0);
                    break;
            }
        }

        return output;*/

        //OR:___________________________________________

        List<Integer> out = new ArrayList<>();
        Map<Integer, Integer> value = new HashMap<>();
        List<Integer> counts = new ArrayList<>();

        for (List<Integer> data : queries) {
            int num = data.get(1);
            int command = data.get(0);

            switch (command) {
                case 1:
                    if(value.containsKey(num)){
                        counts.remove(value.get(num));
                        value.put(num,value.get(num) + 1);
                    }else{
                        value.put(num,1);
                    }
                    counts.add(value.get(num));
                    break;
                case 2:
                    if (value.containsKey(num) && value.get(num) > 0) {
                        counts.remove(value.get(num));
                        value.put(num, value.get(num) - 1);
                        counts.add(value.get(num));
                    }
                    break;
                case 3:
                    out.add(counts.contains(num) ? 1 : 0);
                    break;
            }
        }

        return out;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
