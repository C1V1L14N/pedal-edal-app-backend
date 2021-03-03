package com.pedaledal.Pedaledal.models.users;

public enum AgeRange {
    R_ONE("18-24"),
    R_TWO("25-34"),
    R_THREE("35-44"),
    R_FOUR("45-54"),
    R_FIVE("55-64"),
    R_SIX("65-74"),
    R_SEVEN("75+");

    private final String range;

    AgeRange(String range) {
        this.range = range;
    }

    public String getRange() {
        return range;
    }
}
