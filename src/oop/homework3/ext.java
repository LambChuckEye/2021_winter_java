package oop.homework3;

import java.util.Scanner;

/**
 * description
 *
 * @author Kamiu 2021/11/12 8:08
 */
public class ext {

    private CandidateManager candidateManager;

    public ext(CandidateManager candidateManager) {
        this.candidateManager = candidateManager;
    }

    static String SPLIT = "==========================================";

    public void mainPage() {
        System.out.println(SPLIT);
        System.out.println("竞选管理系统功能菜单：");
        System.out.println("\n1.添加候选人\n2.添加选票\n3.计票并查询结果");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        if (str.equals("1")) {
            addCan();
        } else if (str.equals("2")) {
            addBallot();
        } else {
            print();
        }
    }

    public void addCan() {
        System.out.println(SPLIT);
        System.out.println("请输入添加候选人名称，使用'-'进行分割：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String[] s = str.split("-");
        candidateManager.add(s);
        mainPage();
    }

    public void addBallot() {
        System.out.println(SPLIT);
        System.out.println("请输入所选候选人名称，使用'-'进行分割：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String[] s = str.split("-");
        candidateManager.vote(s);
        mainPage();
    }

    public void print() {
        candidateManager.check();
        candidateManager.print();
        mainPage();
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        new ext(new CandidateManager(Integer.parseInt(str))).mainPage();
    }

}
