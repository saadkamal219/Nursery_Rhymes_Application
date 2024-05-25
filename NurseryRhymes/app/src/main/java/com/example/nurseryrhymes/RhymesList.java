package com.example.nurseryrhymes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RhymesList extends AppCompatActivity {

    private Button old, humpty, twinkle, blackSheep, londonBridge;
    private Button hickory, wheels, ducks, rain, jackjill;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rhymes_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        old = findViewById(R.id.old);
        humpty = findViewById(R.id.humpty);
        twinkle = findViewById(R.id.twinkle);
        blackSheep = findViewById(R.id.blacksheep);
        londonBridge = findViewById(R.id.londonbridge);
        hickory = findViewById(R.id.hickory);
        ducks = findViewById(R.id.ducks);
        rain = findViewById(R.id.rain);
        jackjill = findViewById(R.id.jackjill);
        wheels = findViewById(R.id.wheels);

        old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "old");
                startActivity(intent);
            }
        });

        humpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "humpty");
                startActivity(intent);
            }
        });

        twinkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "twinkle");
                startActivity(intent);
            }
        });

        blackSheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "blacksheep");
                startActivity(intent);
            }
        });

        londonBridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "londonbridge");
                startActivity(intent);
            }
        });

        hickory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "hickory");
                startActivity(intent);
            }
        });

        ducks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "ducks");
                startActivity(intent);
            }
        });

        wheels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "wheels");
                startActivity(intent);
            }
        });

        jackjill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "jackjill");
                startActivity(intent);
            }
        });

        rain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RhymesList.this, Rhymes.class);
                intent.putExtra("rhyme", "rain");
                startActivity(intent);
            }
        });

    }
}