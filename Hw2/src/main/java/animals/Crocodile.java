package animals;

import animals.Voice;
import animals.Swim;
import animals.Run;

public class Crocodile extends Carnivorous implements Voice, Run, Swim {

    public Crocodile(String name, String voice) {
        super(name, voice);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setVoice() {
        super.setVoice(voice);
    }

    @Override
    public String getVoice() {
        return super.getVoice();
    }


    @Override
    public void swim() {
        System.out.println("Crocodile " + getName() + " swims");
    }

    @Override
    public void run() {
        System.out.println("Crocodile " + getName() + " runs");
    }
}
