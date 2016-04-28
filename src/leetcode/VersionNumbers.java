public class VersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < arr1.length && i < arr2.length; i++) {
            if(Integer.parseInt(arr1[i]) != Integer.parseInt(arr2[i])) {
                if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        if(arr1.length == arr2.length) {
            return 0;
        } else if(arr1.length > arr2.length) {
            for(int i =  arr2.length ; i < arr1.length ; i++ ){
                if(Integer.parseInt(arr1[i]) != 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            for(int i = arr1.length ; i < arr2.length ; i++ ){
                if(Integer.parseInt(arr2[i]) != 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static void main(String []args) {
        System.out.println((new VersionNumbers()).compareVersion("01.0", "1"));
    }
}
