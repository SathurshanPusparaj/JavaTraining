public class Vehicle<T extends MotorVehicle> {//any T would implicitly extend Object anyway. Explicitly defining T extends Object is completely redundant, and you could (and probably should) remove it, and just define T extends Interface.
//public class Vehicle<T extends String> String is a final object so it does not inherit other objects

    T t;

    public Vehicle(T t) {
        this.t = t;
    }

    public void drive(){
        System.out.println(t.toString()+"driving");
    }
}
