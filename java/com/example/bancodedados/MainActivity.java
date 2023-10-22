package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edCodigo, edDescricao, edPreco;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCodigo = (EditText) findViewById(R.id.edCodigo);
        edDescricao = (EditText) findViewById(R.id.edDescricao);
        edPreco = (EditText) findViewById(R.id.edPreco);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

    }

    public void registrar(View view){
        BancoAdmin admin = new BancoAdmin(this, "BancoProduos", null, 1);
        SQLiteDatabase banco = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();
        String descricao = edDescricao.getText().toString();
        String preco = edPreco.getText().toString();

        if(!codigo.isEmpty() && !descricao.isEmpty() && !preco.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descricao", descricao);
            registro.put("preco", preco);
            banco.insert("produtos", null, registro);
            banco.close();
            Toast.makeText(this, "Salvo com sucesso!!!", Toast.LENGTH_LONG).show();
            edCodigo.setText("");
            edDescricao.setText("");
            edPreco.setText("");
        }else{
            Toast.makeText(this, "Um ou mais campos estão vazios", Toast.LENGTH_LONG).show();
        }
    }

    public void buscar(View view){
        BancoAdmin admin = new BancoAdmin(this, "BancoProduos", null, 1);
        SQLiteDatabase banco = admin.getWritableDatabase();
        String codigo = edCodigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor consulta = banco.rawQuery("SELECT descricao, preco FROM produtos WHERE codigo=" + codigo, null);

            if(consulta.moveToFirst()){
                tvResultado.setText("Descrição: " + consulta.getString(0) + "\n" + "Preço: " + consulta.getString(1));
                banco.close();
            }else{
                Toast.makeText(this, "Produto não localizado", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Insira o codigo do produto", Toast.LENGTH_LONG).show();
        }
    }

    public void modificar(View view){
        BancoAdmin admin = new BancoAdmin(this, "BancoProduos", null, 1);
        SQLiteDatabase banco = admin.getWritableDatabase();

        String codigo = edCodigo.getText().toString();
        String descricao = edDescricao.getText().toString();
        String preco = edPreco.getText().toString();

        if(!codigo.isEmpty() && !descricao.isEmpty() && !preco.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descricao", descricao);
            registro.put("preco", preco);
            banco.update("produtos",  registro, "codigo="+codigo, null);
            banco.close();
            Toast.makeText(this, "Salvo com sucesso!!!", Toast.LENGTH_LONG).show();
            edCodigo.setText("");
            edDescricao.setText("");
            edPreco.setText("");
        }else{
            Toast.makeText(this, "Um ou mais campos estão vazios", Toast.LENGTH_LONG).show();
        }
    }

    public void excluir(View view){
        BancoAdmin admin = new BancoAdmin(this, "BancoProduos", null, 1);
        SQLiteDatabase banco = admin.getWritableDatabase();
        String codigo = edCodigo.getText().toString();

        if(!codigo.isEmpty()){

            int qtdApagados = banco.delete("produtos", "codigo="+codigo, null);
            banco.close();
            edCodigo.setText("");

            if(qtdApagados != 0) {
                Toast.makeText(this, "Produto excluido com sucesso!", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "Produto não localizado", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Insira o codigo do produto", Toast.LENGTH_LONG).show();
        }
    }
}