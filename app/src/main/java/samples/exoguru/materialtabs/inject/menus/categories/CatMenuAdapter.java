package samples.exoguru.materialtabs.inject.menus.categories;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import samples.exoguru.materialtabs.ProductMenuActivity;
import samples.exoguru.materialtabs.R;
import samples.exoguru.materialtabs.inject.Holder;
import samples.exoguru.materialtabs.inject.api.Categories.CatModel;
import samples.exoguru.materialtabs.inject.menus.ClickListener;

/**
 * Created by TAE on 09/04/2016.
 */
public class CatMenuAdapter extends RecyclerView.Adapter<CatMenuAdapter.ViewHolder> {
    protected CatModel model;
    private static Context context;
    private int row;
    private Activity activity;

    public CatMenuAdapter(Context cont, int RowValue, CatModel Cat) {
        this.context = cont;
        this.row = RowValue;
        this.model = Cat;
    }

    @Override
    public int getItemCount() {
        return model == null ? 0 : model.getListing().size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cat.setText(model.getListing().get(position).getName());

        holder.setClickListener(new ClickListener() {
            @Override
            public void CatonClick(View view, int position, boolean isLongClick) {
               // ProductSet productSet = new ProductSet();
                // productSet.setId(model.getListing().get(position).getCategoryId());

                Log.d("Catclick", "onBindViewHolder");
                Toast.makeText(context, "#" + position + " - " + model.getListing().get(position).getName()
                        + " (Long click)", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProductMenuActivity.class);
                Holder storeContext = new Holder();
                storeContext.setCont(context);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.cat_menu_layout, parent, false);
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView cat;
        private ClickListener clickListener;
        private int item;
        public ViewHolder(View v) {
            super(v);
            this.cat = (TextView) itemView.findViewById(R.id.tv_catLabel);
            context = itemView.getContext();
            item = getPosition();
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ClickListener clickListener) {
            this.clickListener = clickListener;
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.CatonClick(v, getPosition(), false);
            return false;
        }

        @Override
        public void onClick(View v) {
            clickListener.CatonClick(v, getPosition(), true);
        }
    }
}

