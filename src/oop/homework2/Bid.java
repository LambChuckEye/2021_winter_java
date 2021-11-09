package oop.homework2;

/**
 * 投标类
 *
 * @author Kamiu 2021/11/08 15:14
 */
public class Bid {

    /**
     * 投标人姓名
     */
    private String name;

    /**
     * 投标价格
     */
    private int price;

    public Bid(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
