package com.helcode.catalogo_sinevol.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helcode.catalogo_sinevol.R;
import com.helcode.catalogo_sinevol.model.itemList;

import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.RecyclerHolder> {
private List<itemList> items;

    public AdapterProductos(List<itemList> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        holder.tvNombre.setText(items.get(position).getNombre());
        holder.tvDescripcion.setText(items.get(position).getDescripcion());
        holder.tvPrecio.setText(String.valueOf(items.get(position).getPrecio()));
        holder.image.setImageResource(items.get(position).getImgResouce());
    }

    @Override
    public int getItemCount() {
        return items.size();
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
}
