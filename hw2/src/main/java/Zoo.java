import animals.*;
import food.*;

public class Zoo {
    public static void main(String[] args) {

        Worker worker = new Worker("Zookeeper");
        Animal duck1 = new Duck("Duck", "Quack");
        Animal goat1 = new Goat("Zoyka", "Meee");
        Animal fish1 = new Fish("Nemo");
        Animal lion1 = new Lion("Symba", "Roar");
        Animal jackal1 = new Jackal("Shenzi", "Hyena laugh");
        Animal crocodile1 = new Crocodile("Riptale", "Hrrr");

        Food food1 = new Grass(10, "herbs");
        Food food2 = new Grass(15, "veggies");
        Food food3 = new Grass(20, "fruits");
        Food food4 = new Meat(10, "byproducts");
        Food food5 = new Meat(15, "chicken");
        Food food6 = new Meat(20, "horsemeat");

        Animal[] animals = {
                duck1,
                fish1,
                crocodile1,
                goat1,
                lion1,
                jackal1
        };

        Food[] foods = {
                food1,
                food2,
                food3,
                food4,
                food5,
                food6
        };
        Swim[] pondAnimals = new Swim[]{
                (Swim) duck1,
                (Swim) fish1,
                (Swim) goat1,
                (Swim) crocodile1,
                (Swim) lion1,
                (Swim) jackal1,
        };


        worker.getVoice(animals);
        worker.pond(pondAnimals);
        worker.feed(animals, foods);
    }


}
