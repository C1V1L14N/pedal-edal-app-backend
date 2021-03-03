package com.pedaledal.Pedaledal.models.boards;

import javax.persistence.*;

@Entity
@Table(name = "pedal_boards")
public class Boards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "width")
    private Integer width;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "height")
    private Integer height;

    public Boards(String name, String manufacturer, Integer width, Integer depth, Integer height) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.width = width;
        this.depth = depth;
        this.height = height;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
}
