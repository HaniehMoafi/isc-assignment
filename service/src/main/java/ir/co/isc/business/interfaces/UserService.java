package ir.co.isc.business.interfaces;

import ir.co.isc.entity.UserEntity;
import ir.co.isc.exception.UserException;
import ir.co.isc.model.UserModel;

public interface UserService {


    UserEntity findUserByNationalCode(String nationalCode)throws UserException;
}
