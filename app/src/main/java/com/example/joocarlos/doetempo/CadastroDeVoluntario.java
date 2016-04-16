package com.example.joocarlos.doetempo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class CadastroDeVoluntario extends AppCompatActivity {

    // controles para uso com Firebase
    EditText edt_nameusr, edt_name, edt_mail, edt_pass, edt_datanasc, edt_telefone, edt_endereco, edt_cidade, edt_tipo;
    Button btn_signup;
    Firebase ref;
    ProgressDialog PD;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_voluntario);

        Firebase.setAndroidContext(this);
        ref = new Firebase("https://doe-tempo.firebaseio.com/");

        PD = new ProgressDialog(this);
        PD.setMessage("Carregando...");

        // Pega dados do XML e transfere para variáveis temporárias
        edt_nameusr  = (EditText) findViewById(R.id.ed_NomeUsuario);
        edt_name     = (EditText) findViewById(R.id.ed_Nome);
        edt_mail     = (EditText) findViewById(R.id.ed_Email);
        edt_pass     = (EditText) findViewById(R.id.ed_Senha);
        edt_datanasc = (EditText) findViewById(R.id.ed_DataNascimento);
        edt_telefone = (EditText) findViewById(R.id.ed_Telefone);
        edt_endereco = (EditText) findViewById(R.id.ed_Endereco);
        edt_cidade   = (EditText) findViewById(R.id.ed_Cidade);
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
                String datanasc  = edt_datanasc.getText().toString();
                String telefone  = edt_telefone.getText().toString();
                String endereco  = edt_endereco.getText().toString();
                String cidade    = edt_cidade.getText().toString();
                String edt_tipo  = "V";  // Voluntário

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

                // grava Data de Nascimento
                ref.child("usuarios").child(nameusr).child("datanascimento").setValue(datanasc, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava Data de Telefone
                ref.child("usuarios").child(nameusr).child("telefone").setValue(telefone, new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError error, Firebase firebase) {
                        if (error != null) {
                            Toast.makeText(getApplicationContext(), "try Again", Toast.LENGTH_LONG).show();
                        }
                        PD.dismiss();
                    }
                });

                // grava Data de Endereco
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
                intent.setClass(CadastroDeVoluntario.this, CadastroDeVoluntario_Pag2.class);
                startActivity(intent);
                finish();

            }

        });



                //-----------------------------------
                // Click do botão Cadastra Voluntário .. chamada anterior .. foi mudada para o firebase
                //-----------------------------------
                //Button btSegundaTela = (Button) findViewById(R.id.bt_SegundaTela);
                //btSegundaTela.setOnClickListener(new View.OnClickListener() {
                //Intent intent = new Intent();
                //intent.setClass(CadastroDeVoluntario.this, CadastroDeVoluntario_Pag2.class);
                //startActivity(intent);
                //finish();
                 // }
                //        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CadastroDeVoluntario Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.joocarlos.doetempo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CadastroDeVoluntario Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.joocarlos.doetempo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
