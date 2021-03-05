package com.pedaledal.Pedaledal.models.pedals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pedaledal.Pedaledal.models.manufacturers.Manufacturer;
import com.pedaledal.Pedaledal.models.users.User;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "pedals")
public class Pedal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @Column(name = "owned")
    private Boolean owned;

    @Column(name = "effect_type")
    private EffectType effectType;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "image")
    private String image;

    @Column(name = "retail_price")
    private Integer retailPrice;

    @Column(name = "used_price")
    private Integer usedPrice;

    @Column(name = "length")
    private Integer length;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "midi")
    private Boolean midi;

    @Column(name = "stereo")
    private Boolean stereo;

    @Column(name = "jack_placement")
    private String jackPlacement;

    @Column(name = "expression_input")
    private Boolean expressionInput;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    @JsonIgnoreProperties({"pedals"})
    private User user;

    @ManyToMany
    @JsonIgnoreProperties({"pedals"})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(
            name = "manufacturers_pedals",
            joinColumns = {
                    @JoinColumn(
                            name="pedal_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "manufacturer_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Manufacturer> manufacturers;

    public Pedal() {};

    public Pedal(String name, String description, String comment, Boolean owned, EffectType effectType, Integer rating, String image, Integer retailPrice, Integer usedPrice, Integer length, Integer width, Integer height, Boolean midi, Boolean stereo, String jackPlacement, Boolean expressionInput, List<Manufacturer> manufacturers) {
        this.name = name;
        this.description = description;
        this.comment = comment;
        this.owned = owned;
        this.effectType = effectType;
        this.rating = rating;
        this.image = image;
        this.retailPrice = retailPrice;
        this.usedPrice = usedPrice;
        this.length = length;
        this.width = width;
        this.height = height;
        this.midi = midi;
        this.stereo = stereo;
        this.jackPlacement = jackPlacement;
        this.expressionInput = expressionInput;
        this.manufacturers = new ArrayList<Manufacturer>();
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getUsedPrice() {
        return usedPrice;
    }

    public void setUsedPrice(Integer usedPrice) {
        this.usedPrice = usedPrice;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getMidi() {
        return midi;
    }

    public void setMidi(Boolean midi) {
        this.midi = midi;
    }

    public Boolean getStereo() {
        return stereo;
    }

    public void setStereo(Boolean stereo) {
        this.stereo = stereo;
    }

    public String getJackPlacement() {
        return jackPlacement;
    }

    public void setJackPlacement(String jackPlacement) {
        this.jackPlacement = jackPlacement;
    }

    public Boolean getExpressionInput() {
        return expressionInput;
    }

    public void setExpressionInput(Boolean expressionInput) {
        this.expressionInput = expressionInput;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public void addManufacturer(Manufacturer manufacturer) {
        this.manufacturers.add(manufacturer);
    }
}
