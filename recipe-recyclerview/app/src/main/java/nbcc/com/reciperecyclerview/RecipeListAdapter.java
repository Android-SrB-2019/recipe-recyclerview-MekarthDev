package nbcc.com.reciperecyclerview;

//Sam O'Brien

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> recipeList;
    private LayoutInflater inflater;
    private Context context;

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView recipeTitleView;
        final TextView recipeDescriptionView;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleView = itemView.findViewById(R.id.title);
            recipeDescriptionView = itemView.findViewById(R.id.description);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, RecipeDetails.class);
            intent.putExtra("position", getAdapterPosition());
            view.getContext().startActivity(intent);
        }
    }

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        inflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.recipe_item, viewGroup, false);
        return new RecipeViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder recipeViewHolder, int i) {
        Recipe current = recipeList.get(i);
        recipeViewHolder.recipeTitleView.setText(current.name);
        recipeViewHolder.recipeDescriptionView.setText(current.description);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
