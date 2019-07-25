package ru.sosweet.cakes;

public enum CakeType {
    CHEESECAKE("Чизкейк"), CAKE("Торт"), DESERT("Десерт");

    private String desctiprion;

    CakeType(String desctiprion) {
        this.desctiprion = desctiprion;
    }

    public String getDescription() {
        return desctiprion;
    }
}
