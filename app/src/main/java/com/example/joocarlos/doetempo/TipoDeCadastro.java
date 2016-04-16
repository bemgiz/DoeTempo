package com.example.joocarlos.doetempo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipoDeCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_cadastro);


        //-----------------------------------
        // Click do botão Cadastra Voluntário
        //-----------------------------------
        Button btcadastravoluntario = (Button) findViewById(R.id.bt_CadastraVoluntario);
        btcadastravoluntario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TipoDeCadastro.this, CadastroDeVoluntario.class);
                startActivity(intent);
                finish();
            }
        });

        //-----------------------------------
        // Click do botão Cadastra Entidade
        //-----------------------------------
        Button btcadastraentidade = (Button) findViewById(R.id.bt_CadastraEntidade);
        btcadastraentidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TipoDeCadastro.this, CadastroDeEntidade.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
