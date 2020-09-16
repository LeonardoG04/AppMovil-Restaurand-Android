package com.example.lenovo.apprestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listaDatos;
    ArrayList<Datos> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDatos=(ListView) findViewById(R.id.lvDatos);
        lista=new ArrayList<Datos>();

        lista.add(new Datos(1,"DESAYUNO VALLEJIANO","Chicharrones crocantes acompañado de rellena de cerdo doradito, " +
                "camote frito, mote, yuca, salsita criolla y una taza de café pasado.",R.drawable.desayuno));

        lista.add(new Datos(2,"PAPA RELLENA","Deliciosa Papa molida rellena de carne molida, aceituna, pasas y tricitos" +
                "de huevo duro, condimentada con el secreto del Rincon de Vallejo.",R.drawable.papa));

        lista.add(new Datos(3,"PAPA A LA HUANCAINA","Exquisita crema de aji amarillo con queso y leche, acompañado con papa" +
                "sancochada; adornada con lechuga, aceituna y huevo duro.",R.drawable.huancaina));

        lista.add(new Datos(4,"PATITA EN FIAMBRE","Sabrosas patitas de cerdo preparadas con crema de aji acompañado con yuca" +
                "sancuchada y salsita de cebolla aliñada con vinagre y limón.",R.drawable.patita));

        lista.add(new Datos(5,"TALLARIN SALTADO","Fideos salteados con verduras, pollo o carne.",R.drawable.tallarin));

        lista.add(new Datos(6,"CHAUFA DE MARISCOS","Frutos del mar preparado orientalmente.",R.drawable.mariscos));

        lista.add(new Datos(7,"CUY FRITO","Crucante cuy acompañado de un delicioso ajiaco de papas con " +
                "una porcion de arroz y salsita criolla.(1/2 cuy)",R.drawable.cuy));

        lista.add(new Datos(8,"ARROZ CON PATO","Sabroso pato ablandado con cerveza negra, zanahoria y alverjas verdes, aromatizado" +
                "con cebolla de cabeza, aji amarillo y culantro.",R.drawable.pato));

        lista.add(new Datos(9,"MAZAMORRA MORADA","Deliciosa Papa molida rellena de carne molida, aceituna, pasas y tricitos" +
                "de huevo duro, condimentada con el secreto del Rincon de Vallejo.",R.drawable.mazamorra));

        lista.add(new Datos(10,"PICARONES","Dulce en forma de anillos hecho con masa de harina de trigo mezclada con zapallo, " +
                "y en ocasiones camote, bañados en miel de chancaca aromatizada..",R.drawable.picarones));

        Adaptador miadaptador=new Adaptador(getApplicationContext(),lista);
        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Datos obj=(Datos) adapterView.getItemAtPosition(i);
                Intent paso=new Intent(getApplicationContext(),DetalleActivity.class);

                paso.putExtra("objeto",(Serializable) obj);

                startActivity(paso);
            }
        });
    }
}
