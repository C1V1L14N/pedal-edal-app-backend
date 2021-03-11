package com.pedaledal.Pedaledal.models.users;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedaledal.Pedaledal.models.boards.Board;
import com.pedaledal.Pedaledal.models.pedals.Pedal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age_range")
    private AgeRange ageRange;

    @Column(name ="location")
    private String location;

    @Column(name = "instrument")
    private String instrument;

    @Column(name = "fave_effect")
    private String faveEffect;

    @JsonIgnoreProperties({"user", "board"})
    @OneToMany(mappedBy = "user")
    private List<Pedal> pedals;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user")
    private List<Board> boards;

    public User(){}

    public User(String name, String email, AgeRange ageRange, String location, String instrument, String faveEffect) {
        this.name = name;
        this.email = email;
        this.ageRange = ageRange;
        this.location = location;
        this.instrument = instrument;
        this.faveEffect = faveEffect;
        this.pedals = new ArrayList<Pedal>();
        this.boards = new ArrayList<Board>();
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

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getFaveEffect() {
        return faveEffect;
    }

    public void setFaveEffect(String faveEffect) {
        this.faveEffect = faveEffect;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
