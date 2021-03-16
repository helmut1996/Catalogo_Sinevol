package com.helcode.catalogo_sinevol.adapter;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helcode.catalogo_sinevol.MainDetalleProducto;
import com.helcode.catalogo_sinevol.R;
import com.helcode.catalogo_sinevol.model.itemList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.RecyclerHolder> {
private List<itemList> items;
private List<itemList>originalItems;
private RecyclerItemClick itemClick;

    public AdapterProductos(List<itemList> items,RecyclerItemClick itemClick) {
        this.items = items;
        this.itemClick=itemClick;
        this.originalItems=new ArrayList<>();
        originalItems.addAll(items);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
            final itemList item= items.get(position);
            holder.tvNombre.setText(item.getNombre());
            holder.tvDescripcion.setText(item.getMarca());
            holder.tvPrecio.setText(String.valueOf( item.getPrecioC()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);
            }
        });

            }



    @Override
    public int getItemCount() {
        return items.size();
    }


    public void filter(final String strSeach){

            if (strSeach.length()==0){
                items.clear();
                items.addAll(originalItems);
            }else{
                if (Build.VERSION.SDK_INT>Build.VERSION_CODES.N){
                    items.clear();
                    List<itemList>collect=  originalItems.stream()
                            .filter(i->i.getNombre().toLowerCase().contains(strSeach))
                            .collect(Collectors.toList());

                    items.addAll(collect);
                }
                else {
                    items.clear();
                    for (itemList i: originalItems){
                        if (i.getNombre().toLowerCase().contains(strSeach)){
                            items.add(i);
                        }
                    }
                }
            }
            notifyDataSetChanged();
    }
    public static class RecyclerHolder extends RecyclerView.ViewHolder{

        TextView tvNombre,tvDescripcion,tvPrecio;
        ImageView image;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.NombreProducto);
            tvDescripcion=itemView.findViewById(R.id.Descripcion);
            tvPrecio=itemView.findViewById(R.id.precio);
            image=itemView.findViewById(R.id.imagen);
        }
    }

    public interface RecyclerItemClick{
        void itemClick(itemList item);
    }
}
