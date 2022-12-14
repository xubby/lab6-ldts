import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{
    boolean happy = false;
    List<StringDrink> drinks;
    List<StringRecipe> recipes;

    SmartStrategy(){
        drinks = new ArrayList<>();
        recipes = new ArrayList<>();
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        happy = false;
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        happy = true;
        for (int i = 0; i < drinks.size(); i++){
            recipes.get(i).mix(drinks.get(i));
        }
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (happy) recipe.mix(drink);
        else {
            drinks.add(drink);
            recipes.add(recipe);
        }
    }
}
