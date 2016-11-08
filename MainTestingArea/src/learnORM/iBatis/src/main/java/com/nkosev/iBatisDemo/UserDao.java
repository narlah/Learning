package learnORM.iBatis.src.main.java.com.nkosev.iBatisDemo;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface UserDao {
    public UserModel addUser(UserModel user, SqlMapClient sqlmapClient);

    public UserModel getUserById(Integer id, SqlMapClient sqlmapClient);

    public void deleteUserById(Integer id, SqlMapClient sqlmapClient);
}