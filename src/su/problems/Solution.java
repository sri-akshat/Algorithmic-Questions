package su.problems;

import java.util.*;
public class Solution {

    String input =  "(A,B) (B,C) (C,D) (D,A)";
    LinkedHashMap<Character,Object> relation = new LinkedHashMap();
    String s = "(";

    public void execute(String input){
        String [] pairs = input.split(" ");

        HashSet allChilds = new HashSet();
        int numPair=0;
        Arrays.sort(pairs);
        for(String s:pairs){
            node obj = (node)relation.get(s.charAt(1));
            if(obj==null){
                obj = new node();
                obj.p = s.charAt(1);
                if((numPair==0)||(allChilds.contains(s.charAt(1)))){
                    if(numPair==0)
                        allChilds.add(s.charAt(1));
                    obj.childs.add(s.charAt(3));
                    allChilds.add(s.charAt(3));
                    obj.num_of_child++;
                    relation.put(s.charAt(1), obj);
                }else{
                    System.out.println("E4");
                    break;
                }

            }else{
                if(obj.num_of_child<2){
                    if(!obj.childs.contains(s.charAt(3))){
                        obj.childs.add(s.charAt(3));
                        obj.num_of_child++;
                        allChilds.add(s.charAt(3));
                    }
                    else{
                        System.out.println("E2");
                        break;
                    }
                }else{
                    System.out.println("E1");
                    break;
                }
            }
            numPair++;
        }
    }

    public void outPut(Character c){
        ArrayList list=null;
        s = s+c;

        node val = (node)relation.get(c);
        if(val!=null)
            list = val.childs;

        if(list!=null){
            Collections.sort(list);
            s+="(";
        }else{
            s+=")";
            return;
        }

        outPut((Character)list.get(0));

        if(list.size()==2){
            s+="(";
            outPut((Character)list.get(1));
            s+=")";
        }

    }

    public static void main(String args[]){
        Solution obj = new Solution();
        obj.execute(obj.input);
        obj.outPut(obj.input.charAt(1));
        System.out.println(obj.s);
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		String s;
//
//		try {
//			String str = in.readLine();
//			if (str != null && str.length() > 0) {
////				obj.convert(str);
////				obj.print();
//			}
//		} catch (IOException e) {
//			System.out
//					.println("Exception in getting input" + e.getStackTrace());
//		}
    }


    class node{
        char p;
        int num_of_child=0;
        ArrayList childs = new ArrayList();

    }
}
