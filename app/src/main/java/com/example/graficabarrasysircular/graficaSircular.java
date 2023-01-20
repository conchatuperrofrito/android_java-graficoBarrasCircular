package com.example.graficabarrasysircular;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class graficaSircular extends AppCompatActivity {
    int ancho1,ancho2,ancho3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica_sircular);

        RelativeLayout Layout1 = findViewById(R.id.Layout2);
        Bundle bundle =getIntent().getExtras();
        ancho1=Integer.parseInt(bundle.getString("valor1"));
        ancho2=Integer.parseInt(bundle.getString("valor2"));
        ancho3=Integer.parseInt(bundle.getString("valor3"));
        Lienzo3 fondo =new Lienzo3(this,ancho1,ancho2,ancho3);
        Layout1.addView(fondo);
    }
    class Lienzo3 extends View {
        //atrubutos
        int a1,a2,a3;
        //Metodos
        public Lienzo3(Context context, int _a1, int _a2, int _a3){
            super(context);
            this.a1=_a1;
            this.a2=_a2;
            this.a3=_a3;
        }
        protected void onDraw(Canvas canvas){
            float total=a1+a2+a3;
            canvas.drawRGB(255, 255, 255);
            Paint pincel1 = new Paint();
            pincel1.setARGB(255, 255, 0, 0);
//parte 1
            float angulo1=(a1*360)/total;
            canvas.drawArc(70,70,700,700,0,angulo1,true,pincel1);
            pincel1.setTextSize(40);
            pincel1.setTypeface(Typeface.SERIF);
//Leyenda 1
            canvas.drawRect(720,560,760,600,pincel1);
            canvas.drawText("Valor 1",780,600,pincel1);
//parte 2
            float angulo2=(a2*360)/total;
            pincel1.setARGB(127, 0, 255, 0);
            canvas.drawArc(70,70,700,700,angulo1,angulo1+angulo2,true,pincel1);
//Leyenda 2
            canvas.drawRect(720,620,760,660,pincel1);
            canvas.drawText("Valor 2",780,660,pincel1);
//parte 3
            float angulo3=(a3*360)/total;
            pincel1.setARGB(240, 248, 255, 0);
            canvas.drawArc(70,70,700,700,angulo1+angulo2,angulo3,true,pincel1);
//Leyenda 3
            canvas.drawRect(720,680,760,720,pincel1);
            canvas.drawText("Valor 3",780,720,pincel1);
        }

    }
}