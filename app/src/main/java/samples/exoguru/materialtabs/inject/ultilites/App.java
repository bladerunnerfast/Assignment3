package samples.exoguru.materialtabs.inject.ultilites;

import android.app.Application;

import samples.exoguru.materialtabs.inject.components.APIComponents;
import samples.exoguru.materialtabs.inject.components.DaggerAPIComponents;
import samples.exoguru.materialtabs.inject.components.DaggerNetComponent;
import samples.exoguru.materialtabs.inject.components.NetComponent;
import samples.exoguru.materialtabs.inject.constant.Constant;
import samples.exoguru.materialtabs.inject.modules.APIModule;
import samples.exoguru.materialtabs.inject.modules.AppModule;
import samples.exoguru.materialtabs.inject.modules.NetModule;




/**
 * Created by TAE on 08/04/2016.
 */
public class App extends Application {
    private NetComponent netComponent;
    private APIComponents apiComponents;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule(Constant.BASEURL))
                .appModule(new AppModule(this))
                .build();

        apiComponents = DaggerAPIComponents.builder()
                .netComponent(netComponent)
                .aPIModule(new APIModule())
                .build();

    }
    public NetComponent getNetComponent(){
        return this.netComponent;
    }
    public APIComponents getApiComponents(){
        return this.apiComponents;
    }
}
