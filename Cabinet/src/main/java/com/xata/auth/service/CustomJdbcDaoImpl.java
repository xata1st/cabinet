package com.xata.auth.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.xata.auth.domain.MyUser;

public class CustomJdbcDaoImpl extends JdbcDaoImpl {
	
	public CustomJdbcDaoImpl() {
		super();
	}
	
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(this.getUsersByUsernameQuery(), new String[] {username}, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean enabled = rs.getBoolean(3);
                //return new User(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
                return new MyUser(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
            }
        });
    }
}