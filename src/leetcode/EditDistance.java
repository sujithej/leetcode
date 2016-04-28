public class EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1 == 0 || l2 == 0){
            return l2 + l1;
        }
        int[][] distances = new int[l1 + 1][l2 + 1];
        for (int i=0;i<=l1;i++){distances[i][0]=i;}
        for (int i=0;i<=l2;i++){distances[0][i]=i;}

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++){
                distances[i][j] = Math.min(distances[i-1][j],distances[i][j-1]) + 1;
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    if(distances[i][j] > distances[i-1][j-1] ) {
                        distances[i][j] = distances[i-1][j-1];
                    }
                } else if(distances[i][j] > distances[i-1][j-1] +1 ) {
                    distances[i][j] = distances[i-1][j-1] + 1;
                }

            }
        }
        return distances[l1][l2];
    }

    public static void main(String []args) {
        int minDistance = (new EditDistance()).minDistance("ab","bc");
        System.out.println(minDistance);
    }

}
