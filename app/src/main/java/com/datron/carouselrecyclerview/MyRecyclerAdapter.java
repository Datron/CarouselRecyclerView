package com.datron.carouselrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.datron.carouselrecyclerviewlibrary.CarouselRecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by Datron on 29-Jun-19.
 */
public class MyRecyclerAdapter extends CarouselRecyclerAdapter<MyRecyclerAdapter.SubjectViewHolder> {
    private ArrayList<String> data;

    public MyRecyclerAdapter(ArrayList<String> data){
        this.data = data;
    }
    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_subject,
                parent,false);
        SubjectViewHolder viewHolder = new SubjectViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        String item = data.get(position);
        String[] items = item.split(";");
        holder.mTiming.setText(items[1]);
        holder.mRoom.setText(items[0]);
        holder.mSubjectName.setText(items[2]);
        holder.mFaculty.setText(items[3]);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void setDataSource(Object data) {
        this.data = (ArrayList<String>) data;
    }

    public static class SubjectViewHolder extends RecyclerView.ViewHolder {
        public TextView mTiming;
        public TextView mSubjectName;
        public TextView mFaculty;
        public TextView mRoom;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            mTiming = itemView.findViewById(R.id.subject_time);
            mSubjectName = itemView.findViewById(R.id.subject_name);
            mFaculty = itemView.findViewById(R.id.subject_prof);
            mRoom = itemView.findViewById(R.id.subject_room);
        }

    }
}
