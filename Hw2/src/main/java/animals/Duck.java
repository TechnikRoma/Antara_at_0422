package animals;

import animals.Voice;
import animals.Swim;


public class Duck extends Herbivore implements Swim, Voice, Fly {


    public Duck(String name, String voice) {
        super(name, voice);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void swim() {
        System.out.println("Duck " + getName() + " swims");
    }

    @Override
    public String getVoice() {
        return super.getVoice();
    }

    public void setVoice() {
        super.setVoice(voice);
    }

    @Override
    public void fly() {
        System.out.println("Duck " + getName() + " flying");
    }
}

