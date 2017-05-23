package jrgroup.braintest.DTO;

/**
 * Created by JR on 2017/04/26.
 */

public class Vision {
    private int id;

    public Vision(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    private String name;
    private String score;
}
