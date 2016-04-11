package samples.exoguru.materialtabs.inject.menus.typemenu;

import android.os.Bundle;
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
import samples.exoguru.materialtabs.R;
import samples.exoguru.materialtabs.inject.api.Categories.Products.Products.ProdModel;
import samples.exoguru.materialtabs.inject.observers.ObserverClass;

/**
 * Created by TAE on 09/04/2016.
 */
public class DiscriptionFragment extends Fragment{
    private RecyclerView recycleView;
    private CompositeSubscription subscription = new CompositeSubscription();
    private DiscriptionMenuAdapter discriptionMenuAdapter;

    @Inject
    ObserverClass api;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.type_frag_layout, container,false);
       //+ ((App) getActivity().getApplication()).getApiComponents().inject1(this);
        recycleView = (RecyclerView)v.findViewById(R.id.myList);
        recycleView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        showMenu();
        return v;
    }

    private void showMenu(){

            subscription.add(api.getProd()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new rx.Observer<ProdModel>(){
                                   public void onNext(ProdModel prodModel) {
                                       Log.i("Type Retrofit", "onNext");
                                       if ((prodModel.getListings().size() > 0) && (recycleView != null)) {
                                           discriptionMenuAdapter = new DiscriptionMenuAdapter(getActivity(),
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
