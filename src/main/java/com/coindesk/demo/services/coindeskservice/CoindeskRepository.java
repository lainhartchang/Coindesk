package com.coindesk.demo.services.coindeskservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;

import com.coindesk.demo.services.models.Bitcoin;

import java.sql.PreparedStatement;
// import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.List;

//import java.sql.SQLException;

@Service
public class CoindeskRepository implements ICoindeskRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Autowired
    public CoindeskRepository() {
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Bitcoin getById(String id)  throws DataAccessException  {
        String sql = "SELECT * FROM bitcoin WHERE code = ?";
        return jdbcTemplate.queryForObject(sql, Bitcoin.class);
    }

    public List<Bitcoin> getAll() throws DataAccessException {
        String sql = "SELECT * FROM bitcoin";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Bitcoin>(Bitcoin.class));
    }

    public int insert(Bitcoin model) throws DataAccessException {
        String sql = "INSERT INTO bitcoin VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getCode());
            ps.setString(2, model.getCodecname());
            ps.setString(3, model.getSymbol());
            ps.setBigDecimal(4, model.getRate());
            ps.setString(5, model.getDescription());
            ps.setBigDecimal(6, model.getRatefloat());
            ps.setString(7, model.getUpdated());
            ps.setString(8, model.getUpdatedISO());
            ps.setString(9, model.getUpdateduk());
            ps.setLong(10, model.getCreatedate());
            ps.setLong(11, model.getModdate());            
            return ps;
        });
    }

    public int update(Bitcoin model) throws DataAccessException {
        String sql = "UPDATE Bitcoin SET name = ?, price = ? WHERE id = ?";        
        return jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getCode());
            ps.setString(2, model.getCodecname());
            ps.setString(3, model.getSymbol());
            ps.setBigDecimal(4, model.getRate());
            ps.setString(5, model.getDescription());
            ps.setBigDecimal(6, model.getRatefloat());
            ps.setString(7, model.getUpdated());
            ps.setString(8, model.getUpdatedISO());
            ps.setString(9, model.getUpdateduk());
            ps.setLong(10, model.getCreatedate());
            ps.setLong(11, model.getModdate());            
            return ps;
        });
    }

    public void delete(String id) throws DataAccessException{
        String sql = "DELETE FROM bitcoin WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
