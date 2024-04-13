// Required import statements
import java.util.*;

public class Main {

    // Base class Animal is declared here
    public abstract class Animal {
        String name;
        int age;

        // Constructor for the Animal class
        public Animal(String name, int age) {
            // WRITE CODE HERE
            this.name = name;
            this.age = age;
        }

        // Getter and Setter for 'name' and 'age' fields
        // WRITE CODE HERE
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        // toString method for the Animal class
        public String toString() {
            // WRITE CODE HERE
            return String.format("name: %s, age: %d", name, age);
        }
    }

    // Class Lion which extends Animal
    public class Lion extends Animal {
        private String sounds;

        // Constructor for the Lion class
        public Lion(String name, int age) {
            super(name, age);
            // WRITE CODE HERE
        }

        // Method roar for the Lion class
        public String roar() {
           // WRITE CODE HERE
            return "roar!";
        }

        public String toString() {
            return super.toString() + ", " + roar();
        }
    }

    // Class Fish which extends Animal
    public class Fish extends Animal {

        // Constructor for the Fish class
        public Fish(String name, int age) {
            super(name, age);
            // WRITE CODE HERE
        }

        // Method swim for the Fish class
        public String swim() {
           // WRITE CODE HERE
            return "swim!";
        }

        public String toString() {
            return super.toString() + ", " + swim();
        }
    }

    // Function to simulate the Zoo depending on the input type and age
    public String simulateZoo(String animalType, int age) {
        // WRITE CODE HERE
        if (animalType == null) {
            return "the animal type equals to null! Try again.";
        } else if (animalType.equalsIgnoreCase("lion")) {
            Lion lion = new Lion("Simba",age);
            return lion.toString();
        } else if (animalType.equalsIgnoreCase("fish")) {
            Fish fish = new Fish("Nemo",age);
            return fish.toString();
        } else {
            return "the animal type out of possible options! Try again.";
        }
    } 

    // Main method
    public static void main(String[] args) {
        Main zooSimulation = new Main();
        Scanner scan = new Scanner(System.in);
        String animalType = scan.next(); // This will get the animal type from an input
        int age = scan.nextInt(); // This will get the age from an input
        // Call 'simulateZoo()' with 'animalType' and 'age' and print the result
        System.out.println(zooSimulation.simulateZoo(animalType, age));
        scan.close();
    }
}
