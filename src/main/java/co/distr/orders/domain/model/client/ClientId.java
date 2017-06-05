package co.distr.orders.domain.model.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Guess on 4/6/2017.
 */

@Embeddable
public class ClientId implements Serializable{

    @Column(name = "ID")
    private String id;

    protected ClientId(){
        this.id = UUID.randomUUID().toString();
    }

    public String asString(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientId clientId = (ClientId) o;

        return id.equals(clientId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}
