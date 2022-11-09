package com.example.chipgroupexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chipgroupexample.databinding.ChipAdapterLayoutBinding;

import java.util.ArrayList;

public class ChipRecyclerAdapter extends RecyclerView.Adapter<ChipRecyclerAdapter.ViewHolder> {
Context context;
ArrayList<String> list;
    public ChipRecyclerAdapter(Context context, ArrayList<String> list) {
    this.context=context;
    this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);

        ChipAdapterLayoutBinding binding=ChipAdapterLayoutBinding.inflate(inflater,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ChipRecyclerAdapter.ViewHolder holder, int position) {

        holder.binding.chipName.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ChipAdapterLayoutBinding binding;
        public ViewHolder(@NonNull ChipAdapterLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
