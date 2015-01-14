package su.problems;

import java.util.*;
import java.util.List;

/**
 * Created by Akshat on 9/28/2014.
 */
public class Topic implements Comparable<Topic>{

    int id ;
    long z ,p,l,c,s ;

    Topic(int id, long z, long p, long l, long c, long s) {
        this.id = id;
        this.z = z;
        this.p = p*50;
        this.l = l*5;
        this.c = c*10;
        this.s = s*20;
        newZScore = this.p + this.l + this.c + this.s;
        change = newZScore - z;
    }

    long change, newZScore;



    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Topic> trends = new ArrayList<Topic>();
        for (int i = 0; i < num; i++)
        {
            int id = scanner.nextInt();
            long z = scanner.nextLong();
            long p = scanner.nextLong();
            long l = scanner.nextLong();
            long c = scanner.nextLong();
            long s = scanner.nextLong();

            Topic topic = new Topic(id, z, p, l, c, s);
            trends.add(topic);

        }
        Collections.sort(trends);
        int cnt = 0;
        for(Topic trend: trends)
        {
            System.out.println(trend.id + " " + trend.newZScore);
            cnt++;
            if(cnt==5)
                break;
        }
    }



    public int compareTo(Topic o1) {
            if(o1.change == this.change) {
                if(o1.id > this.id)
                    return 1;
                else return -1;
            }
            else
            if(o1.change > this.change)
                return 1;
            else return -1;
    }



}

