package samples.exoguru.materialtabs.inject.modules;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import samples.exoguru.materialtabs.inject.observers.ObserverClass;
import samples.exoguru.materialtabs.inject.scopes.UserScope;

/**
 * Created by TAE on 08/04/2016.
 */
@Module
public class APIModule {
    @Provides
    @UserScope
    public ObserverClass providesCollectionInterface(RestAdapter retroFit){
        return retroFit.create(ObserverClass.class);
    }
}
