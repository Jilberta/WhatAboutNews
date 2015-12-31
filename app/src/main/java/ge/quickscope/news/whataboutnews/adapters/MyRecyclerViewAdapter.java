package ge.quickscope.news.whataboutnews.adapters;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ge.quickscope.news.whataboutnews.R;

/**
 * Created by Jay on 12/31/2015.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    public MyRecyclerViewAdapter(List<Object> contents){
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                return new RecyclerView.ViewHolder(view){
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                return new RecyclerView.ViewHolder(view){
                };
            }
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_HEADER:
                ImageView imgView = (ImageView) holder.itemView.findViewById(R.id.imageView);
                TextView titleView = (TextView) holder.itemView.findViewById(R.id.titleView);

                Picasso.with(holder.itemView.getContext())
                        .load("http://www.sportall.ge/pictures/image31/edc0a417054c69f7d5c544ab14467db0.jpg")
                        .into(imgView);

                titleView.setText("საქართველოს რაგბის კავშირის პრეზიდენტობის პირველი კანდიდატის ვინაობა ცნობილია");

                break;
            case TYPE_CELL:
                ImageView imgView2 = (ImageView) holder.itemView.findViewById(R.id.imageView);
                TextView titleView2 = (TextView) holder.itemView.findViewById(R.id.titleView);

                Picasso.with(holder.itemView.getContext())
                        .load("http://www.sportall.ge/pictures/image31/edc0a417054c69f7d5c544ab14467db0.jpg")
                        .into(imgView2);

                titleView2.setText("საქართველოს რაგბის კავშირის პრეზიდენტობის პირველი კანდიდატის ვინაობა ცნობილია");

                break;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

}
