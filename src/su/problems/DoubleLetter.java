package su.problems;

public class DoubleLetter{

    public String ableToSolve(String s)
    {
        String inputOrig = s;
        String input = new String(inputOrig);

        for(int k=0; k < inputOrig.length()/2; k++)
        {
            String original = new String(input);
            input = input.replaceAll("(aa)*", "");
            input = input.replaceAll("(bb)*", "");
            input = input.replaceAll("(cc)*", "");
            input = input.replaceAll("(dd)*", "");
            input = input.replaceAll("(ee)*", "");
            input = input.replaceAll("(ff)*", "");
            input = input.replaceAll("(gg)*", "");
            input = input.replaceAll("(hh)*", "");
            input = input.replaceAll("(ii)*", "");
            input = input.replaceAll("(jj)*", "");
            input = input.replaceAll("(kk)*", "");
            input = input.replaceAll("(ll)*", "");
            input = input.replaceAll("(mm)*", "");
            input = input.replaceAll("(nn)*", "");
            input = input.replaceAll("(oo)*", "");
            input = input.replaceAll("(pp)*", "");
            input = input.replaceAll("(qq)*", "");
            input = input.replaceAll("(rr)*", "");
            input = input.replaceAll("(ss)*", "");
            input = input.replaceAll("(tt)*", "");
            input = input.replaceAll("(uu)*", "");
            input = input.replaceAll("(vv)*", "");
            input = input.replaceAll("(ww)*", "");
            input = input.replaceAll("(xx)*", "");
            input = input.replaceAll("(yy)*", "");
            input = input.replaceAll("(zz)*", "");
            if(input.isEmpty()) {
                return "Possible";
            }else if(original.equals(input))
            {
                return "Impossible";
            }
        }
        return null;
    }
}