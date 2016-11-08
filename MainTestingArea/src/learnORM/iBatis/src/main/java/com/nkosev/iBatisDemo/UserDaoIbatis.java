package learnORM.iBatis.src.main.java.com.nkosev.iBatisDemo;

import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDaoIbatis implements UserDao {
    @Override
    public UserModel addUser(UserModel user, SqlMapClient sqlmapClient) {
        try {
            Integer id = (Integer) sqlmapClient.queryForObject("user.getMaxId");
            id = id == null ? 1 : id + 1;
            user.setId(id);
            user.setStatus(1);
            sqlmapClient.insert("user.addUser", user);
            user = getUserById(id, sqlmapClient);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel getUserById(Integer id, SqlMapClient sqlmapClient) {
        try {
            UserModel user = (UserModel) sqlmapClient.queryForObject("user.getUserById", id);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUserById(Integer id, SqlMapClient sqlmapClient) {
        try {
            sqlmapClient.delete("user.deleteUserById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}