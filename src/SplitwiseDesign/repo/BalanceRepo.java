package SplitwiseDesign.repo;

import SplitwiseDesign.models.Balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BalanceRepo {

    private Map<UUID, Balance> balanceMap;
    private List<Balance> balances;

    public BalanceRepo(){
        this.balanceMap = new HashMap<>();
        this.balances = new ArrayList<>();
    }

    public void addNewBalance(Balance balance){
        balanceMap.put(balance.getId(), balance);
        balances.add(balance);
    }

    public Balance getBalanceById(UUID id){
        if(balanceMap.containsKey(id)){
            return balanceMap.get(id);
        }
        throw new RuntimeException("Balance does not exist");
    }

    public List<Balance> getBalanceByGroupId(UUID groupId){
        return balances.stream()
                .filter(balance -> balance.getGroupId().equals(groupId))
                .toList();
    }
}
