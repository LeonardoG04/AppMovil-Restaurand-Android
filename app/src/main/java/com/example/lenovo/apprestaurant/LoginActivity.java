package com.example.lenovo.apprestaurant;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView tv_registrar;
    EditText et1,et2;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_registrar=(TextView) findViewById(R.id.tv_Registrar);
        et1=(EditText) findViewById(R.id.tv_usu);
        et2=(EditText) findViewById(R.id.tv_pass);

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg=new Intent(LoginActivity.this,RegistroActivity.class);
                LoginActivity.this.startActivity(intentReg);
            }
        });
    }

    public void ingresar(View v) {
        DataBase admin = new DataBase(this, "instituto", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuario = et1.getText().toString();
        String contraseña = et2.getText().toString();
        fila = db.rawQuery("select usuario, contraseña from usuario where usuario='" + usuario + "'and contraseña='" + contraseña + "'", null);
        //preguntamos si el cursor tiene algun valor almacenado
        if (fila.moveToFirst() == true) {
            //capturamos los valores del cursos y lo almacenamos en variable
            String usua = fila.getString(0);
            String pass = fila.getString(1);
            //preguntamos si los datos ingresados son iguales
            if (usuario.equals(usua) && contraseña.equals(pass)) {
                //si son iguales entonces vamos a otra ventana
                //Menu es una nueva actividad empty
                Intent ven = new Intent(this, MainActivity.class);

                startActivity(ven);
                //limpiamos las las cajas de texto
                et1.setText("");
                et2.setText("");
            } else
                Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG).show();
        }

    }
    public void salir (View v){
        finish();;
    }
}
