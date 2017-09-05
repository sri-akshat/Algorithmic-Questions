package su.problems.codeJam;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class JamCoin {

    FileInputStream fin;
    Writer fop;

    List<Coin> jamCoins = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        new JamCoin().execute();
    }



    private void execute() throws IOException {
        readPrimes();
        generateJamCoins(65000);

        fin = new FileInputStream("ip1.txt");
        fop = new FileWriter("op1.txt");

        Scanner s = new Scanner(fin);
        int num = s.nextInt();
        int caseNum = 1;
        for (int i = 1; i <=num ; i++){
            int n = s.nextInt();
            long j = s.nextInt();
            process(n,j, caseNum++);
        }
        fin.close();
        fop.flush();
        fop.close();
    }

    private void process(int n, long j, int caseNum) throws IOException {
        char[] startNumString = new char[n];
        Arrays.fill(startNumString,'0');
        startNumString[0] = '1';
        startNumString[n-1] = '1';

        long startNum = Long.parseLong(new String(startNumString), 2);

        int index = Collections.binarySearch(jamCoins, new Coin(startNum), new Comparator<Coin>() {
            @Override
            public int compare(Coin o1, Coin o2) {
                return o1.getNum() == o2.getNum() ? 0 : o1.getNum() > o2.getNum() ? 0 : -1;
            }
        });

        fop.write("Case #"+ caseNum + ":");
        for (int i = index;i<index+j;i++) {
            //fop.write( " \n" + jamCoins.get(i).getEquivalentBases().toString() +"\n");
            fop.write("\n" + Long.toBinaryString(jamCoins.get(i).getNum()));
            for (Long p : jamCoins.get(i).getEquivalentBases()) {
                BigInteger bigInteger = new BigInteger("1");

                System.out.println("Evaluating Coin : " + jamCoins.get(i) + " , base : " + p);


                long count = 1;
                while(count++ < Long.MAX_VALUE) {
                     bigInteger = bigInteger.nextProbablePrime();
                  //  System.out.println(bigInteger.toString());
                    if (p % bigInteger.longValue() == 0) {
                        fop.write(" " + bigInteger.longValue());
                        System.out.println("Found divisor" + bigInteger.longValue());

                        break;
                    }
                }
            }
        }


    }


    private void readPrimes() throws IOException {
        FileInputStream pin = new FileInputStream("allPrimes.txt");
        Scanner s = new Scanner(pin);
        while(s.hasNext()) {
            allPrimes.add(s.nextLong());
        }
        pin.close();
    }

    private void generateJamCoins(int n) {
        List<Integer> allCoins = new ArrayList<>();
        for (int j = 3; j<= n ; j++) {
            if (Integer.toBinaryString(j).matches("^1.*1$")) {
                allCoins.add(j);
            }
        }
        System.out.println(allCoins.toString());
            for (Integer coin : allCoins) {
                boolean isJamCoin = true;
                Coin newCoin = new Coin();
                newCoin.setNum(coin.longValue());
               // System.out.println("\n" + coin + " : ");
                for (int i = 2; i<=10; i++) {
                    BigInteger numberInBaseI = new BigInteger(Integer.toBinaryString(coin), i);
                    newCoin.addNumberInBaseI(numberInBaseI.longValue());
                    //System.out.print(numberInBaseI + ", ");
                    if (numberInBaseI.isProbablePrime(100)) {
                        isJamCoin = false;
                        break;
                    }
                }
                if (isJamCoin) {
                    jamCoins.add(newCoin);
                }
            }

        System.out.println();

        System.out.println(jamCoins.toString());


    }


    List<Long> allPrimes = new ArrayList<>();

    class Coin {
        Long num;
        List<Long> equivalentBases = new ArrayList<>();

        public Coin(long startNum) {
            this.num = startNum;
        }

        public Coin() {

        }

        public Long getNum() {
            return num;
        }

        public void setNum(Long num) {
            this.num = num;
        }

        public List<Long> getEquivalentBases() {
            return equivalentBases;
        }

        public void addNumberInBaseI(Long divisor) {
            this.equivalentBases.add(divisor);
        }

        @Override
        public String toString() {
            return num.toString();
        }
    }
}
