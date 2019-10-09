public class ReverseApp {
    public static void main(String[] args) {
        int number = 562873;
        int revnum=0;

        while(number!=0){
            revnum = revnum*10+number%10;
            number = number/10;
        }

        System.out.println("The number"+number);
        System.out.println("After Reverse the result:"+revnum);
    }
}
