package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {

    String username,name;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.loginactivity);

        // Set window insets listener on the root view of the layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText username = findViewById(R.id.tvusername);
        EditText password = findViewById(R.id.tvpassword);
        Button loginButton = findViewById(R.id.btnlogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()||password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a username or a password", Toast.LENGTH_SHORT).show();
                }else {
                    if(username.getText().toString().equals("database user name")&&password.getText().toString().equals("database password")) {
                        setContentView(R.layout.loginactivity);
                    }else {
                        Toast.makeText(MainActivity.this, "Please enter a valid username or password", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                    }
                }
            }
        });

    }
}