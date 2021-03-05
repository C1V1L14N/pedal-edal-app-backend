package com.pedaledal.Pedaledal.models.manufacturers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedaledal.Pedaledal.models.pedals.Pedal;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "website")
    private String website;

    @ManyToMany
    @JsonIgnoreProperties({"manufacturers"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "manufacturers_pedals",
            joinColumns = {
                    @JoinColumn(
                            name="manufacturer_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "pedal_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Pedal> pedals;

    public Manufacturer(){};

    public Manufacturer(String name, String description, String website) {
        this.name = name;
        this.description = description;
        this.website = website;
        this.pedals = new ArrayList<Pedal>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Pedal> getPedals() {
        return pedals;
    }

    public void setPedals(List<Pedal> pedals) {
        this.pedals = pedals;
    }

    public void addPedal(Pedal pedal) {
        this.pedals.add(pedal);
    }
}
