package br.com.fiap.rm72468.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ValidadeLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_validade_login);
        Bundle params = getIntent().getExtras();

        String user = params.getString("user");
        String password = params.getString("password");

        Toast.makeText(ValidadeLoginActivity.this, user + "/" + password, Toast.LENGTH_SHORT).show();

        Log.i("ValidadeLogin",user+ "/" + password);
    }

    @Override
    public void finish() {
        Log.i("ValidadeLogin", "finish");

        Intent ret=new Intent();
        ret.putExtra("retorno", "Obrigado!");
        setResult(RESULT_OK, ret);

        super.finish();
    }
}
