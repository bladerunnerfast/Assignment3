package samples.exoguru.materialtabs.inject.components;

import dagger.Component;
import samples.exoguru.materialtabs.ProductMenuActivity;
import samples.exoguru.materialtabs.Tab1;
import samples.exoguru.materialtabs.Tab2;
import samples.exoguru.materialtabs.inject.modules.APIModule;
import samples.exoguru.materialtabs.inject.scopes.UserScope;

/**
 * Created by TAE on 08/04/2016.
 */

@UserScope
@Component(dependencies = NetComponent.class, modules = APIModule.class)
public interface APIComponents{
      void inject1(Tab1 activity);
      void inject1(Tab2 activity);
      void inject1(ProductMenuActivity activity);
}


