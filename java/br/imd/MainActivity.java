package br.imd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText et01;
    Button bt01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et01 = (EditText) findViewById(R.id.et01);
        bt01 = (Button) findViewById(R.id.bt01);

        String vetorArquivos[] = fileList();

        if(buscarArquivo(vetorArquivos, "cronograma.txt")){
            try{
                InputStreamReader arquivo = new InputStreamReader(openFileInput("cronograma.txt"));
                BufferedReader br = new BufferedReader(arquivo);
                String linha = br.readLine();
                String textoCompleto = "";

                while(linha != null){
                    textoCompleto = textoCompleto + linha + "\n";
                    linha = br.readLine();
                }
                et01.setText(textoCompleto);
            }catch(IOException e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean buscarArquivo(String vetorArquivo[], String nome){
        for(int i = 0; i < vetorArquivo.length; i++){
            if(vetorArquivo[i].equals(nome)){
                return true;
            }
        }
        Toast.makeText(this, "Não achou", Toast.LENGTH_LONG).show();
        return false;
    }

    public void salvarDados(View vien){
        try{
            OutputStreamWriter arquivo = new OutputStreamWriter(openFileOutput("cronograma.txt", Activity.MODE_PRIVATE));
            arquivo.write(et01.getText().toString());
            arquivo.flush();
            arquivo.close();
        }catch(IOException e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(getApplicationContext(), "Arquivo Salvo", Toast.LENGTH_SHORT).show();
        finish();
    }

}

