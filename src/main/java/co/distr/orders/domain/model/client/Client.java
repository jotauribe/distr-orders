package co.distr.orders.domain.model.client;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Personal on 03/06/2017.
 */

@XmlRootElement
@Entity(name = "CLIENT")
public class Client {

    @EmbeddedId
    private ClientId clientId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    protected Client(){}

    public Client(ClientId clientId, String name, String address){
        this.clientId = clientId;
        setName(name);
        setAddress(address);
    }

    private void setName(String name){
        if(name == null)
            throw new IllegalArgumentException("Address can not be null");
        if(name.length() < 1)
            throw new IllegalArgumentException("Invalid length for address");
        this.name = name;
    }

    private void setAddress(String address){
        if(address == null)
            throw new IllegalArgumentException("Name can not be null");
        if(address.length() < 1)
            throw new IllegalArgumentException("Invalid length for name");
        this.address = address;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
