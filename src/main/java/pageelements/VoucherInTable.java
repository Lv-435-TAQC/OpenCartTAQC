package pageelements;

public class VoucherInTable {
    private Button mark;
    private Button remove;
    private String code;
    private String from;
    private String to;
    private String amount;

    public VoucherInTable(Button mark, String code, String from, String to, String amount) {
        this.mark = mark;
        this.code = code;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

}
