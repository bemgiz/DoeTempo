package com.example.joocarlos.doetempo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class CadastroDeEntidade extends AppCompatActivity {

    // controles para uso com Firebase
    EditText edt_nameusr, edt_name, edt_mail, edt_pass, edt_responsavel, edt_datanasc, edt_telefone, edt_endereco, edt_cidade, edt_tipo;
    Button btn_signup;
    Firebase ref;
    ProgressDialog PD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_entidade);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://doe-tempo.firebaseio.com/");

        PD = new ProgressDialog(this);
        PD.setMessage("Carregando...");

        // Pega dados do XML e transfere para variáveis temporárias
        edt_nameusr     = (EditText) findViewById(R.id.ed_NomeUsuario);
        edt_name        = (EditText) findViewById(R.id.ed_Nome);
        edt_mail        = (EditText) findViewById(R.id.ed_Email);
        edt_pass        = (EditText) findViewById(R.id.ed_Senha);
        edt_responsavel = (EditText) findViewById(R.id.ed_Responsavel);
        edt_datanasc    = (EditText) findViewById(R.id.ed_DataNascimento);
        edt_telefone    = (EditText) findViewById(R.id.ed_Telefone);
        edt_endereco    = (EditText) findViewById(R.id.ed_Endereco);
        edt_cidade      = (EditText) findViewById(R.id.ed_Cidade);
        //
        btn_signup = (Button) findViewById(R.id.bt_SegundaTela);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PD.show();
                String nameusr   = edt_nameusr.getText().toString().toUpperCase();
                String name      = edt_name.getText().toString();
                String email     = edt_mail.getText().toString();
                String pass      = edt_pass.getText().toString();
                String respons   = edt_responsavel.getText().toString();
                String telefone  = edt_telefone.getText().toString();
                String endereco  = edt_endereco.getText().toString();
                String cidade    = edt_cidade.getText().toString();
                String edt_tipo  = "E";  // Entidade


                // grava nome de usuário
                ref.child("usuarios").child(nameusr).child("nomeusuario").setValue(nameusr, new Firebase.CompletionListener() {

                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava tipo de usuário
                ref.child("usuarios").child(nameusr).child("tipousuario").setValue(edt_tipo, new Firebase.CompletionListener() {

                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava nome
                ref.child("usuarios").child(nameusr).child("nome").setValue(name, new Firebase.CompletionListener() {

                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava e-mail
                ref.child("usuarios").child(nameusr).child("email").setValue(email, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava senha
                ref.child("usuarios").child(nameusr).child("senha").setValue(pass, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava Responsável
                ref.child("usuarios").child(nameusr).child("responsavel").setValue(respons, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava Telefone
                ref.child("usuarios").child(nameusr).child("telefone").setValue(telefone, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava Endereco
                ref.child("usuarios").child(nameusr).child("endereco").setValue(endereco, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava Cidade
                ref.child("usuarios").child(nameusr).child("cidade").setValue(cidade, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });


                // Chama a segunda tela do Cadastro de voluntários
                Intent intent = new Intent();
                intent.setClass(CadastroDeEntidade.this, CadastroDeEntidade_Pag2.class);
                startActivity(intent);
                finish();

            }

        });

        /*
        //-----------------------------------
        // Click do botão Cadastra Voluntário
        //-----------------------------------
        Button btSegundaTela = (Button) findViewById(R.id.bt_SegundaTela);
        btSegundaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(CadastroDeEntidade.this, CadastroDeEntidade_Pag2.class);
                startActivity(intent);
                finish();
            }
        });
        */

    }
}
