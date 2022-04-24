package model;

public class Kotik {
    private String name, action, meow;
    private int satiety, weight, prettiness;
    public static int number;

// Constructor

    public Kotik() {
        number++;
    }

    public Kotik(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
        number++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    //Getters & setters


    public String getMeow() {
        return meow;
    }

    public void setMeow(String meow) {
        this.meow = meow;
    }


    public void getSatiety() {
        System.out.println(satiety);
    }

    public void setSatiety(int s) {
        satiety = s;
    }

    public void getName() {
        System.out.println(name);
    }

    public void setName(String name1) {
        name = name1;
    }

    //Methods

    public boolean Play() {
        action = " Котик играет";
        satiety--;
        hungryCat();
        return false;
    }

    public boolean Clean() {
        action = " Котик моется ";
        satiety--;
        hungryCat();
        return false;
    }

    public boolean ChaseMouse() {
        action = " Котик охотится на мышь";
        satiety--;
        hungryCat();
        return false;
    }

    public boolean Run() {
        action = " Котик делает ТыгЫдЫг";
        satiety--;
        hungryCat();
        return false;
    }

    public boolean Sleep() {
        action = " Котик свернулся в клубок и спит";
        satiety--;
        hungryCat();
        return false;
    }

    void eat(int satiety) {
        this.satiety += satiety;
    }

    void eat(int satiety, String foodName) {
        this.satiety += satiety;
    }

    void eat() {
        this.eat(2, "Felix");
    }

    private void hungryCat() {
        if (satiety <= 0) {
            System.out.println(" Я голоден, корми!");
        } else {
            System.out.println(action);
            satiety -= 1;
        }
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            System.out.print(i + 1 + " ");
            switch ((int) (Math.random() * 5 + 1)) {
                case 1:
                    Play();
                    break;
                case 2:
                    Clean();
                    break;
                case 3:
                    ChaseMouse();
                    break;
                case 4:
                    Run();
                    break;
                case 5:
                    Sleep();
                    break;

            }
        }
        if (satiety < 0) {
            System.out.println(this.name + " не прожил еще один день!" + " Вес " + this.weight);
        } else {
            System.out.println(this.name + " прожил еще один день!" + " Вес " + this.weight);
        }
    }
}

