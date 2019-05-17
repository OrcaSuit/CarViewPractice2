package com.example.cardviewproject2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;
        private ArrayList<MyData> myDataset;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            mRecyclerView.setHasFixedSize(true);

            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            myDataset = new ArrayList<>();
            mAdapter = new MyAdapter(myDataset);
            mRecyclerView.setAdapter(mAdapter);

            myDataset.add(new MyData("#InsideOut", R.mipmap.insideout));
            myDataset.add(new MyData("#Mini", R.mipmap.mini));
            myDataset.add(new MyData("#ToyStroy", R.mipmap.toystory));
        }

        class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
            private ArrayList<MyData> mDataset;

            public class ViewHolder extends RecyclerView.ViewHolder {
                public ImageView mImageView;
                public TextView mTextView;

                public ViewHolder(View view) {
                    super(view);
                    mImageView = (ImageView) view.findViewById(R.id.image);
                    mTextView = (TextView) view.findViewById(R.id.textview);
                }
            }

                public MyAdapter(ArrayList<MyData> myDataset) {
                    mDataset = myDataset;
                }

                public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card, parent, false);

                    ViewHolder vh = new ViewHolder(v);
                    return vh;
                }

                public void onBindViewHolder(ViewHolder holder, int position) {
                    holder.mTextView.setText(mDataset.get(position).text);
                    holder.mImageView.setImageResource(mDataset.get(position).img);
                }

                public int getItemCount() {
                    return mDataset.size();
                }
            }
        class MyData {
            public String text;
            public int img;

            public MyData(String text, int img) {
                this.text = text;
                this.img = img;
            }
        }
    }




