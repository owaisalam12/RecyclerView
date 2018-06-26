package com.example.oalam.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    private LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    @NonNull
    @Override
    //The onCreateViewHolder method is similar to the onCreate method.
    // It inflates the item layout, and returns a view holder with the layout and the adapter.
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }
    /**
     * Sets the contents of an item at a given position in the RecyclerView.
     * Called by RecyclerView to display the data at a specificed position.
     *
     * @param holder The view holder for that position in the RecyclerView.
     * @param position The position of the item in the RecycerView.
     */
    @Override
    //onBindViewHolder method connects your data to the view holder.
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);   // Retrieve the data for that position.
        holder.wordItemView.setText(mCurrent);        // Add the data to the view holder.
    }

    public WordListAdapter(Context context,LinkedList<String> mWordList) {
       mInflater=LayoutInflater.from(context);
        this.mWordList = mWordList;
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

   class WordViewHolder extends RecyclerView.ViewHolder{
       TextView wordItemView;
       WordListAdapter mAdapter;

       public WordViewHolder(@NonNull View itemView,WordListAdapter adapter) {
           super(itemView);
            wordItemView=(TextView)itemView.findViewById(R.id.word);
           this.mAdapter = adapter;
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   // All we do here is prepend "Clicked! " to the text in the view, to verify that
                   // the correct item was clicked. The underlying data does not change.
                   wordItemView.setText ("Clicked! "+ wordItemView.getText());
               }
           });

       }
   }
}
