package SplitwiseDesign.models;

import java.util.UUID;

public class Expense {
    private UUID id;
    private String expenseName;
    private UUID groupId;
    private UUID payer;
    private int amount;

    public Expense(String expenseName, UUID groupId, UUID payer, int amount) {
        this.id = UUID.randomUUID();
        this.expenseName = expenseName;
        this.groupId = groupId;
        this.payer = payer;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID getPayer() {
        return payer;
    }

    public void setPayer(UUID payer) {
        this.payer = payer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
