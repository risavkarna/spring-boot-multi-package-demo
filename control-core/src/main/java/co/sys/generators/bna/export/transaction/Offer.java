package co.sys.generators.bna.export.transaction;

import co.sys.concept.patterns.things.adt.entities.Control;
import co.sys.generators.bna.export.asset.Vehicle;
import co.sys.generators.bna.export.asset.VehicleListing;
import co.sys.generators.bna.export.participant.Member;
import co.sys.concept.patterns.things.adt.entities.Attributes;
import co.sys.concept.patterns.things.adt.entities.Relationships;
import org.springframework.lang.Nullable;

public class Offer extends Control {

    private static final String BID_PRICE = "bidPrice";

    // private Double bidPrice;
    private Attributes attributes;

    @Nullable
    private Relationships relations;

    public VehicleListing getVehicleListing() {
        return (VehicleListing) relations.getAll().get(VehicleListing.class.getTypeName());
    }

    public Vehicle setVehicleListing(VehicleListing member) {
        return (Vehicle) this.relations.getAll().put(VehicleListing.class.getTypeName(), member);
    }

    public Member getMember() {
        return (Member) this.relations.getAll().get(Member.class.getTypeName());
    }

    public Member setMember(Member member) {
        return (Member) this.relations.getAll().put(Member.class.getTypeName(), member);
    }

    public Double getBidPrice() {
        return (Double) this.attributes.getAll().get(BID_PRICE);
    }

    public void setBidPrice(Double bidPrice) {
        this.attributes.update(BID_PRICE, bidPrice);
    }

    public Offer(Double bidPrice) {
        this.attributes.add(BID_PRICE, bidPrice);
    }

    public Offer(Double bidPrice, VehicleListing vehicleListing, Member member) {
        this.attributes.add(BID_PRICE, bidPrice);
        this.relations.add(vehicleListing);
        this.relations.add(member);
    }
}
