package fun.snowpeak.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public User getUserById(String id) {
        String query="SELECT * FROM users WHERE id = "+id;
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }
}