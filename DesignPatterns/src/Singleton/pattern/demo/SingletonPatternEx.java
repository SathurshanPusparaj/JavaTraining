package Singleton.pattern.demo;

class MakeCaptain{
    private static MakeCaptain captain;

    private MakeCaptain(){} // make the constructor private to make not to create the instance

    public static MakeCaptain getInstance(){

        //Lazy initialization
        if(captain==null){
            captain = new MakeCaptain();
            System.out.println("MakeCaptain Instance is created...");
        }else{
            System.out.println("You already created the MakeCaptain Instance.");
        }
        return captain;
    }
}


public class SingletonPatternEx {
    public static void main(String[] args) {
        System.out.println("---Singleton Pattern Demo---");
        System.out.println("Trying to make captain object");
        MakeCaptain _captain = MakeCaptain.getInstance();

        System.out.println("Trying to make another captain object");
        MakeCaptain _captain1 = MakeCaptain.getInstance();

        if(_captain==_captain1){
            System.out.println("_captain and _captain1 both are same instance");
        }
    }
}
