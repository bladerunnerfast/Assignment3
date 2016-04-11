package samples.exoguru.materialtabs.inject.menus.typemenu;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import samples.exoguru.materialtabs.R;
import samples.exoguru.materialtabs.inject.api.Categories.Products.Products.ProdModel;
import samples.exoguru.materialtabs.inject.menus.ClickListener;

/**
 * Created by TAE on 09/04/2016.
 */
public class DiscriptionMenuAdapter extends RecyclerView.Adapter<DiscriptionMenuAdapter.ViewHolder> {
    protected ProdModel model;
    private Context context;
    private int row;

    public DiscriptionMenuAdapter(Context cont, int RowValue, ProdModel mod){
        this.context = cont;
        this.row = RowValue;
        this. model = mod;
    }

    @Override
    public int getItemCount()
    {return model == null? 0:  model.getListings().size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cost.setText(model.getListings().get(position).getCurrentPrice());
        Picasso.with(context)
                .load(model.getListings().get(position).getProductImageUrl().get(position))
                .into(holder.imageView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.type_frag_layout, parent, false);
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        private ImageView imageView;
        private TextView cost;
        public ViewHolder(View v){
            super(v);

            this.cost = (TextView)itemView.findViewById(R.id.tv_typeLabel);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ClickListener clickListener) {
            //this.clickListener = clickListener;
        }

        @Override
        public boolean onLongClick(View v) {
           // clickListener.CatonClick(v, getPosition(), false);
            return true;
        }

        @Override
        public void onClick(View v) {
            //clickListener.CatonClick(v, getPosition(), true);
        }

    }

}
