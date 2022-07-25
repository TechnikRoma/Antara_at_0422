import animals.Animal;
import food.Food;
import animals.Swim;

public class Worker {
    private String name;
    private int age;

    public Worker(String name) {
        this.name = name;
    }

    void feed(Animal[] animals, Food[] foods) {
        System.out.println(this.name + " feeds animals ");
        for (Animal a : animals) {
            for (Food f : foods) {
                if (a.eat(f)) {
                    System.out.println(a.getClass().getSimpleName() + " " + a.getName() + " eats " + f.getFoodName());

                }
            }
        }
        System.out.println();
    }

    public void pond(Swim[] animals) {
        System.out.println("Pond is open:");

        for (Swim a : animals) {
            a.swim();
        }
        System.out.println();
    }

    public void getVoice(Animal[] animals) {
        System.out.println(this.name + " asked the animals to make a sound !");
        for (Animal a : animals) {
            if (a.getClass().getSimpleName().equals("Fish")) {
                continue;
            } else {
                System.out.println(a.getClass().getSimpleName() + " " + a.getName() + " says - " + a.getVoice());
            }
        }
        System.out.println();
    }

}
