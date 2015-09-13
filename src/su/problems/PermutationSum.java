package su.problems;

import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Akshat on 2/8/2015.
 */
public class PermutationSum {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PermutationSum permutationSum = new PermutationSum();
        int N = scanner.nextInt();
        for(int i=0;i< N;i++) {
            System.out.println(permutationSum.compute(scanner.nextInt()));
        }
    }

    public int compute(int input) {

        if(input<3)
            return 1;

        Deque<Integer> inputDQ = new ConcurrentLinkedDeque<>();
        for(int i=input-1;i>0;i--)
            inputDQ.push(i);


        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.push(input);

        boolean removeFromTop = true;

        int sum = 0;
        while(inputDQ.peek()!=null)
        {
            if(removeFromTop) {
                sum = addCurr(deque, sum, inputDQ.pop());
                if(inputDQ.peek()==null)
                    return sum;
                sum = addCurr(deque, sum, inputDQ.pop());
                removeFromTop = false;
            }else{
                sum = addCurr(deque, sum, inputDQ.removeLast());
                if(inputDQ.peek()==null)
                    return sum;
                sum = addCurr(deque, sum, inputDQ.removeLast());
                removeFromTop = true;
            }
        }

        return sum;
    }

    private int addCurr(Deque<Integer> deque, int sum, int curr) {
        if (Math.abs(deque.peekFirst() - curr) > Math.abs(deque.peekLast() - curr)) {
            sum = sum + Math.abs(deque.peekFirst() - curr);
            deque.push(curr);
        } else {
            sum = sum + Math.abs(deque.peekLast() - curr);
            deque.addLast(curr);
        }
        return sum;
    }
}
