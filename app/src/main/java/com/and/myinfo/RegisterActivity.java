package com.and.myinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Déclaration des attributs
    EditText nom;
    EditText prenom;
    EditText adresse;
    Spinner age;
    Button register;
    Intent i = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Creation des objets pour les attributs
        nom = findViewById(R.id.name);
        prenom = findViewById(R.id.name2);
        adresse = findViewById(R.id.address);
        age = findViewById(R.id.age);
        register = findViewById(R.id.register);

        //Redirige le clic sur le bouton register sur la méthode OnClick
        register.setOnClickListener(this);

        //Boucle pour afficher les differents ages
        List<String> ages = new ArrayList<String>();
        ages.add("Age");
        for(int i=1;i<=100;i++){
            ages.add(Integer.toString(i));
        }

        //Adaptation des donnees a un tableau dynamique
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, ages);

        //Ajouter le tableau de donnes au DropDown pour les affficher
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //Associer le tableau de donnees au combobox
        age.setAdapter(dataAdapter);


        //Redirige le choix des items sur la méthode onItemSelected
        age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Les methodes qui seront appelées lors d'un clic sur le spinner
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra("age", parent.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    //Methode qui sera appele lors d'un clic sur le bouton enregistrer
    public void onClick(View V){

        if (nom.getText().toString().isEmpty() && prenom.getText().toString().isEmpty()){
            Toast.makeText(this, "Veuillez remmplir tous les champs", Toast.LENGTH_SHORT).show();
        }else {
            i.setClass(this, ShowActivity.class);
            i.putExtra("nom",nom.getText().toString());
            i.putExtra("prenom",prenom.getText().toString());
            i.putExtra("adresse",adresse.getText().toString());
                if(i.getStringExtra("age") != "Age"){
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(this, "Votre age svp ?", Toast.LENGTH_SHORT).show();
                }
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
    protected void onStop() { super.onStop(); }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
