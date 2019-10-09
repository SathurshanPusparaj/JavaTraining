package excersice3;

public class Application {
    public static void main(String[] args) {
        //Anonymous inner class
        Mathx m = new Mathx(){
            public int power(int x){
                return x*x;
            }
        };
        System.out.println("Anonymous inner class power:"+m.power(4));

        //Lamda expression
        Mathx powermath = x->x*x;
        System.out.println("Lamda power"+powermath.power(5));
    }
}
