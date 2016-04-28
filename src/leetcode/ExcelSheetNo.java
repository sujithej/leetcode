public class ExcelSheetNo {
    public int titleToNumber(String s) {
        int length = s.length();
        if (length == 0)
            return 0;
        int column =  0;
        for (int i = 0; i < length; i++) {
            column += (s.charAt(i) - 'A' + 1)* Math.pow(26, length - 1 - i);
        }
        return column;
    }

    public static void main(String []args) {
        int column = (new ExcelSheetNo()).titleToNumber("BB");
        System.out.println(column);
    }
}
