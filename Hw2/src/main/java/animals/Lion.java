package animals;

import animals.Voice;

public class Lion extends Carnivorous implements Voice, Swim, Run {

    public Lion(String name, String voice) {
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
    public void swim() {
        System.out.println("Lion " + getName() + " swims");
    }

    @Override
    public void run() {
        System.out.println("Lion " + getName() + " runs");
    }
}
