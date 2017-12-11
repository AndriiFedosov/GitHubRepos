package ua.andry.githubrepos;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.andry.githubrepos.models.Item;
import ua.andry.githubrepos.models.Owner;
import ua.andry.githubrepos.models.ReposList;

import ua.andry.githubrepos.models.User;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ReposList repos;
    List<Item> items;
    User user;
    Button searchButton;
    EditText searchTextField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReposList repos = new ReposList();
        items = repos.getItems();
        searchButton = findViewById(R.id.searchButton);
        searchTextField = findViewById(R.id.searchText);
        recyclerView =  findViewById(R.id.posts_recycle_view);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ReposAdapter adapter = new ReposAdapter();
        recyclerView.setAdapter(adapter);

    }

    public void search(View view) {
        App.getApi().getRepos(searchTextField.getText().toString()).enqueue(new Callback<ReposList>() {
            @Override
            public void onResponse(Call<ReposList> call, Response<ReposList> response) {
                repos = response.body();
                Log.d("Загрузилось","loaded");


            }

            @Override
            public void onFailure(Call<ReposList> call, Throwable t) {
                System.out.println("херня");
            }
        });
    }
}


