package Week08.service.impl;

import Week08.model.User;
import Week08.repository.UsersRepository;
import Week08.service.UsersService;
import Week08.service.exception.RequiredFieldMissedException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record UsersServiceImpl(UsersRepository usersRepository) implements UsersService {

    @Override
    public User create(User user) {
        validate(user);
        User createdUser = new User(
                UUID.randomUUID().toString(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getPhone()
        );
        return usersRepository.saveAndFlush(createdUser);
    }


    private void validate(User user) {
        if (user.getFirstName() == null) throw new RequiredFieldMissedException("firstName");
        if (user.getLastName() == null) throw new RequiredFieldMissedException("lastName");
    }
}
