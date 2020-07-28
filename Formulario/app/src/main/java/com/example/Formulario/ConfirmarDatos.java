package com.example.Formulario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacion2.R;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView showName    = findViewById(R.id.tvName);
        TextView showDate     = findViewById(R.id.tvDate);
        TextView showPhone   = findViewById(R.id.tvPhone);
        TextView showEmail      = findViewById(R.id.tvEmail);
        TextView showDescription       = findViewById(R.id.tvDescription);
        Button btnEdit      = findViewById(R.id.botEdit);

        Bundle extras       = getIntent().getExtras();
        String name         = extras.getString("name");
        String date         = extras.getString("date");
        String phone        = extras.getString("phone");
        String email        = extras.getString("email");
        String description  = extras.getString("description");

        showName.setText(name);
        showDate.setText(date);
        showPhone.setText(phone);
        showEmail.setText(email);
        showDescription.setText(description);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Intent intent = new Intent(ConfirmarDatos.this , MainActivity.class);
                startActivity(intent);
              */ onBackPressed();
            }
        });
    }

}
