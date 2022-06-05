package animals;

import food.Food;

public abstract class Animal {
    protected String name;
    protected String voice;

    public Animal(String name, String voice) {
        this.voice = voice;
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public String voice() {
        return this.voice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }


    public Boolean eat(Food food) {
        ;
        if ((this instanceof Carnivorous && food instanceof food.Meat) || (this instanceof Herbivore && food instanceof food.Grass)) {
            return true;
        } else return false;
    }


}
