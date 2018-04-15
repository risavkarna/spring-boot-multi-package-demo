package co.sys.generators.bna.export.transaction;

import co.sys.concept.Concept;
import co.sys.concept.env.Control;
import co.sys.generators.bna.export.asset.Vehicle;
import co.sys.generators.bna.export.asset.VehicleListing;
import co.sys.generators.bna.meta.Relationship;
import org.springframework.lang.Nullable;

public class CloseBidding extends Control{

    @Nullable
    private Relationship<Concept.Atom<?>> relations;

    public VehicleListing getVehicleListing() {
        return (VehicleListing) relations.getOthers().get(VehicleListing.class.getTypeName());
    }

    public Vehicle setVehicleListing(VehicleListing member) {
        return (Vehicle) this.relations.getOthers().put(VehicleListing.class.getTypeName(), member);
    }

}
