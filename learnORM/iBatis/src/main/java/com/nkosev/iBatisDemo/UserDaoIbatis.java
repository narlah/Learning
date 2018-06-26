package learnORM.iBatis.src.main.java.com.nkosev.iBatisDemo;

import com.ibatis.sqlmap.client.SqlMapClient;

class UserDaoIbatis implements UserDao {

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

    public UserModel getUserById(Integer id, SqlMapClient sqlmapClient) {
        try {
            return (UserModel) sqlmapClient.queryForObject("user.getUserById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUserById(Integer id, SqlMapClient sqlmapClient) {
        try {
            sqlmapClient.delete("user.deleteUserById", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}