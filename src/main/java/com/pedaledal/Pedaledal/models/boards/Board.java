package com.pedaledal.Pedaledal.models.boards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedaledal.Pedaledal.models.pedals.Pedal;
import com.pedaledal.Pedaledal.models.users.User;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedal_boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "save_name")
    private String saveName;

    @Column(name = "width")
    private Integer width;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "height")
    private Integer height;

    @OneToMany(mappedBy = "board")
    @JsonIgnoreProperties({"board"})
    private List<Pedal> boardPedals;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    @JsonIgnoreProperties({"boards"})
    private User user;

    public Board(String saveName, Integer width, Integer depth, User user) {
        this.saveName = saveName;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.boardPedals = new ArrayList<Pedal>();
        this.user = user;
    }

    public Board(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<Pedal> getBoardPedals() {
        return boardPedals;
    }

    public void setBoardPedals(List<Pedal> pedals) {
        this.boardPedals = pedals;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addBoardPedal(Pedal pedal) {
        this.boardPedals.add(pedal);
    }
}

