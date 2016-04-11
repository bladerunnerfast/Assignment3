package samples.exoguru.materialtabs.inject.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by TAE on 08/04/2016.
 */
@Module
public class NetModule {
    private String BASEURL;

    public NetModule(String baseURL){
        this.BASEURL = baseURL;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
    @Provides
    @Singleton
    Cache provideOkHttpCache(Application applicaton){
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(applicaton.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Cache cache){
        OkHttpClient okayHttpClient = new OkHttpClient();
        okayHttpClient.setCache(cache);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        okayHttpClient.interceptors().add(interceptor);
        return okayHttpClient;
    }

    @Provides
    @Singleton
    RestAdapter provideRetrofit(OkHttpClient okayHttp){
        Log.i("Retrofit", "provideRetrofit");
        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint(BASEURL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okayHttp))
                .build();
        return retrofit;
    }
}
