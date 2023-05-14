package com.example.exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class myAdapterC extends ArrayAdapter<Enfant> {

    //props------
    private Context context;
    private int res;
    private ArrayList<Enfant> myArray;


    private TextView txtNom;
    private TextView txtPrenom;
    private TextView txtPays;
    private TextView txtVille;
    private TextView txtCodePostal;
    private TextView txtAge;
    private TextView txtCadeau;
    private TextView txtNivDeSagesse;



    //Constructeur
    public myAdapterC(@NonNull Context _context, int _res, @NonNull List<Enfant> _objects) {
        super(_context, _res, _objects);

        context = _context;
        res = _res;
        myArray = new ArrayList<Enfant>();
        myArray = (ArrayList<Enfant>) _objects;

    }


    //GetView fonctionne comme une boucle FOREACH!!!!!!!
    @NonNull
    @Override
    public View getView(int _position, @Nullable View _convertView, @NonNull ViewGroup _parent) {

        //recuperer le costum_layout
        _convertView = LayoutInflater.from(context).inflate(res,_parent,false);


        //Recuperer les Views
        txtNom = (TextView) _convertView.findViewById(R.id.c_txtNom);
        txtPrenom = (TextView) _convertView.findViewById(R.id.c_txtPrenom);
        txtPays = (TextView) _convertView.findViewById(R.id.c_txtPays);
        txtVille = (TextView) _convertView.findViewById(R.id.c_txtVille);
        txtCodePostal = (TextView) _convertView.findViewById(R.id.c_txtCodeP);
        txtAge = (TextView) _convertView.findViewById(R.id.c_txtAge);
        txtCadeau = (TextView) _convertView.findViewById(R.id.c_txtCadeau);
        txtNivDeSagesse = (TextView) _convertView.findViewById(R.id.c_txtNivDeSagesse);


        //les Remplir par les valeur de notre Array qu'on recoit
        txtNom.setText(myArray.get(_position).getNom());
        txtPrenom.setText(myArray.get(_position).getPrenom());
        txtPays.setText(myArray.get(_position).getPays());
        txtVille.setText(myArray.get(_position).getVille());
        txtCodePostal.setText(myArray.get(_position).getCodePostal());
        txtAge.setText(String.valueOf(myArray.get(_position).getAge()));
        txtCadeau.setText(myArray.get(_position).getCadeau());
        txtNivDeSagesse.setText(String.valueOf(myArray.get(_position).getNivDeSagesse()));


        return _convertView;
    }




}
