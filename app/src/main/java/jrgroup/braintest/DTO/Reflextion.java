package jrgroup.braintest.DTO;

/**
 * Created by JR on 2017/04/26.
 */

public class Reflextion {
    private int id;
    private String name;
    private Integer score;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }



    public Reflextion(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
}
