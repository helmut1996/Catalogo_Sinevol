package com.helcode.catalogo_sinevol.adapter;

import android.content.Intent;
import android.graphics.Color;
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
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.RecyclerHolder> {
private List<itemList> items;
private List<itemList>originalItems;
private RecyclerItemClick itemClick;
private String URL_IMAGE="http://ferreteriaelcarpintero.com/images/productos/";

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
            holder.tvPrecio.setText("C$"+String.valueOf( item.getPrecioC()));
            holder.tvPrecio2.setText("C$"+String.valueOf( item.getPrecioC2()));
            holder.tvPrecio3.setText("C$"+String.valueOf( item.getPrecioC3()));
            holder.tvPrecio4.setText("C$"+String.valueOf( item.getPrecioC4()));
            holder.tvPrecio5.setText("C$"+String.valueOf( item.getPrecioC5()));
            holder.tvimagen.setText(item.getPresentacion());
            holder.tvunidad_medida.setText(item.getUnidad_Med());
            holder.tvcodigo.setText(item.getCodigo());
            holder.tvestado.setText(item.getEstado());
            holder.tvprecio_d.setText(String.valueOf(item.getPrecioD()));
           holder.tvprecio_d2.setText(String.valueOf(item.getPrecioD2()));
           holder.tvprecio_d3.setText(String.valueOf(item.getPrecioD3()));
           holder.tvprecio_d4.setText(String.valueOf(item.getPrecioD4()));
           holder.tvprecio_d5.setText(String.valueOf(item.getPrecioD5()));
            Picasso.get().load(URL_IMAGE+item.getImagen())
                    .error(R.drawable.error)
                    .into(holder.image);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);
            }
        });

               if (holder.tvexistencia.getText().toString()=="0"){
                   holder.tvexistencia.setVisibility(View.VISIBLE);
                   holder.tvexistencia.setText("No hay Existencia");

               }else{
                   holder.tvexistencia.setText(String.valueOf(item.getExistencia()));
                   holder.tvexistencia.setVisibility(View.GONE);
               }
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

        TextView tvNombre,tvDescripcion,tvPrecio,tvPrecio2,tvPrecio3,tvPrecio4,tvPrecio5,tvimagen,tvunidad_medida,tvcodigo,tvprecio_d,tvprecio_d2,tvprecio_d3,tvprecio_d4,tvprecio_d5,tvexistencia,tvestado;
        ImageView image;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.NombreProducto);
            tvDescripcion=itemView.findViewById(R.id.Descripcion);
            tvPrecio=itemView.findViewById(R.id.precio);
            tvPrecio2=itemView.findViewById(R.id.tvprecio2);
            tvPrecio3=itemView.findViewById(R.id.tvprecio3);
            tvPrecio4=itemView.findViewById(R.id.tvprecio4);
            tvPrecio5=itemView.findViewById(R.id.tvprecio5);
            tvimagen=itemView.findViewById(R.id.textimagen);
            image=itemView.findViewById(R.id.imagen);
            tvunidad_medida=itemView.findViewById(R.id.unidad_medida);
            tvcodigo=itemView.findViewById(R.id.CodigoProducto);
            tvprecio_d=itemView.findViewById(R.id.precio_D);
            tvprecio_d2=itemView.findViewById(R.id.tvprecioD2);
            tvprecio_d3=itemView.findViewById(R.id.tvprecioD3);
            tvprecio_d4=itemView.findViewById(R.id.tvprecioD4);
            tvprecio_d5=itemView.findViewById(R.id.tvprecioD5);
            tvexistencia =itemView.findViewById(R.id.Existencia);
            tvestado=itemView.findViewById(R.id.Estado);
        }
    }

    public interface RecyclerItemClick{
        void itemClick(itemList item);
    }
}
