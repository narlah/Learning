package com.nkosev.iBatisDemo;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;

public class TestMain {
    public static void main(String[] args) throws Exception {
        //Initialize dao
        UserDao manager = new UserDaoIbatis();

        //Create the SQLMapClient
        Reader reader = Resources.getResourceAsReader("sql-maps-config.xml");
        SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient(reader);

        //Create a new user to persist
        UserModel user = new UserModel();
        user.setId(1);
        user.setName("Demo User");
        user.setPassword("password");
        user.setEmail("demo-user@howtodoinjava.com");
        user.setStatus(1);

        //Add the user
        manager.addUser(user, sqlmapClient);

        //Fetch the user detail
        UserModel createdUser = manager.getUserById(1, sqlmapClient);
        System.out.println(createdUser.getEmail());

        //Lets delete the user
        manager.deleteUserById(1, sqlmapClient);
    }
}