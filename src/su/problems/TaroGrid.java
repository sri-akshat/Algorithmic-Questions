package su.problems;

/**
 * Created by Akshat on 8/30/2014.
 */
public class TaroGrid {

    public int getNumber(String[] grid){

        int maxSeq = 0;
        for(int i=0;i<grid.length;i++) {
            int prevEle = 0;
            int seqCnt = 1;
            for (int j = 0; j < grid.length; j++) {
                int currEle = grid[i].charAt(j)=='W'?-1:1;
                if(currEle == prevEle)
                {
                    seqCnt++;
                }else{
                    seqCnt = 1;
                }
                prevEle = currEle;
            }
            if(seqCnt > maxSeq)
            {
                maxSeq = seqCnt;
            }
        }

        return maxSeq;
    }

}
