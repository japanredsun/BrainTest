package jrgroup.braintest.DTO;

/**
 * Created by JR on 2017/04/26.
 */

public class Memory {
    private int id;
    private String name;
    private String score;

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

    public Memory(String name, String score) {

        this.name = name;
        this.score = score;
    }
}
