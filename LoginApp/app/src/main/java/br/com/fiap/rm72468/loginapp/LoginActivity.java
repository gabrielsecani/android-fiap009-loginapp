package br.com.fiap.rm72468.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtLogin = null;
    private EditText edtPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v) {
        // Comunicação explicita
        Intent destino = new Intent("Validade");

        edtLogin = (EditText) findViewById(R.id.edtLogin);
        destino.putExtra("user", edtLogin.getText().toString());

        edtPassword = (EditText) findViewById(R.id.edtPassword);
        destino.putExtra("password", edtPassword.getText().toString());

        //startActivity(destino);
        startActivityForResult(destino, 12345);


        Log.i("teste", "destino");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Verifica que a execução foi OK
        if (resultCode == RESULT_OK && requestCode == 1) {

            //Verifica se existe o parâmetro retorno
            if (data.hasExtra("retorno")) {
                Toast.makeText(this,
                        data.getExtras().getString("retorno"),
                        Toast.LENGTH_SHORT).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
