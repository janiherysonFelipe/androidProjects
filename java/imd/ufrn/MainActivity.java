package imd.ufrn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et01;
    Button bt01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et01 = (EditText) findViewById(R.id.et01);
        bt01 = (Button) findViewById(R.id.button01);

        SharedPreferences dados = getSharedPreferences("dadosSalvos", Context.MODE_PRIVATE);
        et01.setText(dados.getString("email", ""));

       bt01.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SharedPreferences dados = getSharedPreferences("dadosSalvos", Context.MODE_PRIVATE);
               SharedPreferences.Editor editor = dados.edit();
               editor.putString("email", et01.getText().toString());
               editor.commit();
               Toast.makeText(MainActivity.this, "Salvo", Toast.LENGTH_SHORT).show();
           }
       });
    }
}