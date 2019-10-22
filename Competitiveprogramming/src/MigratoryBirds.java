/*
Problem No: 2

You have been asked to help study the population of birds migrating across the continent.
Each type of bird you are interested in will be identified by an integer value.
Each time a particular kind of bird is spotted, its id number will be added to your array of sightings.
You would like to be able to find out which type of bird is most common given a list of sightings.
Your task is to print the type number of that bird and if two or more types of birds are equally common, choose the type with the smallest ID number.

Sample Input
6
1 4 4 4 5 3

Sample Output
4
*/


public class MigratoryBirds {

    public static void main(String[] args) {

        int[] finalarr = new int[5];

        int[] birds = {1,2,3,4,5,4,3,2,1,3,4};

        //int[] birds ={1,4,4,4,5,5,5,5,3};

        for(int i:birds){
            finalarr[i-1] += 1;
        }

        int max = finalarr[0];

        for(int i=0;i<finalarr.length-1;i++){
            if(finalarr[i]<finalarr[i+1]){
                max=finalarr[i+1];
            }
        }

        int index = 0;

        for(int i=0;i<finalarr.length;i++) {
            if(finalarr[i]==max){
                index = i+1;
                break;
            }
        }

        System.out.println(index);

    }
}
