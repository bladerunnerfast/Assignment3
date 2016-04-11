package samples.exoguru.materialtabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import samples.exoguru.materialtabs.inject.menus.categories.CatMenuAdapter;
import samples.exoguru.materialtabs.inject.api.Categories.CatModel;
import samples.exoguru.materialtabs.inject.observers.ObserverClass;
import samples.exoguru.materialtabs.inject.ultilites.App;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab1 extends Fragment {

private RecyclerView recycleView;
private CompositeSubscription subscription = new CompositeSubscription();
private CatMenuAdapter catMenuAdapter;

    @Inject
    ObserverClass api;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container,false);
        ((App) getActivity().getApplication()).getApiComponents().inject1(this);

        recycleView = (RecyclerView)v.findViewById(R.id.myList);
        recycleView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        showMenu();
        return v;
    }

    private void showMenu(){
        subscription.add(api.getMen()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new rx.Observer<CatModel>() {
                                       @Override
                                       public void onNext(CatModel model) {
                                           Log.i("Mens Retrofit", "onNext");
                                           if ((model.getListing().size() > 0) && (recycleView != null)) {
                                               catMenuAdapter = new CatMenuAdapter(getActivity().getApplicationContext(),
                                                       R.layout.cat_menu_layout, model);
                                               recycleView.setAdapter(catMenuAdapter);
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
