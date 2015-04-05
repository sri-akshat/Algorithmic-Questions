package su.problems;

/**
 * Created by Akshat on 2/14/2015.
 */
public class SherlockAndDate {
    public int compute(String date1, String date2) {

        int result = 0;
        if(isLucky(date1))
            result++;
        if(isLucky(date2))
            result++;

        int year1 = Integer.parseInt(date1.substring(date1.lastIndexOf(':')+1))+1;
        int year2 = Integer.parseInt(date2.substring(date2.lastIndexOf(':')+1))-1;

        int year1Last2Digit = Integer.parseInt(date1.substring(date1.lastIndexOf(':')+3))+1;
        int year2Last2Digit = Integer.parseInt(date2.substring(date2.lastIndexOf(':')+3))-1;

       for(int i = 3;i<14;i++)
       {
           if(year1Last2Digit <= i && i <= year2Last2Digit)
           {
               result++;
           }
       }


        int yearCentury = substract(year2, 100);
        int year1Century = add(year1, 100);
        int centuries = yearCentury != year2 && year1Century != year1 ? yearCentury - year1Century : year2-year1;
        int div = centuries / 100;

        result = result + (div*11);
        return result;
    }

    private int add(int year1, int val) {
        return year1 + val > 9999 ? year1 : year1 + val;
    }

    private int substract(int year1, int val) {
        return year1 - val > 0 ? year1 - val : year1;
    }

    private boolean isLucky(String date1) {

        String[] str = date1.split(":");
        int dd = Integer.parseInt(str[0]);
        int mm = Integer.parseInt(str[1]);
        int yyyy = Integer.parseInt(str[2]);
        if(mm == dd+1 && yyyy%100 == mm+1 )
            return true;
        return false;
    }
}
