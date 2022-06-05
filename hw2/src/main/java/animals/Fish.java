package animals;

import animals.Swim;

public class Fish extends Herbivore implements Swim {

    public Fish(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void swim() {
        System.out.println("Fish," + getName() + "swims!");
    }
}
