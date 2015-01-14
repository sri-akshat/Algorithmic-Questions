package su.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TestClass
{
    public static void main( String args[] ) throws Exception
    {
        Scanner scanner = new Scanner( System.in );
        int caseIdx = scanner.nextInt();
        for ( int i = 1; i <= caseIdx; i++ )
        {
            int n = scanner.nextInt();
            List<Integer> right = new ArrayList<Integer>( log( n + 1, 2 ) );
            List<Integer> left = new ArrayList<Integer>( log( n + 1, 2 ) );
            int levelMax = 1;
            int levelCount = 1;
            int levelIdx = 0;
            int first = 0;
            int last = 0;
            int nzcount = 0;
            for ( int j = 1; j <= n; j++ )
            {
                int curr = scanner.nextInt();
                if ( curr != 0 )
                {
                    nzcount++;
                    if ( first == 0 )
                    {
                        first = curr;
                    }
                    last = curr;
                }

                if ( j == levelMax )
                {
                    levelIdx = 0;
                    levelCount *= 2;
                    levelMax += levelCount;

                    if ( nzcount == 1 )
                    {
                        right.add( first );
                        left.add( 0 );
                    }
                    else
                    {
                        left.add( first );
                        right.add( last );
                    }
                    nzcount = 0;
                    first = 0;
                    last = 0;
                }
                else
                {
                    levelIdx++;
                }
            }
            for ( int node : right )
            {
                if ( node != 0 )
                    System.out.println( node );
            }
            for ( int node : left )
            {
                if ( node != 0 )
                    System.out.println( node );
            }
            System.out.println();
        }
        scanner.close();
    }

    private static int log( int i, int j )
    {
        return ( int ) ( Math.log( i ) / Math.log( j ) );
    }

}