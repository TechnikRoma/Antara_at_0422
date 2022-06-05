package food;

public class Food {

    public String foodType, foodName;
    public int foodAmount;

    public Food(int foodAmount, String foodName) {
        this.foodAmount = foodAmount;
        this.foodName = foodName;
        System.out.println("Food " + this.foodName + " amount " + this.foodAmount);

    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName() {
        this.foodName = foodName;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }
}
