package samples.exoguru.materialtabs.inject.api.Categories.Products.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TAE on 09/04/2016.
 */
public class FacetValue {
    @SerializedName("Count")
    @Expose
    private Integer Count;
    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("Name")
    @Expose
    private String Name;

    /**
     *
     * @return
     * The Count
     */
    public Integer getCount() {
        return Count;
    }

    /**
     *
     * @param Count
     * The Count
     */
    public void setCount(Integer Count) {
        this.Count = Count;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The Name
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     * The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }
}
