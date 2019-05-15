package com.and.myinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaration des attributs
    EditText name;
    EditText name2;
    EditText address;
    EditText ages;
    Button quitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        //Creation des objets pour les attributs
        name = findViewById(R.id.name);
        name2 = findViewById(R.id.name2);
        address = findViewById(R.id.address);
        ages = findViewById(R.id.ages);
        quitter = findViewById(R.id.quitter);

        //recuperer les informations de l'activite precedente et les afficher dans cette activite
        Intent in = getIntent();
        name.setText(in.getStringExtra("nom"));
        name2.setText(in.getStringExtra("prenom"));
        address.setText(in.getStringExtra("adresse"));
        ages.setText(in.getStringExtra("age"));

        //redigirer le bouton quitter sur la methode Onclick
        quitter.setOnClickListener(this);

    }

    //La methode qui sera appele lors d'un clique sur le bouton quitter
    public void onClick(View V){
        System.exit(0);
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
