package nbcc.com.reciperecyclerview;

//Sam O'Brien

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class RecipeDetails extends AppCompatActivity {

    private final LinkedList<Recipe> recipes = DataProvider.getRecipes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        int position = getIntent().getIntExtra("position", 0);
        Recipe recipe = recipes.get(position);

        TextView detailTitle = findViewById(R.id.detailTitle);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView directions = findViewById(R.id.directions);
        ImageView imageView = findViewById(R.id.imageView);

        detailTitle.setText(recipe.name);
        ingredients.setText(recipe.ingredients);
        directions.setText(recipe.directions);

        getImage(recipe, imageView);
    }

    private void getImage(Recipe recipe, ImageView imageView){
        Picasso.get()
                .load(recipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
