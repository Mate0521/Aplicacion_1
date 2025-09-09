package com.example.aplicacion_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MonedaActivity extends AppCompatActivity {

    private Spinner spin_moneda;
    private EditText valor_1;
    private Button btn_conver_moneda;
    private TextView txt_res_moneda;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneda);

        spin_moneda=findViewById(R.id.spin_moneda);
        valor_1=findViewById(R.id.valor_1);
        btn_conver_moneda=findViewById(R.id.btn_conver_moneda);
        txt_res_moneda=findViewById(R.id.txt_res_moneda);

        llenarSpin();

        btn_conver_moneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                direccionar();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void llenarSpin(){

        ArrayList<String> divisas= new ArrayList<>();

        divisas.add("Dolar Estadounidense");
        divisas.add("Euro");
        divisas.add("Fanco suizo");
        divisas.add("Yen");
        divisas.add("Soles");
        divisas.add("Libra Esterlina");
        divisas.add("Dolar Canadiense");
        divisas.add("Riyal Catari");
        divisas.add("Real Brazileño");
        divisas.add("Peso Mexicano");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, divisas);
        spin_moneda.setAdapter(adapter);


    }
    private void direccionar(){

        String opcion= (String) spin_moneda.getSelectedItem();
        long valor= Long.parseLong(valor_1.getText().toString());
        Toast.makeText(this,opcion, Toast.LENGTH_SHORT).show();
        txt_res_moneda.setText(opcion);

        switch (opcion){

            case "Dolar Estadounidense":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.00025));
                break;

            case "Euro":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.00021));
                break;

            case "Fanco suizo":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.00020));
                break;

            case "Yen":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.037));
                break;

            case "Soles":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.00088));
                break;

            case "Libra Esterlina":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.00018));
                break;

            case "Dolar Canadiense":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.00035));
                break;

            case "Riyal Catari":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.00092));
                break;

            case "Real Brazileño":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.0014));
                break;

            case "Peso Mexicano":
                txt_res_moneda.setText(opcion + ": " + (valor * 0.0047));
                break;

            default:
                txt_res_moneda.setText("Selecciona una divisa válida");
                break;
        }

    }
}
