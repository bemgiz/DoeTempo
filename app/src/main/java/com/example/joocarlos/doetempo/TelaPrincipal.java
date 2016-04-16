package com.example.joocarlos.doetempo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class TelaPrincipal extends AppCompatActivity {


    // variaveis usadas na gravaçao de SharedPreferenc ( .ini )
    EditText userName;
    EditText userPassword;
    CheckBox userManterConectado;

    // variáveis usadas no Login com o Firebase
    EditText ed_NomeUsuario, ed_Password;
    Button bt_Login;
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

        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // controles iniciais para o Firebase
        Firebase.setAndroidContext(this);
        ref = new Firebase("https://doe-tempo.firebaseio.com/");
        PD = new ProgressDialog(this);
        PD.setMessage("Carregando ...");
        //
        ed_NomeUsuario = (EditText)findViewById(R.id.ed_NomeUsuario);
        ed_Password = (EditText)findViewById(R.id.ed_Password);
        bt_Login = (Button)findViewById(R.id.bt_Login);


        // Listener do botão de Login
        bt_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();
                final String nameusr = ed_NomeUsuario.getText().toString().toUpperCase();
                final String pass    = ed_Password.getText().toString();

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (nameusr.equals(dataSnapshot.child("usuarios").child(nameusr).child("nomeusuario").getValue()  )
                                &&pass.equals(dataSnapshot.child("usuarios").child(nameusr).child("senha").getValue())) {

                            // grava login do Usuário se estiver marcado para gravar
                            saveIni();

                            Toast.makeText(getApplicationContext(), "Usuário Logado : " + dataSnapshot.child("usuarios").child(nameusr).child("nomeusuario").getValue() +
                                                                    "  -  Tipo Usr : " + dataSnapshot.child("usuarios").child(nameusr).child("tipousuario").getValue(),
                                                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getApplicationContext(), "Dados Incorretos", Toast.LENGTH_SHORT).show();
                        }
                        PD.dismiss();
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });

        // variaveis usadas na gravaçao de SharedPreferenc ( .ini )
        userName = (EditText) findViewById(R.id.ed_NomeUsuario);
        userPassword = (EditText) findViewById(R.id.ed_Password);
        userManterConectado = (CheckBox) findViewById(R.id.cb_ManterConectado);


        //---------------------------
        // Click do botão Novousuario
        //---------------------------
        Button btnovousuario = (Button) findViewById(R.id.bt_novousuario);
        //
        btnovousuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TelaPrincipal.this, TipoDeCadastro.class);
                startActivity(intent);
                finish();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    // grava dados de Sharedpreferences( .ini )
    public void saveIni() {
        SharedPreferences SharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = SharedPreferences.edit();
        editor.putString("userName", userName.getText().toString());
        editor.putString("password", userPassword.getText().toString());
        //
        if (userManterConectado.isChecked()){
            editor.putBoolean("ManterConectado", true);
        }
        else {
            editor.putBoolean("ManterConectado", false);
        }
        editor.commit();
    }

    // carrega dados de Sharedpreferences( .ini )
    public void loadIni() {
        SharedPreferences SharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String usrName = SharedPreferences.getString("userName", "");
        String usrPassword = SharedPreferences.getString("password", "");
        Boolean usrConectado = SharedPreferences.getBoolean("ManterConectado", false);
        //
        //
        // Se está marcado para ManterConectado, carrega dados salvos
        if (usrConectado == true) {
            userName.setText(usrName);
            userPassword.setText(usrPassword);
            userManterConectado.setChecked(true);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TelaPrincipal Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.joocarlos.doetempo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);

        // Carrega dados do SharedPreferences ( .ini )
        loadIni();

    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TelaPrincipal Page", // TODO: Define a title for the content shown.
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

