package SplitwiseDesign.repo;

import ParkingLotDesign.services.ParkingLotManager;
import SplitwiseDesign.exceptions.UserNotFoundException;
import SplitwiseDesign.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepo {

    private Map<UUID, User> userMap;

    public UserRepo(){
        this.userMap = new HashMap<>();
    }

    public void saveUser(User user){
        userMap.put(user.getId(), user);
    }

    public User getUserById(UUID userId){
        if(userMap.containsKey(userId)){
            return userMap.get(userId);
        }
        throw new UserNotFoundException(userId);
    }
}
