package samples.exoguru.materialtabs.inject.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TAE on 08/04/2016.
 */
@Module
public class AppModule {
    Application mApplication;
    public AppModule(Application application){
        this.mApplication = application;
    }
    @Provides
    @Singleton
    Application providesApplication(){
        return this.mApplication;
    }
}

