package su.problems;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 3/16/13
 * Time: 8:36 AM
 * To change this template use File | Settings | File Templates.
 */

enum Rules {
        E1("More than 2 children") {
            @Override
            boolean isApplicable(Map<Character, Set<Character>> tree){
            for(Character parent : tree.keySet()) {
                if(tree.get(parent).size()>2){
                    return true;
                }
            }
            return false;
            }
        },
        E2("Duplicate Tuples") {
            @Override
            boolean isApplicable(Map<Character, Set<Character>> tree) {
            Set<Character> allChilds = new HashSet<Character>();
            for(Character parent : tree.keySet())
            {
                for(Character child : tree.get(parent))
                {
                    if(allChilds.contains(child))
                    {
                        return true;
                    }else{
                        allChilds.add(child);
                    }
                }
            }
            return false;
            }
        },
        E3("Cycle present"){
            @Override
            boolean isApplicable(Map<Character, Set<Character>> tree) {
                int[][] matrix = new int[27][27];
                for(Character parent : tree.keySet())
                {
                    int p = parent - 64;
                    for(Character child : tree.get(parent))
                    {
                        int c = child - 64;
                        matrix[p][c] = 1;
                    }
                }

                for(int i=0; i<26; i++)
                {
                    for(int j=0; j<26; j++)
                    {
                        if(matrix[i][j] == matrix[j][i] && matrix[i][j] == 1)
                        {
                            return true;
                        }
                    }
                }
                return false;
            }
        },
        E4("Multiple roots")   {
            @Override
            boolean isApplicable(Map<Character, Set<Character>> tree) {

                Set<Character> allChilds = new HashSet<Character>();
                for(Character parent : tree.keySet())
                {
                    for(Character child : tree.get(parent))
                    {
                        allChilds.add(child);
                    }
                }

                int numRoots = 0;
                for(Character parent : tree.keySet())
                {
                    if(!allChilds.contains(parent))
                    {
                        numRoots++;
                    }

                    if(numRoots > 1)
                    {
                        return true;
                    }
                }
                return false;
            }
        };

    abstract boolean isApplicable(Map<Character, Set<Character>> tree);
    String errDesc;

    Rules(String errDesc)
    {
        this.errDesc = errDesc;
    }
}


public class TreeConverter {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeConverter treeConverter = new TreeConverter();
        Map<Character, Set<Character>> tree = treeConverter.parseInput(input);
        for(Rules rule : Rules.values())
        {
            if(rule.isApplicable(tree))
            {
                System.out.println(rule.name());
                System.exit(0);
            }
        }

        printOutput(tree);
    }

    private static void printOutput(Map<Character, Set<Character>> tree) {

        Character root = getRootCharacter(tree);
        Stack<Character> stack = new Stack<Character>();
        stack.push(')');
        stack.push(root);

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            Character element = stack.pop();
            if(element != null){
                if(element == ')'){
                    sb.append(')');
                }else {
                    sb.append("(").append(element);
                    if(tree.get(element)!=null)
                    {
                        for(Character child : tree.get(element)){
                            stack.push(')');
                            stack.push(child);
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }

    private static Character getRootCharacter( Map<Character, Set<Character>> tree){

        Set<Character> allChilds = new HashSet<Character>();
        for(Character parent : tree.keySet()) {
            for(Character child : tree.get(parent)){
                allChilds.add(child);
            }
        }
        for(Character parent : tree.keySet()){
            if(!allChilds.contains(parent)){
                return parent;
            }
        }
        return null;
    }

    private Map<Character, Set<Character>> parseInput(String input){

        Map<Character, Set<Character>> tree = new HashMap<Character, Set<Character>>();
        for(String parentChild : input.split(" ")){
            Character parent = parentChild.charAt(1);
            Character child = parentChild.charAt(3);
            if(tree.get(parent)!=null) {
                tree.get(parent).add(child);
            }else{
                Set<Character> childs = new HashSet<Character>();
                childs.add(child);
                tree.put(parent, childs);
            }
        }
        return tree;
    }
}
