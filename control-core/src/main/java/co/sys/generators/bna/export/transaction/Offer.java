package co.sys.generators.bna.export.transaction;

import co.sys.concept.env.Control;
import co.sys.generators.bna.export.asset.Vehicle;
import co.sys.generators.bna.export.asset.VehicleListing;
import co.sys.generators.bna.export.participant.Member;
import co.sys.generators.bna.meta.Relationship;
import org.springframework.lang.Nullable;

public class Offer extends Control {

    private Double bidPrice;

    @Nullable
    private Relationship<Atom<?>> relations;

    public VehicleListing getVehicleListing() {
        return (VehicleListing) relations.getOthers().get(VehicleListing.class.getTypeName());
    }

    public Vehicle setVehicleListing(VehicleListing member) {
        return (Vehicle) this.relations.getOthers().put(VehicleListing.class.getTypeName(), member);
    }

    public Member getMember() {
        return (Member) this.relations.getOthers().get(Member.class.getTypeName());
    }

    public Member setMember(Member member) {
        return (Member) this.relations.getOthers().put(Member.class.getTypeName(), member);
    }

    public Offer(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Offer(Double bidPrice, VehicleListing vehicleListing, Member member) {
        this.bidPrice = bidPrice;
        this.relations.add(vehicleListing);
        this.relations.add(member);
    }
}
