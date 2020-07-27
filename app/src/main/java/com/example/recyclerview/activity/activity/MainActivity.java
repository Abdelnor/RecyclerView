package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;

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

        //Listagemd e Filmes
        this.criarFilmes();

        //Configurar Adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), filme.getTitulo(), Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), filme.getGenero() + filme.getAno(), Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );


    }

    public void criarFilmes(){
        Filme filme = new Filme("titulo1", "genero1","Ano1");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo2", "genero2","Ano2");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo3", "genero3","Ano3");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo4", "genero4","Ano4");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo5", "genero5","Ano5");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo6", "genero6","Ano6");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo7", "genero7","Ano7");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo8", "genero8","Ano8");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo9", "genero9","Ano9");
        this.listaFilmes.add(filme);
        filme = new Filme("titulo10", "genero10","Ano10");
        this.listaFilmes.add(filme);



    }

}