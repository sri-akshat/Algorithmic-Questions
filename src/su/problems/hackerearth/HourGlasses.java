package su.problems.hackerearth;

/**
 * Created by asrivastava6 on 2/13/16.
 */
public class HourGlasses {
    public String compute(int sizeA, int sizeB, int[] array) {
        int diff = Math.abs(sizeA - sizeB);
        StringBuffer result = new StringBuffer();
        for(int i:array){
            result.append(compute(sizeA, sizeB, diff, i));
        }
        return result.toString();
    }

    private int compute(int sizeA, int sizeB, int diff, int seconds) {

//        if(seconds%sizeA == 0 || seconds%sizeB == 0 || seconds%(sizeA+sizeB) == 0){
//            return 1;
//        }

        int large = sizeB, small = sizeA;
        if(sizeA > sizeB){
            large = sizeA;
            small = sizeB;
        }

        int largeMOD = seconds%large;

        if(largeMOD == 0){
            return 1;
        }

        int smallMOD = largeMOD%small;

        if(smallMOD == 0){
            return 1;
        }

        if((smallMOD%diff) == 0){
            return 1;
        }

        return 0;
    }
}
