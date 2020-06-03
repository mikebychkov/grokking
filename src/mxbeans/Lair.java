package mxbeans;

public class Lair
        implements LairMXBean {

    private Monster monster;

    public Lair (Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void killMonster() {
        this.monster = null;
    }
}
