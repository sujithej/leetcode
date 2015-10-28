/**
 * Created by sujith.j on 27/10/15.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<n)
        {
            int temp =m;
            m = n;
            n = temp;

        }
        return (int)binomialCoefficient(m-1+n-1,n-1);

    }



    public int gcd(int a, int b) {
        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }


    public static int mulAndCheck(int x, int y) {
        long m = (long)x * (long)y;

        return (int)m;

    }

    public  long binomialCoefficient(int n, int k) {

        if(n != k && k != 0) {
            if(k != 1 && k != n - 1) {
                if(k > n / 2) {
                    return binomialCoefficient(n, n - k);
                } else {
                    long result = 1L;
                    int i;
                    int j;
                    if(n <= 61) {
                        i = n - k + 1;

                        for(j = 1; j <= k; ++j) {
                            result = result * (long)i / (long)j;
                            ++i;
                        }
                    } else {
                        long d;
                        if(n <= 66) {
                            i = n - k + 1;

                            for(j = 1; j <= k; ++j) {
                                d = (long)gcd(i, j);
                                result = result / ((long)j / d) * ((long)i / d);
                                ++i;
                            }
                        } else {
                            i = n - k + 1;

                            for(j = 1; j <= k; ++j) {
                                d = (long)gcd(i, j);
                                result = mulAndCheck((int)(result / ((long)j / d)), (int)((long)i / d));
                                ++i;
                            }
                        }
                    }

                    return result;
                }
            } else {
                return (long)n;
            }
        } else {
            return 1L;
        }
    }
}
