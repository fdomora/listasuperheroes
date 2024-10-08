package com.example.listasuperheroes;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listasuperheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.guardarBoton.setOnClickListener(v -> {
            String superheroeNom = binding.heroeNomEdit.getText().toString();
            String nombreReal = binding.alterNomEdit.getText().toString();
            String biografia = binding.bioEdit.getText().toString();
            float poder = binding.poderBar.getRating();
            abrirDetailActivity(superheroeNom, nombreReal, biografia, poder);
        });
    }
    private void abrirDetailActivity(String superheroeNom, String nombreReal, String biografia, float poder){
        Superheroe superheroe = new Superheroe(superheroeNom, nombreReal, biografia,poder);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.SUPERHEROE_KEY, superheroe);
        startActivity(intent);
    }
}

//ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//    return insets;
//});