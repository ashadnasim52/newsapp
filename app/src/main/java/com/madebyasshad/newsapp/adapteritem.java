package com.madebyasshad.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapteritem extends RecyclerView.Adapter<adapteritem.exampleviewholder> {
    private ArrayList<itemcalss> arrayList;
    private Context mcontext;

    private Onitemclicklistner mlistner;


    public interface Onitemclicklistner
    {
        void onitemclick(int position);
    }

    public void setonitemclicklistner(Onitemclicklistner listner)
    {
        mlistner=listner;
    }

    public adapteritem(ArrayList<itemcalss> arrayList, Context mcontext) {
        this.arrayList = arrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public exampleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.items_card,parent,false);

        return new exampleviewholder(v);
    }

    //    @NonNull
    //    @Override
    //    public exampleviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //        View view= LayoutInflater.from(mcontext).inflate(R.layout.items,parent,false);
    //        return  new exampleviewholder(view);
    //    }


    @Override
    public void onBindViewHolder(@NonNull exampleviewholder holder, int position) {

        //  exampleitem currentitem=arrayList.get(position);
        //        String imageurl=currentitem.getImageurl();
        //        String creator=currentitem.getMcreator();
        //        int likes=currentitem.getLikes();
        //
        //        holder.mTextviewcreator.setText(creator);
        //        holder.mtextviewlikes.setText(likes);
        //        Picasso.with(mcontext).load(imageurl).fit().centerInside().into(holder.mimageview);
        //    }
        itemcalss currentitem=arrayList.get(position);
        String title=currentitem.getTitle();
        //    String title, description, urltocontent, urlofimage, publishedat;
        String description=currentitem.getDescription();
        String urltocontent=currentitem.getUrltocontent();
        String urlofimmage=currentitem.getUrlofimage();
        String publishedat=currentitem.getPublishedat();
        String authorofnews=currentitem.getAuthorofnews();
        holder.titleofnews.setText(title);
        holder.contentofnews.setText(description);
        holder.authorofnews.setText("By:-"+authorofnews);
        holder.urlofnews.setText(urltocontent);
        holder.published_at.setText("date of article published\n"+publishedat);
        Picasso.with(mcontext).load(urlofimmage).fit().centerInside().into(holder.imageofnews);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class exampleviewholder extends  RecyclerView.ViewHolder
    {
        public TextView published_at;
        public TextView urlofnews;
        public TextView authorofnews;
        public TextView contentofnews;
        public TextView titleofnews;
        public ImageView imageofnews;

       public exampleviewholder(View itemview)

       {

           super(itemview);
           published_at=itemview.findViewById(R.id.published_at);
           urlofnews=itemview.findViewById(R.id.urlofnews);
           authorofnews=itemview.findViewById(R.id.authorofnews);
           contentofnews=itemview.findViewById(R.id.contentofnews);
           titleofnews=itemview.findViewById(R.id.titleofnews);
           imageofnews=itemview.findViewById(R.id.imageofnews);
           itemview.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (mlistner!=null)
                   {
                       int position=getAdapterPosition();
                       if (position!=RecyclerView.NO_POSITION)
                       {
                           mlistner.onitemclick(position);
                       }
                   }
               }
           });


       }
    }
}
