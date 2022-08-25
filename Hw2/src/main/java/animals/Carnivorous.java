package animals;

import food.Food;
import food.Meat;

public class Carnivorous extends Animal {
    public Carnivorous(String name, String voice) {
        super(name, voice);
    }

    @Override
    public Boolean eat(Food food) {
        if (food instanceof Meat) {
            return true;
        } else {
            System.out.println(this.name + " is Carnivorous. It only eats meat!");
            return false;
        }
    }
}
