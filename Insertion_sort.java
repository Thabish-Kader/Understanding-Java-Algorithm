import java.lang.reflect.Array;
import java.util.Arrays;

public class Insertion_sort {
    public static void insertionSort(char [] a){
        int n =a.length;
        for(int i = 1; i<n; i++){ // index from the second character in a
            char cur = a[i]; // the current character to be inserted
            int j = i -1 ; //start comparing with cell left of i
            while ((j >=0) && (a[j] > cur)) // while a[j] is out of order with cur
                a[j+1] = a[j--]; // move a[j] right and decrement j
                a[j+1] = cur ; // this is the proper place for cur

        }

    }
    //alternative solution for insertion sort
    public void sort (int [] array){
        for (var i =1; i < array.length; i++){ //we start i from 1 as the the first element has nothing to be compared to
            var current = array[i]; // the current item is stored in variable current
            var j = i-1;
            while ((j >=0) && array[j] > current ){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;

        }
    }

    public static void main(String[] args) {
        int [] numbers = {7,3,22,1,5};
        var sorter = new Insertion_sort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
