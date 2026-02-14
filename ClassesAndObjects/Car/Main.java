class Car{
    private String brand;
    private String model;
    private int speed;
    public Car(String brand, String model){
        this.brand = brand;
        this.model = model;
        this.speed = 0;
    }
    public void accelerate(int increment){
        speed += increment;
    }
    public void displayStatus(){
        System.out.println(brand+ " is running at speed "+ speed +"km/h.");
    }
}
public class Main{
    public static void main(String args[]){
        Car corolla = new Car("Toyota", "Corolla");
        Car mustang = new Car("Ford", "Mustang");

        corolla.accelerate(20);
        mustang.accelerate(40);

        corolla.displayStatus();
        System.out.println("----------------------");
        mustang.displayStatus();
    }
} 