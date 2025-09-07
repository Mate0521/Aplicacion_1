package com.example.aplicacion_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BasesActivity extends AppCompatActivity {

    private EditText numero;
    private TextView txt_res;
    private Button btn_bin,btn_octa, btn_hexa;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bases);

        //recibe
        numero=findViewById(R.id.numero);
        txt_res=findViewById(R.id.txt_res);
        btn_bin=findViewById(R.id.btn_bin);
        btn_hexa=findViewById(R.id.btn_hexa);
        btn_octa=findViewById(R.id.btn_octa);

        btn_bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir(1);
            }
        });

        btn_octa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir(2);
            }
        });

        btn_hexa.setOnClickListener( new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 convertir(3);
             }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void convertir(int a){
        int valor = Integer.parseInt(numero.getText().toString());
        if(numero.getText().toString().isEmpty()) {
            numero.setText("Error");
        }else{
            try {
                int res = 0;
                switch (a){
                    case 1:
                        txt_res.setText("");
                        res = valor == 0 ? 0 : convBin(valor);
                        txt_res.setText("Convertido a binario: "+ res);
                        break;
                    case 2:
                        txt_res.setText("");
                        res = valor == 0 ? 0 : convOct(valor);
                        txt_res.setText("Convertido a Octal: " + res);
                        break;
                    case 3:
                        txt_res.setText("");
                        txt_res.setText("Convertido a Hexadecimal: " + (valor == 0 ? 0 : convHexa(valor)));
                        break;
                }
            }catch (Exception e) {
                txt_res.setText("Error: " + e);
            }
        }
    }

    public int convBin(int numero)
    {
        StringBuilder binario = new StringBuilder();
        while (numero > 0) {
            int residuo = numero % 2;
            binario.insert(0, residuo);
            numero = numero / 2;
        }
        return Integer.parseInt(binario.toString());
    }

    public int convOct(int numero)
    {
        StringBuilder Octal = new StringBuilder();
        while (numero > 0)
        {
            int residuo = numero % 8;
            Octal.insert(0, residuo);
            numero = numero / 8;
        }

        return Integer.parseInt(Octal.toString());
    }

    public String convHexa(int numero)
    {
        StringBuilder hex = new StringBuilder();
        char[] diccionario = "0123456789ABCDEF".toCharArray();

        while (numero > 0) {
            int residuo = numero % 16;
            hex.insert(0, diccionario[residuo]);
            numero = numero / 16;
        }

        return hex.toString();
    }
}
