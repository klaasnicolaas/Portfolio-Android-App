package com.iiatimd.portfolioappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iiatimd.portfolioappv2.Network.RetrofitBuilder;
import com.squareup.picasso.Picasso;

public class ProjectShowActivity extends AppCompatActivity {

    private int id, aantalUur;
    private String photo,projectName,website,client,desc;
    private TextView txtAantalUur,txtOplevering,txtProjectName,txtWebsite,txtClient,txtDesc;
    private ImageView projectImage;

    private static final String TAG = "ProjectShowActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_show);
        Intent intent=getIntent();
        id = intent.getIntExtra("id", 0);
        photo = intent.getStringExtra("photo");
        aantalUur = intent.getIntExtra("aantalUur", 0);
        projectName = intent.getStringExtra("projectName");
        website = intent.getStringExtra("website");
        client = intent.getStringExtra("client");
        desc = intent.getStringExtra("desc");

        // Load views by ID's
        projectImage = findViewById(R.id.imgShowProjectImage);
        txtAantalUur = findViewById(R.id.txtShowAantalUur);
        txtOplevering = findViewById(R.id.txtShowOplevering);
        txtProjectName = findViewById(R.id.txtProjectTitle);
        txtWebsite = findViewById(R.id.txtShowWebsite);
        txtClient = findViewById(R.id.txtShowOpdrachtgever);
        txtDesc = findViewById(R.id.txtShowDesc);

        init();
    }

    private void init() {
//        Log.w(TAG, "onCreate: je hebt gekozen voor project: " + id + " " + aantalUur);

        // Load project image
        Picasso.get().load(RetrofitBuilder.URL + "projects/" + photo).into(projectImage);
        txtProjectName.setText(projectName);
        txtAantalUur.setText(String.valueOf(aantalUur));
        txtWebsite.setText(website);
        txtClient.setText(client);
        txtDesc.setText(desc);
    }


    // Wanneer je terug wil gaan naar home scherm
    public void returnIndex(View view) {
        startActivity(new Intent(ProjectShowActivity.this, HomeActivity.class));
        finish();
    }
}