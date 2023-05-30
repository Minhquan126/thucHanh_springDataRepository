package ra.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "country",targetEntity = Customer.class)
    private Set<Customer> customers;

    public Country() {
    }

    public Country(Long id, String name, Set<Customer> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
