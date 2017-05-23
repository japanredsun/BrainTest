package jrgroup.braintest;

/**
 * Created by JR on 2017/05/07.
 */

public class HighScore {
    String Name;
    Integer Score;

    public HighScore(String name, Integer score) {
        Name = name;
        Score = score;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

}
