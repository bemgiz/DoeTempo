package com.example.joocarlos.doetempo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroDeVoluntario_Pag2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_voluntario__pag2);

        //-----------------------------------
        // Click do botão Voltar Tela
        //-----------------------------------
        Button btVoltarTela = (Button) findViewById(R.id.bt_VoltarTela);
        btVoltarTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CadastroDeVoluntario_Pag2.this, CadastroDeVoluntario.class);
                startActivity(intent);
                finish();
            }
        });


        //-----------------------------------
        // Click do botão Gravar
        //-----------------------------------
        Button btGravar = (Button) findViewById(R.id.bt_Gravar);
        btGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CadastroDeVoluntario_Pag2.this, AtividadesDoVoluntario.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
