package com.example.lenovo.apprestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {

    Context contexto;
    List<Datos> listaObjetos;

    public Adaptador(Context contexto, List<Datos> listaObjetos){
        this.contexto=contexto;
        this.listaObjetos=listaObjetos;
    }

    @Override
    public int getCount() {
        return listaObjetos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaObjetos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaObjetos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista=view;

        LayoutInflater inflater=LayoutInflater.from(contexto);
        vista=inflater.inflate(R.layout.itemlistview,null);

        ImageView imagen=(ImageView) vista.findViewById(R.id.ivFotos);
        TextView titulo=(TextView) vista.findViewById(R.id.txtTitulo);
        TextView descripcion=(TextView) vista.findViewById(R.id.txtDescripcion);

        titulo.setText(listaObjetos.get(i).getTitulo().toString());
        descripcion.setText(listaObjetos.get(i).getDetalle().toString());
        imagen.setImageResource(listaObjetos.get(i).getImagen());

        return vista;
    }
}
