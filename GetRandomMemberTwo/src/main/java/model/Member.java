package model;

public class Member {
    private String name;
    private boolean presented = false;

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, boolean presented) {
        this.name = name;
        this.presented = presented;
    }

    public String getName() {
        return name;
    }

    public boolean isPresented() {
        return presented;
    }

    public void setPresented(boolean presented) {
        this.presented = presented;
    }
}
