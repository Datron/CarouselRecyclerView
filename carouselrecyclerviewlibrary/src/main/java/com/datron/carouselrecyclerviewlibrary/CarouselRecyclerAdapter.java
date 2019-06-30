package com.datron.carouselrecyclerviewlibrary;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Datron on 29-Jun-19.
 * @param  <VH> ViewHolder {@link RecyclerView.ViewHolder}
 *
 */
public abstract class CarouselRecyclerAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    public abstract void setDataSource(Object data);

    @NonNull
    @Override
    public abstract VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(@NonNull VH holder, int position);
}
