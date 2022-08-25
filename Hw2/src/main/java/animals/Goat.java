package animals;

public class Goat extends Herbivore implements Voice, Swim {


    public Goat(String name, String voice) {
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
        System.out.println("Goat " + getName() + " swims");
    }
}

