public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int []uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 =0;
        int ugly2,ugly3,ugly5;
        for(int i =1 ; i < n ;i ++){
            ugly2 = uglyNumbers[pointer2] * 2;
            ugly3 = uglyNumbers[pointer3] * 3;
            ugly5 = uglyNumbers[pointer5] * 5;
            if(ugly2 <= ugly3 && ugly2 <= ugly5){
                uglyNumbers[i] = ugly2;
                pointer2++;
                if(ugly2 == ugly3){
                    pointer3++;
                }
                if(ugly2 == ugly5){
                    pointer5++;
                }
            }else if(ugly3 <= ugly5) {
                uglyNumbers[i] = ugly3;
                pointer3++;
                if(ugly5 == ugly3){
                    pointer5++;
                }
            }else {
                uglyNumbers[i] = ugly5;
                pointer5++;
            }
        }
        return uglyNumbers[n-1];
    }

    public static void main(String []args){
        int ans = (new UglyNumber2()).nthUglyNumber(7);
        System.out.println(ans);
    }
}
