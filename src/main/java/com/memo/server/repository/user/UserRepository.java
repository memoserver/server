package com.memo.server.repository.user;

        import com.memo.server.entity.user.User;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserId(int userId);
    User findUserByUserId(int userId);
}
