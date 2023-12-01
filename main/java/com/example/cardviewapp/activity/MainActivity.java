package com.example.cardviewapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cardviewapp.R;
import com.example.cardviewapp.adpter.Adapter;
import com.example.cardviewapp.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Define o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Define p Adaptador
        this.preparaPostagens();
        Adapter adapter = new Adapter(postagens);
        recyclerView.setAdapter(adapter);
    }

    public void preparaPostagens(){
        Postagem postagem = new Postagem("Professor Felipe", "Viagem maravilhosa", R.drawable.imagem1);
        this.postagens.add(postagem);

        Postagem postagem1 = new Postagem("Albert Einstein", "Nem tudo eu falo", R.drawable.imagem2);
        this.postagens.add(postagem1);

        Postagem postagem2 = new Postagem("Pedro Paulo", "Viagem maravilhosa", R.drawable.imagem3);
        this.postagens.add(postagem2);

        Postagem postagem3 = new Postagem("Professor Felipe", "Viagem maravilhosa", R.drawable.imagem4);
        this.postagens.add(postagem3);

    }
}