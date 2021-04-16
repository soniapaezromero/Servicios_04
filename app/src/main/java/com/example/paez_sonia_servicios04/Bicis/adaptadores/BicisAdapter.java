package com.example.paez_sonia_servicios04.Bicis.adaptadores;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paez_sonia_servicios04.Bicis.BicisModel.Result;
import com.example.paez_sonia_servicios04.databinding.ItemViewBinding;

import java.util.ArrayList;
/**
 * @author :Sonia Páez Romero fecha: 15/03/2021
 *Adaptador del recycler view que muestra todas las estaciones
 */

public class BicisAdapter extends RecyclerView.Adapter<BicisAdapter.MyViewHolder> {
    public ArrayList<Result> listResult;

    public  BicisAdapter(){
        this.listResult = new ArrayList<>();
    }

    public void setRepos(ArrayList<Result> Result) {
        listResult = Result;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ItemViewBinding binding;//Name of the item_view.xml in camel case + "Binding"

        public MyViewHolder(ItemViewBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Get the data model based on position
        Result Result = listResult.get(position);
        holder.binding.id.setText(String.valueOf(Result.getId()));
        holder.binding.direccion.setText(Result.getTitle());


        // API 26 mínima para usar parse

    }

    @Override
    public int getItemCount() {
        return listResult.size();
    }
}

