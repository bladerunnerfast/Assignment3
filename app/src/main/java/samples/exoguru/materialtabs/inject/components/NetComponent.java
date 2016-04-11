package samples.exoguru.materialtabs.inject.components;

import android.content.SharedPreferences;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.RestAdapter;
import samples.exoguru.materialtabs.inject.modules.AppModule;
import samples.exoguru.materialtabs.inject.modules.NetModule;

/**
 * Created by TAE on 08/04/2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent
{
    RestAdapter retroFit();
    OkHttpClient okayHttpClient();
    SharedPreferences sharedPreferences();
}
