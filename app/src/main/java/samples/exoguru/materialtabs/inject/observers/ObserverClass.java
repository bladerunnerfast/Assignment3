package samples.exoguru.materialtabs.inject.observers;

import retrofit.http.GET;
import rx.Observable;
import samples.exoguru.materialtabs.inject.api.Categories.CatModel;
import samples.exoguru.materialtabs.inject.api.Categories.Products.Products.ProdModel;

/**
 * Created by TAE on 08/04/2016.
 */
public interface ObserverClass {
    @GET("/u/1559445/ASOS/SampleApi/cats_women.json")
    Observable <CatModel> getWomen();
    @GET("/u/1559445/ASOS/SampleApi/cats_men.json")
    Observable <CatModel> getMen();
    @GET("/u/1559445/ASOS/SampleApi/cats_men.json")
    Observable <ProdModel> getProd();
}
