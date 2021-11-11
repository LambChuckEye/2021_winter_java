package oop.homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 选票类
 *
 * @author Kamiu 2021/11/11 13:40
 */
public class Ballot {

    /**
     * 投票目标
     */
    private List<String> candidateName;

    public Ballot(List<String> names) throws Exception {
        if (names.size() > 12) {
            throw new Exception("选票最多可投12人");
        }
        this.candidateName = names;
    }

    public List<String> getCandidateName() {
        return candidateName;
    }

    @Override
    public String toString() {
        return "Ballot{" +
                "candidateName=" + candidateName +
                '}';
    }

}
