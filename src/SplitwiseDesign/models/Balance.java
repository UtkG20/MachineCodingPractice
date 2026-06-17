package SplitwiseDesign.models;

import java.util.UUID;

public class Balance {
    private UUID id;
    private UUID from;
    private UUID to;
    private Float amount;
    private UUID groupId;

    public Balance(UUID from, UUID to, Float amount, UUID groupId) {
        this.id = UUID.randomUUID();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.groupId = groupId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getFrom() {
        return from;
    }

    public void setFrom(UUID from) {
        this.from = from;
    }

    public UUID getTo() {
        return to;
    }

    public void setTo(UUID to) {
        this.to = to;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}
