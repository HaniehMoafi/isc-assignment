package ir.co.isc.business;

import ir.co.isc.Translator;
import ir.co.isc.business.interfaces.UserService;
import ir.co.isc.entity.UserEntity;
import ir.co.isc.exception.UserException;
import ir.co.isc.model.UserModel;
import ir.co.isc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity findUserByNationalCode(String nationalCode) throws UserException {
        Optional<UserEntity> u = userRepository.findByNationalCode(nationalCode);
        if (u.isPresent()) {
            return u.get();
        } else throw new UserException(UserException.USER_NOT_FOUND);

    }

    @Override
    public void save(UserModel userModel) throws UserException {
        UserEntity entity = Translator.userModelToUserEntity(userModel);
        try {
            userRepository.save(entity);
        } catch (Exception e) {
            throw new UserException(UserException.DUPLICATE_USER);
        }
    }

    @Override
    public UserModel findUserDataByNationalCode(String nationalCode) throws UserException {
        Optional<UserEntity> u = userRepository.findByNationalCode(nationalCode);
        if (u.isPresent()) {
            return Translator.userEntityToUserModel(u.get());
        } else throw new UserException(UserException.USER_NOT_FOUND);
    }
}
