package de.andreasschrade.androidtemplate.ui.quote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.andreasschrade.androidtemplate.R;
import de.andreasschrade.androidtemplate.dummy.Event;

/**
 * Created by geekulcha on 10/17/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    public TextView title, author;
    private List<Event> List;
    private Event event;
    private ImageView photo;
    private Context context;

    public EventAdapter() {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, author;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.article_title);
            author = (TextView) view.findViewById(R.id.article_subtitle);
            photo = (ImageView) view.findViewById(R.id.thumbnail);

        }


    }

    public EventAdapter(List<Event> List) {
        this.List = List;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_article, parent, false);
        context = parent.getContext();


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Event e = List.get(position);
        holder.title.setText(e.getTitle());
        holder.author.setText(e.getAuthor());
        String img = e.getPhoto();

        Glide.with(context)
                .load(img)
                .into(photo);


    }


    @Override
    public int getItemCount() {
        return List.size();
    }

}
