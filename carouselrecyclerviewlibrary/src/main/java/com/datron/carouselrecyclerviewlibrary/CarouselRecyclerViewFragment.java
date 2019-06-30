package com.datron.carouselrecyclerviewlibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Datron on 28-Jun-19.
 */
public class CarouselRecyclerViewFragment<T> extends Fragment {

    private ImageButton next,previous;
    private CarouselRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] headers;
    private int mPosition;
    private TextView dayTextView;
    private RecyclerView recyclerView;
    private List<T> dataItems;

    public void init(CarouselRecyclerAdapter mAdapter, RecyclerView.LayoutManager layoutManager,
                     String[] headers,List<T> dataItems){
        this.mAdapter = mAdapter;
        this.headers = headers;
        this.mLayoutManager = layoutManager;
        mPosition = 0;
        this.dataItems = dataItems;
        this.mAdapter.setDataSource(this.dataItems.get(0));
    }

    public CarouselRecyclerAdapter getAdapter(){ return mAdapter; }

    public void setAdapter(CarouselRecyclerAdapter newAdapter){
        mAdapter = newAdapter;
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    public List<T> getDataItems(){ return dataItems; }

    public void setDataItems(List<T> items) { this.dataItems = items; }

    public void next(T dataSource){
        dayTextView.setText(headers[++mPosition]);
        mAdapter.setDataSource(dataSource);
        mAdapter.notifyDataSetChanged();
    }
    public void previous(T dataSource){
        if (mPosition != 0) {
            dayTextView.setText(headers[--mPosition]);
            mAdapter.setDataSource(dataSource);
            mAdapter.notifyDataSetChanged();
        }
    }
    public void changeHeaders(String[] newHeaders){
        headers = newHeaders;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.carousel_fragment, container, false);
        next = rootView.findViewById(R.id.day_next);
        previous = rootView.findViewById(R.id.day_prev);
        dayTextView = rootView.findViewById(R.id.day_shower);
        dayTextView.setText(headers[0]);
        recyclerView = rootView.findViewById(R.id.time_table_recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        next.setOnClickListener((view)->{
            if (mPosition+1 == dataItems.size())
                mPosition = -1;
            next(dataItems.get(mPosition+1));
        });
        previous.setOnClickListener((view)->{
            if (mPosition - 1 == -1)
                mPosition = dataItems.size();
            previous(dataItems.get(mPosition - 1));
        });
        return rootView;
    }

    public void changeLayout(RecyclerView.LayoutManager layoutManager){
        mLayoutManager = layoutManager;
        recyclerView.setLayoutManager(layoutManager);
    }
}
