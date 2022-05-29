package Week08.service;

import Week08.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    User create(User user);

}
