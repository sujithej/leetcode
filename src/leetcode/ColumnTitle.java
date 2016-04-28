public class ColumnTitle {
    public String convertToTitle(int n) {
        StringBuffer reverseColumn = new StringBuffer();
        int temp = 0;
        while (n != 0) {
            temp = (n-1) % 26;
            reverseColumn.append((char)('A' + temp ));
            n = (n-1) / 26;
        }
        return reverseString(reverseColumn.toString());
    }

    public String reverseString(String str) {
        StringBuffer ans = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            ans = ans.append(String.valueOf(str.charAt(i)));
        }
        return ans.toString();

    }

    public static void main(String []args) {
        System.out.println((new ColumnTitle()).convertToTitle(28));
    }
}
