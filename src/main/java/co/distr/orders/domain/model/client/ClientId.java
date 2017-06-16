package co.distr.orders.domain.model.client;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Guess on 4/6/2017.
 */
@XmlRootElement
@Embeddable
public class ClientId implements Serializable{

    @Column(name = "CLIENT_ID")
    private String id;

    public ClientId(){
        this.id = UUID.randomUUID().toString();
    }

    public ClientId(String id){
        setID(id);
    }

    private void setID(String id){
        if(id == null)
            throw new IllegalArgumentException("Id can not be null");
        if(id.length() < 4)
            throw  new IllegalArgumentException("Id length must be greater than 4");
        this.id = id;
    }

    @XmlElement
    public String getId(){
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
