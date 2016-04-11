package samples.exoguru.materialtabs;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import samples.exoguru.materialtabs.inject.Holder;
import samples.exoguru.materialtabs.inject.api.Categories.Products.Products.ProdModel;
import samples.exoguru.materialtabs.inject.menus.typemenu.DiscriptionMenuAdapter;
import samples.exoguru.materialtabs.inject.observers.ObserverClass;
import samples.exoguru.materialtabs.inject.ultilites.App;

/**
 * Created by TAE on 10/04/2016.
 */
public class ProductMenuActivity extends Activity{
        private RecyclerView recycleView;
        private CompositeSubscription subscription = new CompositeSubscription();
        private DiscriptionMenuAdapter discriptionMenuAdapter;

        @Inject
        ObserverClass api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_main);
        ((App) getApplication()).getApiComponents().inject1(this);
        recycleView = (RecyclerView)findViewById(R.id.productList);
         Holder fetch = new Holder();
        final LinearLayoutManager layoutManager = new LinearLayoutManager(fetch.getCont());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView.setLayoutManager(layoutManager);
        showMenu();
    }
    private void showMenu(){

        subscription.add(api.getProd()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new rx.Observer<ProdModel>() {
                                       public void onNext(ProdModel prodModel) {
                                           Log.i("Type Retrofit", "onNext");
                                           if ((prodModel.getListings().size() > 0) && (recycleView != null)) {
                                               discriptionMenuAdapter = new DiscriptionMenuAdapter(getApplicationContext(),
                                                       R.layout.cat_menu_layout, prodModel);
                                               recycleView.setAdapter(discriptionMenuAdapter);
                                           }
                                       }

                                       @Override
                                       public void onError(Throwable e) {

                                       }

                                       @Override
                                       public void onCompleted() {

                                       }
                                   }
                        )
        );
    }
}

