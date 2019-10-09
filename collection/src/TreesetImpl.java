/*
    TreeSet

    Naturally ordered and sorted

 */


import java.util.TreeSet;

class TreesetImpl {

    public static void main(String[] args) {

        TreeSet<Integer>  treeSet = new TreeSet<>();

        for(int i=0;i<10;i++){
            treeSet.add((int) Math.floor(Math.random()*100));
        }

        for(Integer x: treeSet) {
            System.out.println(x);
        }

    }
}
