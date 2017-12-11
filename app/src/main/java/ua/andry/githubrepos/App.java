package ua.andry.githubrepos;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.andry.githubrepos.api.GithubAPI;

/**
 * Created by shink on 10.12.2017.
 */

public class App extends Application {

    private static GithubAPI githubAPI;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl( "https://api.github.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        githubAPI = retrofit.create(GithubAPI.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static GithubAPI getApi() {
        return githubAPI;
    }
}