package in.ass.esms.api.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ass.esms.api.users.model.UserModel;

public interface UserMgmtRepository extends JpaRepository<UserModel, Long> {

}
