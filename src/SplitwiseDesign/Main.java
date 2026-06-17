package SplitwiseDesign;

import SplitwiseDesign.models.Balance;
import SplitwiseDesign.models.Expense;
import SplitwiseDesign.models.Group;
import SplitwiseDesign.models.User;
import SplitwiseDesign.repo.BalanceRepo;
import SplitwiseDesign.repo.GroupRepo;
import SplitwiseDesign.repo.UserGroupMappingRepo;
import SplitwiseDesign.repo.UserRepo;
import SplitwiseDesign.services.ExpenseManager;
import SplitwiseDesign.services.GroupsManager;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        User utkarsh = new User("Utkarsh");
        User jatin = new User("Jatin");
        User nitin = new User("Nitin");

        UserRepo userRepo = new UserRepo();
        userRepo.saveUser(utkarsh);
        userRepo.saveUser(jatin);
        userRepo.saveUser(nitin);
        GroupRepo groupRepo = new GroupRepo();
        UserGroupMappingRepo userGroupMappingRepo = new UserGroupMappingRepo();
        BalanceRepo balanceRepo = new BalanceRepo();
        GroupsManager groupsManager = new GroupsManager(userRepo, groupRepo, userGroupMappingRepo, balanceRepo);

        UUID bangaloreTripId = groupsManager.createGroup("BangaloreTrip");

        groupsManager.addUserToGroup(utkarsh.getId(), bangaloreTripId);
        groupsManager.addUserToGroup(nitin.getId(), bangaloreTripId);
        groupsManager.addUserToGroup(jatin.getId(), bangaloreTripId);

        ExpenseManager expenseManager = new ExpenseManager(balanceRepo, groupsManager, userRepo);

        expenseManager.addNewExpense(new Expense("Cab", bangaloreTripId, utkarsh.getId(), 300));


        List<Balance> balances = groupsManager.getAllBalancesOfGroup(bangaloreTripId);

        System.out.println(balances.size());

        balances.stream().forEach(balance -> System.out.println("from: " + balance.getFrom() + " to: " + balance.getTo() + " amount: " + balance.getAmount()));
    }
}
