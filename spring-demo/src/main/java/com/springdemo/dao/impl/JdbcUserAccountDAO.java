/**
 * 
 */
package com.springdemo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.UserAccountDAO;
import com.springdemo.domain.UserAccount;

/**
 * @author skatam
 *
 */
@Repository
@Qualifier("Jdbc")
public class JdbcUserAccountDAO implements UserAccountDAO
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Integer create(final UserAccount userAccount) {
		final String sql = "insert into user_account(first_name, last_name, birth_date) values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
			            ps.setString(1, userAccount.getFirstName());
			            ps.setString(2, userAccount.getLastName());
			            ps.setDate(3, (java.sql.Date) userAccount.getBirthDate());
			            return ps;
			        }
			    },
			    keyHolder);

		return keyHolder.getKey().intValue();
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		
		return jdbcTemplate.query("select id, first_name, last_name, birth_date from user_account", 
				new RowMapper<UserAccount>() {
					@Override
					public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserAccount account = new UserAccount();
						account.setId(rs.getInt(1));
						account.setFirstName(rs.getString(2));
						account.setLastName(rs.getString(3));
						account.setBirthDate(rs.getDate(4));						
						return account;
					}
				});
	}

	@Override
	public UserAccount getUserAccountById(int id) {
		UserAccount userAccount = null;
		try {
			userAccount = jdbcTemplate.queryForObject("select id, first_name, last_name, birth_date from user_account where id=?", 
					new Object[]{id},
					new RowMapper<UserAccount>() {
						@Override
						public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
							UserAccount account = new UserAccount();
							account.setId(rs.getInt(1));
							account.setFirstName(rs.getString(2));
							account.setLastName(rs.getString(3));
							account.setBirthDate(rs.getDate(4));						
							return account;
						}
					});
		} catch (DataAccessException e) {
			System.err.println(e.getMessage());
		}
		return userAccount;
	}

	@Override
	public void update(UserAccount userAccount) {
		jdbcTemplate.update("update user_account set first_name =? , last_name = ?, birth_date= ? where id=?", 
				new Object[]{
								userAccount.getFirstName(),
								userAccount.getLastName(),
								userAccount.getBirthDate(),
								userAccount.getId()
							});
		
	}

	@Override
	public void delete(UserAccount userAccount) {
		jdbcTemplate.update("delete from user_account where id= ?", 
				new Object[]{ userAccount.getId() });
		
	}

}
