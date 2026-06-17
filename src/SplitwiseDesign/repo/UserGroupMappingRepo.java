package SplitwiseDesign.repo;

import SplitwiseDesign.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserGroupMappingRepo {

    private List<UserGroupMap> userGroupMaps;

    public UserGroupMappingRepo(){
        this.userGroupMaps = new ArrayList<>();
    }

    public void addUserToGroup(UUID userId, UUID groupId){
        UserGroupMap userGroupMap =
                this.userGroupMaps.stream()
                .filter(map -> map.groupId.equals(groupId) && map.userId.equals(userId))
                .findFirst()
                        .orElse(null);

        if(userGroupMap == null){
            this.userGroupMaps.add(new UserGroupMap(userId, groupId));
        }

    }

    public List<UUID> getAllGroupUsers(UUID groupId){
        return userGroupMaps.stream()
                .filter(userGroupMap -> userGroupMap.getGroupId().equals(groupId))
                .map(UserGroupMap::getUserId)
                .toList();
    }

    public static class UserGroupMap{
        private UUID userId;
        private UUID groupId;

        public UserGroupMap(UUID userId, UUID groupId) {
            this.userId = userId;
            this.groupId = groupId;
        }

        public UUID getUserId() {
            return userId;
        }

        public void setUserId(UUID userId) {
            this.userId = userId;
        }

        public UUID getGroupId() {
            return groupId;
        }

        public void setGroupId(UUID groupId) {
            this.groupId = groupId;
        }
    }
}
