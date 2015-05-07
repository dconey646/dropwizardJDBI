package com.loginExample.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface PersonDAO {

    @SqlQuery("select name from Person where id = :id")
    String findNameById(@Bind("id") int id);

    @SqlUpdate("insert into Person (id, name, age, address, salary) values (:id, :name, :age, :address, :salary)")
    void createPerson(@Bind("id") int id,
                      @Bind("name") String name,
                      @Bind("age") int age,
                      @Bind("address") String address,
                      @Bind("salary") float salary);

    @SqlUpdate("insert into User_details(person_id, username, password) values(:person_id, :username, :password)")
    void createUser(@Bind("person_id") int personId,
                    @Bind("username") String username,
                    @Bind("password") String password);

    @SqlUpdate("Delete from User_details where person_id = :person_id")
    void deleteUser(@Bind("person_id") int personId);

    @SqlQuery("select person_id from User_details where username = :username AND password = :password")
    int checkDetails(@Bind("username") String username,
                      @Bind("password") String password);
}
