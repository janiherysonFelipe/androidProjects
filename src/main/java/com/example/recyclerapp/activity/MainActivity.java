package com.example.recyclerapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.recyclerapp.R;
import com.example.recyclerapp.adapter.Adapter;
import com.example.recyclerapp.model.Filme;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // chamanado o metodo criar filmes
        criarFilmes();

        //Configurando adapter
       // Adapter adapter  = new Adapter();
        Adapter adapter  = new Adapter(listaFilmes);


        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void criarFilmes(){
        Filme filme1 = new Filme("O Destino nas Estrelas", "Ficção Científica", "2022");
        this.listaFilmes.add(filme1);

        Filme filme2 = new Filme("A Sombra do Passado", "Drama", "2019");
        this.listaFilmes.add(filme2);

        Filme filme3 = new Filme("Aventuras na Cidade Perdida", "Ação/Aventura", "2021");
        this.listaFilmes.add(filme3);

        Filme filme4 = new Filme("O Mistério do Relógio Antigo", "Mistério", "2020");
        this.listaFilmes.add(filme4);

        Filme filme5 = new Filme("Amor Proibido", "Romance", "2018");
        this.listaFilmes.add(filme5);

        Filme filme6 = new Filme("Os Segredos da Floresta", "Fantasia", "2023");
        this.listaFilmes.add(filme6);

        Filme filme7 = new Filme("No Limite da Realidade", "Suspense", "2017");
        this.listaFilmes.add(filme7);

        Filme filme8 = new Filme("Rumo ao Infinito", "Ação/Ficção Científica", "2022");
        this.listaFilmes.add(filme8);

        Filme filme9 = new Filme("Caminhos Cruzados", "Drama", "2016");
        this.listaFilmes.add(filme9);

        Filme filme10 = new Filme("O Último Refúgio", "Aventura/Drama", "2020");
        this.listaFilmes.add(filme10);

        Filme filme11 = new Filme("Entre o Passado e o Futuro", "Drama/Ficção Científica", "2021");
        this.listaFilmes.add(filme11);

        Filme filme12 = new Filme("O Labirinto do Tempo", "Aventura/Mistério", "2019");
        this.listaFilmes.add(filme12);

        Filme filme13 = new Filme("O Amor que Desafia o Tempo", "Romance/Fantasia", "2023");
        this.listaFilmes.add(filme13);

        Filme filme14 = new Filme("No Coração da Selva", "Ação/Aventura", "2017");
        this.listaFilmes.add(filme14);

        Filme filme15 = new Filme("Além das Estrelas", "Ficção Científica/Drama", "2020");
        this.listaFilmes.add(filme15);

    }
}