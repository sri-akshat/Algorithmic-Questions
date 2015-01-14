package su.problems;

/**
 * Created by Akshat on 6/17/2014.
 */
public class TowerOfHanoi {

    private void move(int n, char from, char aux, char to)
    {
        // from -> to (n)
        if(n==1) {
            System.out.println("move first block from " + from + " to " + to);
            return;
        }

        // from -> aux (n-1)
        move(n-1, from, to, aux);

        System.out.println("move block from "+from+" to "+to);

        // aux -> to (n-1)
        move(n-1, aux, from, to);
    }

    public static void main(String[] args)
    {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.move(3, 'A', 'B', 'C');
    }
}
