enum OrderStatus{
    PLACED, CONFIRMED, SHIPPED, DELIVERED, CANCELLED;
}
enum PaymentMethod{
    CREDIT_CARD("credit card", 2.5),
    DEBIT_CARD("debit card", 1.0),
    UPI("UPI", 0.0),
    NET_BANKING("net banking", 1.5);

    private final String displayName;
    private final double feePercent;

    PaymentMethod(String displayName, double feePercent){
        this.displayName = displayName;
        this.feePercent = feePercent;
    }
    public String getDisplayName(){
        return displayName;
    }
    public double getFeePercent(){
        return feePercent;
    }
}
class Order{
    private String orderId;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private double amount;
    Order(String orderId, PaymentMethod paymentMethod, double amount){
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = OrderStatus.PLACED;
    }
    public boolean advanceStatus(){
        switch (status) {
            case PLACED:
                status = OrderStatus.CONFIRMED;
                return true;
            case CONFIRMED:
                status = OrderStatus.SHIPPED;
                return true;
            case SHIPPED:
                status = OrderStatus.DELIVERED;
                return true;
            default:
                return false;
        }
    }
    public boolean cancel(){
        if(status == OrderStatus.PLACED || status == OrderStatus.CONFIRMED){
            status = OrderStatus.CANCELLED;
            return true;
        }
        return false;
    }
    public double getTotalWithFees(){
        return amount + (amount * paymentMethod.getFeePercent()/100);
    }
    public void displayInfo(){
        System.out.printf("Order %s | Status : %s | Payment : %s | Amount : $%.2f(with fees : $%.2f)%n", 
                            orderId, status, paymentMethod.getDisplayName(), amount, getTotalWithFees());
    }
}
public class Main{
    public static void main(String[] args) {
        Order order = new Order("ORD-1010", PaymentMethod.CREDIT_CARD, 99.99);

        order.displayInfo();

        order.advanceStatus();
        order.advanceStatus();
        order.displayInfo();

        System.out.println("Cancel after shipping: " + order.cancel());cd
    }
}