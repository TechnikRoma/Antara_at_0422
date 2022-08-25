package animals;

import food.Food;
import food.Grass;

public class Herbivore extends Animal {
    public Herbivore(String name, String voice) {
        super(name, voice);
    }

    public Herbivore(String name) {
        super(name);
    }

    @Override
    public Boolean eat(Food food) {
        if (food instanceof Grass) {
            return true;
        } else {
            System.out.println(this.name + " is Herbivore. It only eats herbs!");
            return false;
        }
    }
}
