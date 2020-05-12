package com.example.parcial2ecosistemasandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parcial2ecosistemasandroid.model.Videojuego;
import com.example.parcial2ecosistemasandroid.model.Voto;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListView listaJuegos;
    private ArrayAdapter<Videojuego> adapter;
    private ArrayList<Videojuego> videojuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaJuegos = findViewById(R.id.listaJuegos);
        videojuegos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, videojuegos);
        listaJuegos.setAdapter(adapter);

        // Enviar voto
        listaJuegos.setOnItemClickListener(
                (view, renglon, pos, id) -> {
                    Videojuego videojuego = videojuegos.get(pos);
                    //Toast.makeText(this, videojuego.toString(), Toast.LENGTH_SHORT).show();

                    Date rightnow = Calendar.getInstance().getTime();

                    String idVoto = FirebaseDatabase.getInstance().getReference()
                            .child("videojuegos").child(videojuego.getId())
                            .child("votos").push().getKey();

                    String fecha = rightnow.toString();

                    Voto voto = new Voto(idVoto, fecha);

                    FirebaseDatabase.getInstance().getReference().child("videojuegos")
                            .child(videojuego.getId()).child("votos").child(idVoto).setValue(voto);

                    FirebaseDatabase.getInstance().getReference().child("votos").child(idVoto).setValue(voto);

                    Intent i = new Intent(this, ThanksActivity.class);
                    startActivity(i);
                }
        );

        // Leer lista de firebase
        FirebaseDatabase.getInstance().getReference().child("videojuegos")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Videojuego videojuego = dataSnapshot.getValue(Videojuego.class);
                        videojuegos.add(videojuego);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
}
