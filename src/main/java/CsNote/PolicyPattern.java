package CsNote;

import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    public void pay(int amount);
}
class kakao implements PaymentStrategy{
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public kakao(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount+ " paid using kakao");
    }
}
class luna implements PaymentStrategy{
    private String emailId;
    private String password;

    public luna(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount+ " paid using luna");
    }
}
class item{
    private String name;
    private int price;

    public item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
class shoppingcart {
    List<item> items;

    public shoppingcart() {
        this.items = new ArrayList<item>();
    }
    public void additem(item item){
        this.items.add(item);
    }
    public void removeitem(item item){
        this.items.remove(item);
    }
    public int calculateTotal(){
        int sum = 0;
        for (item i : items) {
            sum += i.getPrice();
        }
        return sum;
    }
    public void pay(PaymentStrategy paymentStrategy){
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}


public class PolicyPattern {
    public static void main(String[] args) {
        shoppingcart shoppingcart = new shoppingcart();
        item a = new item("AA",100);
        item b = new item("BB",200);
        shoppingcart.additem(a);
        shoppingcart.additem(b);

        shoppingcart.pay(new luna("zkzk0225","hello"));
        shoppingcart.pay(new kakao("chansu","1344","333","12/05"));
    }
}
