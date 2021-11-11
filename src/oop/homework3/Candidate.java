package oop.homework3;

/**
 * 候选人类
 *
 * @author Kamiu 2021/11/11 13:40
 */
public class Candidate {

    /**
     * 候选人姓名
     */
    private String name;

    /**
     * 候选人票数
     */
    private int vote;

    public Candidate(String name) {
        this.name = name;
        this.vote = 0;
    }

    /**
     * 增加票数1
     */
    public void add() {
        this.vote++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }


    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", vote=" + vote +
                '}';
    }
}
