package SplitwiseDesign.services;

import SplitwiseDesign.models.Balance;
import SplitwiseDesign.models.Group;
import SplitwiseDesign.models.User;
import SplitwiseDesign.repo.BalanceRepo;
import SplitwiseDesign.repo.GroupRepo;
import SplitwiseDesign.repo.UserGroupMappingRepo;
import SplitwiseDesign.repo.UserRepo;

import java.util.List;
import java.util.UUID;

public class GroupsManager {

    private UserRepo userRepo;
    private GroupRepo groupRepo;
    private UserGroupMappingRepo userGroupMapping;
    private BalanceRepo balanceRepo;

    public GroupsManager(UserRepo userRepo, GroupRepo groupRepo, UserGroupMappingRepo userGroupMapping, BalanceRepo balanceRepo) {
        this.userRepo = userRepo;
        this.groupRepo = groupRepo;
        this.userGroupMapping = userGroupMapping;
        this.balanceRepo = balanceRepo;
    }


    public UUID createGroup(String name){
        return groupRepo.createGroup(new Group(name));
    }

    public void addUserToGroup(UUID userId, UUID groupId){
        User user = userRepo.getUserById(userId);
        Group group = groupRepo.getGroupById(groupId);
        userGroupMapping.addUserToGroup(userId, groupId);
    }

    public List<User> getAllUsersByGroup(UUID groupId){
        Group group = groupRepo.getGroupById(groupId);
        return userGroupMapping.getAllGroupUsers(groupId)
                .stream().map(userId -> userRepo.getUserById(userId)).toList();
    }

    public List<Balance> getAllBalancesOfGroup(UUID groupId){
        return balanceRepo.getBalanceByGroupId(groupId);
    }


}
