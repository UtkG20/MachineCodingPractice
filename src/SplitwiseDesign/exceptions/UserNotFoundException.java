package SplitwiseDesign.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID userId){
        super("User Not found with id: " + userId);
    }
}
