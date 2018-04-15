package co.sys.generators.bna.export.participant;

import co.sys.concept.Concept;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public abstract class User  extends Concept implements  Concept.Atom<User> {

    @NonNull @JsonTypeId
    private String email;

    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public User value() {
        return this;
    }

    @Override
    public String identifiedBy() {
        return this.email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
