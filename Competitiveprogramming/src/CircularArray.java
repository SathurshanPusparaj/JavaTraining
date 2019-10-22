/*
Problem No:01

John Watson knows of an operation called a right circular rotation on an array of integers.
One rotation operation moves the last array element to the first position and shifts all remaining elements right one.
To test Sherlock's abilities, Watson provides Sherlock with an array of integers.
Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.*/

public class CircularArray {

    public static void main(String[] args) {
        int[] a ={3,4,5};
        int k=2;
        for(int i=a.length-1;i>a.length-k-1;i--){
            int[] b = new int[a.length];
            b[0] = a[a.length-1];
            for(int j=1;j<a.length;j++) {
                b[j] = a[j - 1];
            }
            a=b;
        }


        for(int i:a){
            System.out.println(i);
        }
    }
}
