package com.example.tasya3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detailpahlawan extends AppCompatActivity {

    ImageView ivDetail;
    TextView tvDetail,tvnama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpahlawan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.iv_detail);
        tvDetail = findViewById(R.id.hero_name);
        tvnama = findViewById(R.id.hero_description);

//        getIncomingIntent();
        String name = getIntent().getStringExtra("name");
        String overview = getIntent().getStringExtra("detail");
        int gambar = getIntent().getIntExtra("img_url",0);

        tvnama.setText(name);
        tvDetail.setText(overview);
        ivDetail.setImageResource(gambar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int ivGambar = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(ivGambar).into(ivDetail);
            String getDesc = bundle.getString("detail");
            String getNama = bundle.getString("Title");

            tvDetail.setText(getDesc);
            tvnama.setText(getNama);
        }
    }
}
