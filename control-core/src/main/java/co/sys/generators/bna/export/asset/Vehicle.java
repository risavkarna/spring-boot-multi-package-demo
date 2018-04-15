package co.sys.generators.bna.export.asset;

import co.sys.concept.Concept;
import co.sys.generators.bna.export.participant.Member;
import co.sys.generators.bna.meta.Relationship;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class Vehicle extends Concept implements Concept.Atom<Vehicle> {

    @NonNull @JsonTypeId
    private String vin;

    @Nullable
    private Integer year;

    @Nullable
    private Relationship<Concept.Atom<?>> relations;

    public Vehicle(String vin, Integer year) {
        this.vin = vin;
        this.year = year;
    }

    public Vehicle(String vin, Integer year, Member owner) {
        this.vin = vin;
        this.year = year;
        this.relations.add(owner);
    }

    public Member getOwner() {
        return (Member) this.relations.getOthers().get(Member.class.getTypeName());
    }

    public Member setOwner(Member member) {
        return (Member) this.relations.getOthers().put(Member.class.getTypeName(), member);
    }

    private Relationship<Concept.Atom<?>> getRelations() {
        return relations;
    }

    private void setRelations(Relationship<Concept.Atom<?>> relations) {
        this.relations = relations;
    }

    @Override
    public Vehicle value() {
        return this;
    }

    @Override
    public String identifiedBy() {
        return this.vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
