public class RectangularArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int commonArea =  getLength(A,C,E,G) * getLength(B,D,F,H);
        int totalArea = Math.abs(C-A)*Math.abs(D-B) + Math.abs(G-E) * Math.abs(H-F);
        return totalArea - commonArea;
    }

    public int getLength(int a,int b,int c,int d) {
        Integer startPoint = null;
        Integer endPoint = null;
        if((a <= c && a>=d) || (a>= c && a<= d) ) {
            startPoint = a;
        }
        if((b <= c && b>=d) || (b>= c && b<= d) ) {
            if(startPoint == null)
                startPoint = b;
            else
                endPoint = b;
        }
        if((c < a && c > b) || (c > a && c <b) ) {
            if(startPoint == null)
                startPoint = c;
            else
                endPoint = c;
        }
        if((d < a && d > b) || (d > a && d <b) ) {
            if(startPoint == null)
                startPoint = d;
            else
                endPoint = d;
        }
        if(startPoint == null || endPoint == null)
            return 0;
        return Math.abs(endPoint - startPoint);
    }

    public static void main(String []args) {
        System.out.println((new RectangularArea()).computeArea(-2, -2, 2, 2, -3, -3, -2, -2));
    }

}
