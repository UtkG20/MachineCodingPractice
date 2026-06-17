package SplitwiseDesign.services;

import SplitwiseDesign.models.Balance;
import SplitwiseDesign.models.Expense;
import SplitwiseDesign.models.Group;
import SplitwiseDesign.models.User;
import SplitwiseDesign.repo.BalanceRepo;
import SplitwiseDesign.repo.UserRepo;

import java.util.List;
import java.util.UUID;

public class ExpenseManager {

    private BalanceRepo balanceRepo;
    private GroupsManager groupsManager;
    private UserRepo userRepo;

    public ExpenseManager(BalanceRepo balanceRepo, GroupsManager groupsManager, UserRepo userRepo) {
        this.balanceRepo = balanceRepo;
        this.groupsManager = groupsManager;
        this.userRepo = userRepo;
    }

    public void addNewExpense(Expense expense){
        UUID groupId = expense.getGroupId();
        List<User> users = groupsManager.getAllUsersByGroup(groupId);
        int factor = users.size();
        Float balanceAmount = (float) (expense.getAmount()/factor);
        UUID payer = expense.getPayer();
        users.stream()
                .filter(user -> !user.getId().equals(payer))
                .forEach(user -> {
                    Balance balance = new Balance(user.getId(), payer, balanceAmount, groupId);
                    balanceRepo.addNewBalance(balance);
                });
        System.out.println("expense added");
    }

}
