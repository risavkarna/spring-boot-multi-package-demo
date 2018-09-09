package co.sys.concept.generators.bna.export.transaction;

import co.sys.concept.patterns.things.adt.entities.Control;
import co.sys.concept.generators.bna.export.asset.Vehicle;
import co.sys.concept.generators.bna.export.asset.VehicleListing;
import co.sys.concept.patterns.things.adt.entities.Relationships;
import org.springframework.lang.Nullable;

public class ReopenListing extends Control {

    @Nullable
    private Relationships relations;

    public VehicleListing getVehicleListing() {
        return (VehicleListing) relations.getAll().get(VehicleListing.class.getTypeName());
    }

    public Vehicle setVehicleListing(VehicleListing member) {
        return (Vehicle) this.relations.getAll().put(VehicleListing.class.getTypeName(), member);
    }

}
