import model.Kotik;

public class Application {

    public static void main(String[] args) {

        Kotik kotik1 = new Kotik("Kotka", 225);
        Kotik kotik2 = new Kotik();
        kotik2.setKotik(77, "Kosh", 5, "Meowww");

        kotik1.liveAnotherDay();
        kotik1.setMeow("Mrrr");//с null сравнить нельзя, ошибка
        kotik2.getMeow();

        if (kotik1.getMeow().equals(kotik2.getMeow())) {
            System.out.println("Мяукают одинаково");
        } else {
            System.out.println("Мяукают по-разному");
        }

        System.out.println("Мои коты: " + Kotik.number);
    }


}


