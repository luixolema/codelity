public class Solutions {
    public int binarySearch(int[] a, int value){
        int start = 0;
        int end = a.length -1;
        int middle = (start + end) /2;

        while (start <= end){
            if ( value > a[middle]){
                start = middle+1;
            }else if(value == a[middle]){
                return  middle;
            }else{
                end = middle - 1;
            }
            middle = (start + end) /2;
        }

        return -1;
    }
}
