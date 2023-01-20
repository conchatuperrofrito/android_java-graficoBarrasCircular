package com.example.graficabarrasysircular;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class graficarBarras extends AppCompatActivity {

    int  ancho1, ancho2, ancho3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficar_barras);

        RelativeLayout Layout1 = findViewById(R.id.Layout1);
        Bundle bundle =getIntent().getExtras();
        ancho1=Integer.parseInt(bundle.getString("valor1"));
        ancho2=Integer.parseInt(bundle.getString("valor2"));
        ancho3=Integer.parseInt(bundle.getString("valor3"));
        Lienzo2 fondoBarras =new Lienzo2(this,ancho1,ancho2,ancho3);
        Layout1.addView(fondoBarras);
    }
    class Lienzo2 extends View {
        //atrubutos
        int a1,a2,a3;
        //Metodos
        public Lienzo2(Context context, int _a1, int _a2, int _a3){
            super(context);
            this.a1=_a1;
            this.a2=_a2;
            this.a3=_a3;
        }
        protected void onDraw(Canvas canvas){
            canvas.drawRGB(255,255,255);//blanco
            Paint pincel1=new Paint();
            pincel1.setARGB(255,255,0,0);//rojo
            canvas.drawRect(10,10,10+a1,160,pincel1);
            pincel1.setARGB(127,0,255,0);//VERDE
            canvas.drawRect(10,180,10+a2,330,pincel1);
            pincel1.setARGB(240,0,0,255);//azul
            canvas.drawRect(10,350,10+a3,500,pincel1);
        }

    }

}