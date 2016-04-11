package samples.exoguru.materialtabs.inject.api.Categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAE on 09/04/2016.
 */
public class CatModel {@SerializedName("Description")
@Expose
private String Description;
    @SerializedName("Listing")
    @Expose
    private List<CatListing> Listing = new ArrayList<CatListing>();
    @SerializedName("SortType")
    @Expose
    private String SortType;

    /**
     *
     * @return
     * The Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     *
     * @param Description
     * The Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     *
     * @return
     * The Listing
     */
    public List<CatListing> getListing() {
        return Listing;
    }

    /**
     *
     * @param Listing
     * The Listing
     */
    public void setListing(List<CatListing> Listing) {
        this.Listing = Listing;
    }

    /**
     *
     * @return
     * The SortType
     */
    public String getSortType() {
        return SortType;
    }

    /**
     *
     * @param SortType
     * The SortType
     */
    public void setSortType(String SortType) {
        this.SortType = SortType;
    }
}

