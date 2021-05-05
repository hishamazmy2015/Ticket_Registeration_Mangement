package com.programming.techie.springredditclone;

import com.programming.techie.springredditclone.model.Role;
import com.programming.techie.springredditclone.repository.RoleRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role user = new Role("User");
        Role admin = new Role("Admin");

        System.out.println("Arrays.asList(user, admin)"+Arrays.asList(user, admin));
        repo.saveAll(Arrays.asList(user, admin));
        List<Role> listRoles = repo.findAll();
        assertThat(listRoles.size()).isEqualTo(3);
    }

}