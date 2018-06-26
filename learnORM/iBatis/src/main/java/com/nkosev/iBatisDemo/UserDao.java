package learnORM.iBatis.src.main.java.com.nkosev.iBatisDemo;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface UserDao {
    UserModel addUser(UserModel user, SqlMapClient sqlmapClient);

    UserModel getUserById(Integer id, SqlMapClient sqlmapClient);

    void deleteUserById(Integer id, SqlMapClient sqlmapClient);
}