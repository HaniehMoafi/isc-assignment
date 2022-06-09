package ir.co.isc.repository;

import ir.co.isc.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {


    @Query("SELECT c FROM CardEntity c WHERE c.user.id=?1 ")
    List<CardEntity> findByUserEntity(Long userId);


    @Query("SELECT c FROM CardEntity c WHERE c.user.nationalCode=?1 and c.isActive=?2 ")
    List<CardEntity> findCardByNationalCodeAndIsActive(String nationalCode, boolean isActive);

    Optional<CardEntity> findByCardNumberAndIsActive(String cardNumber, boolean isActive);

    Optional<CardEntity> findByCardNumberOrAccountNumber(String cardNumber , Long accountNumber);
}
