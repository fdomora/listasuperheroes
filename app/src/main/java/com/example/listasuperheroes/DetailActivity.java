package com.example.listasuperheroes;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listasuperheroes.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String SUPERHEROE_KEY = "superheroe";
    public static final String BITMAP_KEY = "bitmap";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        Superheroe superheroe = extras.getParcelable(SUPERHEROE_KEY);
        Bitmap bitmap = extras.getParcelable(BITMAP_KEY);

        binding.nombreHeroe.setText(superheroe.getNombre());
        binding.nombreRealText.setText(superheroe.getNomreal());
        binding.textView5.setText(superheroe.getBio());
        binding.ratingBar.setRating(superheroe.getPoder());
        binding.imageView.setImageBitmap(bitmap);
    }
}