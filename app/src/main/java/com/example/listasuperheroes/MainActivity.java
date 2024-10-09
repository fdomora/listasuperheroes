package com.example.listasuperheroes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listasuperheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Bitmap imgBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.guardarBoton.setOnClickListener(v -> {
            String superheroeNom = binding.heroeNomEdit.getText().toString();
            String nombreReal = binding.alterNomEdit.getText().toString();
            String biografia = binding.bioEdit.getText().toString();
            float poder = binding.poderBar.getRating();
            abrirDetailActivity(superheroeNom, nombreReal, biografia, poder);
        });

        binding.heroeImagen.setOnClickListener(v -> {
            camaraLauncher.launch(new Intent (MediaStore.ACTION_IMAGE_CAPTURE));
        });
    }

    ActivityResultLauncher<Intent> camaraLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK) {
                Bundle extras = result.getData().getExtras();
                imgBitmap = (Bitmap) extras.getParcelable("data");
                binding.heroeImagen.setImageBitmap(imgBitmap);
            }
        }
    });

    private void abrirDetailActivity(String superheroeNom, String nombreReal, String biografia, float poder){
        Superheroe superheroe = new Superheroe(superheroeNom, nombreReal, biografia,poder);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.SUPERHEROE_KEY, superheroe);
        intent.putExtra(DetailActivity.BITMAP_KEY, imgBitmap);
        startActivity(intent);
    }
}

//ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//    return insets;
//});