package excercise1;

public class Application {
    public static void main(String[] args) {
        Human human = new Man();
        human.move();

        //LamdaExperssion
        Human lamhuman = ()-> System.out.println("[Lamda]Man Moving");
        lamhuman.move();
    }
}
