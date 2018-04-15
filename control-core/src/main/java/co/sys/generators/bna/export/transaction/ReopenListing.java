package co.sys.generators.bna.export.transaction;

import co.sys.concept.env.Control;
import co.sys.generators.bna.export.asset.Vehicle;
import co.sys.generators.bna.export.asset.VehicleListing;
import co.sys.concept.env.Relationships;
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
