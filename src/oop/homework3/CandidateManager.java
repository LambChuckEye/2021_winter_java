package oop.homework3;

import java.util.*;

/**
 * 候选人管理
 *
 * @author Kamiu 2021/11/11 13:58
 */
public class CandidateManager {

    /**
     * 候选人列表
     */
    private HashMap<String, Candidate> candidates;

    /**
     * 选票集
     */
    private List<Ballot> ballots;

    /**
     * 排序结果
     */
    private List<Candidate> candidatesSort;

    /**
     * 竞选标准
     */
    private int standard;

    /**
     * 选举状态标志
     */
    private boolean state;

    public CandidateManager(int standard) {
        this.candidates = new HashMap<>();
        this.ballots = new ArrayList<>();
        this.standard = standard;
        this.state = false;
    }


    @Override
    public String toString() {
        return "CandidateManager{" +
                "\ncandidates=" + candidates +
                ", \nballots=" + ballots +
                ", \ncandidatesSort=" + candidatesSort +
                '}';
    }

    /**
     * 添加候选人
     */
    public void add(String... names) {
        for (String name : names) {
            candidates.put(name, new Candidate(name));
        }
    }

    /**
     * 投票
     *
     * @param strings 已选择候选人姓名
     */
    public void vote(String... strings) {
        Ballot ballot = null;
        try {
            ballot = new Ballot(Arrays.asList(strings));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ballots.add(ballot);
    }

    /**
     * 计票
     */
    public void check() {
        //计算票数
        for (Ballot ballot : ballots) {
            for (String s : ballot.getCandidateName()) {
                candidates.get(s).add();
            }
        }
        //计算排名
        candidatesSort = new ArrayList<>(candidates.values());
        candidatesSort.sort((o1, o2) -> o2.getVote() - o1.getVote());

        //计算选举结果
        //最多票数候选人得票率超过竞选标准百分比，则竞选成功
        if (((float) candidatesSort.get(0).getVote() / ballots.size()) >= ((float) standard / 100)) {
            this.state = true;
        }
    }

    /**
     * 打印竞选结果
     */
    public void print() {
        System.out.println("===============================================");
        if (state) {
            Candidate candidate = candidatesSort.get(0);
            System.out.println("候选人 " + candidate.getName() + " 竞选成功，得票数 " + candidate.getVote() +
                    "，得票比例 " + ((float) candidate.getVote() / ballots.size()) * 100 + "%");
        } else {
            System.out.println("本次选举没有候选人成功竞选。");
        }
        System.out.println("===============================================");
        System.out.println("所有候选人得票信息如下：");
        for (Candidate candidate : candidatesSort) {
            System.out.println("候选人 " + candidate.getName() + " 得票数 " + candidate.getVote() +
                    "，得票比例 " + ((float) candidate.getVote() / ballots.size()) * 100 + "%");
        }

    }

    public static void main(String[] args) {
        CandidateManager candidateManager = new CandidateManager(50);
        candidateManager.add("wang", "li", "zhao");

        candidateManager.vote("wang");
        candidateManager.vote("wang", "li");
        candidateManager.vote("li", "zhao");
        candidateManager.vote("li", "zhao");
        candidateManager.vote("zhao");
        candidateManager.vote("wang", "li", "zhao");
        candidateManager.vote("wang", "li", "zhao");
        candidateManager.vote("zhao");
        candidateManager.vote();
        candidateManager.vote();
        candidateManager.vote();
        candidateManager.vote();
        candidateManager.vote();

        candidateManager.check();
        candidateManager.print();
    }
}
