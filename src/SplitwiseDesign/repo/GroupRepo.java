package SplitwiseDesign.repo;


import SplitwiseDesign.exceptions.GroupNotFoundException;
import SplitwiseDesign.models.Group;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GroupRepo {

    private Map<UUID, Group> groupMap;

    public GroupRepo(){
        this.groupMap = new HashMap<>();
    }

    public UUID createGroup(Group group){
        groupMap.put(group.getId(), group);
        return group.getId();
    }

    public Group getGroupById(UUID groupId){
        if(groupMap.containsKey(groupId)){
            return groupMap.get(groupId);
        }
        throw new GroupNotFoundException(groupId);
    }
}
