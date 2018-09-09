package co.sys.generators.bna.export.asset;

import co.sys.concept.Concept;
import co.sys.generators.bna.export.concept.ListingState;
import co.sys.generators.bna.export.transaction.Offer;
import co.sys.concept.patterns.things.adt.entities.Relationships;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class VehicleListing extends Concept implements Concept.Atom<VehicleListing>{

    @NonNull @JsonTypeId
    private String listingId;

    @Nullable
    private Double reservePrice;

    @Nullable
    private String description;

    @Nullable
    private ListingState state;

    @Nullable
    private Offer[] offers;

    @Nullable
    private Relationships relations;

    @Override
    public VehicleListing value() {
        return this;
    }

    @Override
    public String identifiedBy() {
        return listingId;
    }

    public VehicleListing(String listingId, Double reservePrice, String description,
                          ListingState state, Offer[] offers) {
        this.listingId = listingId;
        this.reservePrice = reservePrice;
        this.description = description;
        this.state = state;
        this.offers = offers;
    }

    public VehicleListing(String listingId, Double reservePrice, String description,
                          ListingState state, Offer[] offers, Vehicle vehicle){
        this.listingId = listingId;
        this.reservePrice = reservePrice;
        this.description = description;
        this.state = state;
        this.offers = offers;
        this.relations.add(vehicle);
    }

    public Vehicle getVehicle() {
        return (Vehicle) relations.getAll().get(Vehicle.class.getTypeName());
    }

    public Vehicle setVehicle(Vehicle member) {
        return (Vehicle) this.relations.getAll().put(Vehicle.class.getTypeName(), member);
    }

    public void setRelations(Relationships relations) {
        this.relations = relations;
    }

    public Relationships getRelations() {
        return relations;
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public Double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListingState getState() {
        return state;
    }

    public void setState(ListingState state) {
        this.state = state;
    }

    public Offer[] getOffers() {
        return offers;
    }

    public void setOffers(Offer[] offers) {
        this.offers = offers;
    }
}
