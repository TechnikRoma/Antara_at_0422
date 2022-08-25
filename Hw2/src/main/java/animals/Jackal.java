package animals;

import animals.Run;

public class Jackal extends Carnivorous implements Voice, Run, Swim {

    public Jackal(String name, String voice) {
        super(name, voice);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getVoice() {
        return super.getVoice();
    }

    public void setVoice() {
        super.setVoice(voice);
    }

    @Override
    public void run() {
        System.out.println("Jackal " + getName() + " runs");
    }

    @Override
    public void swim() {
        System.out.println("Jackal " + getName() + " swims!");
    }
}
