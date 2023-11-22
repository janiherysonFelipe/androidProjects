package com.example.recyclerapp.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerapp.R;
import com.example.recyclerapp.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilme;
    public Adapter(List<Filme> lista) {
        this.listaFilme = lista;
    }

    @NonNull
    @Override
    //Cria as visualizações (Converte o XML do nosso modelo para uma View)
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Converte o xml para uma view utilizando um inflater
        //O parent.getContext() reecupera o contexto no qual a lista sera inserida
        //O false é para não adicionar o elemento ao elemento root
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaFilme.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());


        //holder.titulo.setText("Teste de titulo");
        //holder.genero.setText("Comedia");
        //holder.ano.setText("2010");

    }

    @Override
    public int getItemCount() {

        return listaFilme.size();
    }

    //Armazena cada um dos itens exibidos nos elementos da listagem
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView ano;
        TextView genero;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTituto);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
