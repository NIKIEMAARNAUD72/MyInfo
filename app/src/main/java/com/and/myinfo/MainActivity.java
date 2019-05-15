
package com.and.myinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Déclaration des attributs
    EditText user;
    EditText pwd;
    Button connecter;
    CheckBox afficher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creation des objets pour les attributs
        user = findViewById(R.id.user);
        pwd = findViewById(R.id.pwd);
        connecter = findViewById(R.id.connecter);
        afficher = findViewById(R.id.afficher);

        //Redirige le clic du bouton register sur la méthode OnClick
        connecter.setOnClickListener(this);

        //afficher le mot de passe a partir du checkbox afficher
        afficher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }}});

    }

    //Méthode qui sera appelée lors d'un clic sur le bouton connecter
    public void onClick(View V) {

        if (user.getText().toString().isEmpty() && pwd.getText().toString().isEmpty()){
            Toast.makeText(this, "Le nom d'utilisateur ou mot de passe est vide", Toast.LENGTH_SHORT).show();
        } else if(!(user.getText().toString().equalsIgnoreCase("info") && pwd.getText().toString().equalsIgnoreCase("info"))){
            Toast.makeText(this, "Le nom d'utilisateur ou mot de passe est incorrect", Toast.LENGTH_SHORT).show();
        }

        if (user.getText().toString().equalsIgnoreCase("info") && pwd.getText().toString().equalsIgnoreCase("info")){
            Toast.makeText(this, "Nom d'utilisateur et mot de passe corrects", Toast.LENGTH_SHORT).show();
            Intent i = new Intent();
            i.setClass(this, RegisterActivity.class);
            startActivity(i);
            finish();
        }

    }


    //les autree methodes du cycle de vie d'une activite
    @Override
    protected void onStart(){
      super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}