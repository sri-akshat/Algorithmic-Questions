package su.problems.codeJam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Created by asrivastava6 on 5/8/16.
 */
public class Slides {

    static int currPathNum = 0;

    public static void main(String[] args) throws IOException {

        Writer writer = new FileWriter("/Users/asrivastava6/myProjects/Algorithmic-Questions/resource/slidesOutput.txt");
        Scanner scanner = new Scanner(new File("/Users/asrivastava6/myProjects/Algorithmic-Questions/resource/slidesInput.txt"));
        int num = Integer.parseInt(scanner.next());
        scanner.nextLine();

        Map<Integer, ArrayList<Integer>> adjacencyMap = new HashMap<>();
        Slides slides = new Slides();
        for(int i=0; i<num; i++){
            int B = scanner.nextInt();
            int M = scanner.nextInt();

            int k = i+1;
            boolean result = slides.check(B, M, adjacencyMap);
            String s = result?"POSSIBLE":"IMPOSSIBLE";
            writer.write("Case #" + k + ": " + s + "\n");
            if(result){
                print(writer, adjacencyMap, B);
            }
            currPathNum = 0;
        }
        writer.flush();
        writer.close();
        scanner.close();
    }

    private static void print(Writer writer, Map<Integer, ArrayList<Integer>> adjacencyMap, int B) throws IOException {
        for(int i = 0;i < B;i++ ){
            for(int j=0;j<B;j++){
                if(adjacencyMap.get(i)!=null && adjacencyMap.get(i).contains(j)){
                    writer.write("1");
                }else{
                    writer.write("0");
                }
            }
            writer.write("\n");
        }
    }

    private boolean check(int B, int M, Map<Integer, ArrayList<Integer>> adjacencyMap) {

        for(int i = 1;i<B;i++){
            List<Integer> integerList = new ArrayList<>();
            for(int j = 1;j<=i;j++){
                integerList.add(j);
            }
            genPermuations(integerList, 0, adjacencyMap, M, B);
        }

        if(currPathNum == M){
            return true;
        }

        return false;
    }

    static void genPermuations(java.util.List<Integer> arr, int k, Map<Integer, ArrayList<Integer>> adjacencyMap, int M, int B) {
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            genPermuations(arr, k + 1, adjacencyMap, M, B);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {

            boolean cycle = false;
            int prev = arr.get(0);
            for(int j= 1;j< arr.size();j++){
                int curr = arr.get(j);
                if(cycleExists(adjacencyMap, prev, curr)){
                    cycle = true;
                    break;
                }
            }

            //adding a new path
            if(!cycle){
                addEdge(adjacencyMap, 0, prev);
                prev = arr.get(0);
                int curr = arr.get(0);
                for(int j= 1;j< arr.size();j++){
                    curr = arr.get(j);
                    addEdge(adjacencyMap, prev, curr);
                }
                addEdge(adjacencyMap, curr, B-1);
                currPathNum++;

                if(currPathNum == M){
                    return;
                }
            }

            String permutation = java.util.Arrays.toString(arr.toArray());
            System.out.println(permutation);
        }
    }

    private static void addEdge(Map<Integer, ArrayList<Integer>> adjacencyMap, int src, int dest) {
        if(adjacencyMap.get(src)!=null && adjacencyMap.get(src).contains(dest))
            return;

        List<Integer> integerList = adjacencyMap.get(src);
        if(integerList == null){
            integerList = new ArrayList<>();
        }
        integerList.add(dest);
        adjacencyMap.put(src, (ArrayList<Integer>) integerList);
    }

    private static boolean cycleExists(Map<Integer, ArrayList<Integer>> adjacencyMap, int prev, int curr) {

        if(adjacencyMap.get(prev)!=null && adjacencyMap.get(prev).contains(curr))
            return false;

        if(adjacencyMap.get(curr)!=null && adjacencyMap.get(curr).contains(prev))
            return true;
        else if(adjacencyMap.get(curr)==null || adjacencyMap.get(curr).isEmpty())
            return false;

        for (int i : adjacencyMap.get(curr)) {
            cycleExists(adjacencyMap, prev, i);
        }

        return false;
    }
}
