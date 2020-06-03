package mxbeans;

import java.beans.ConstructorProperties;

public class Monster {

    private String name;

    private int level;

    @ConstructorProperties({"name", "level"})
    public Monster(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}