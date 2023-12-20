package com.coindesk.demo.services.coindeskservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;

import com.coindesk.demo.services.models.Bitcoin;
import java.sql.PreparedStatement;
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

    public Bitcoin getById(String id) throws DataAccessException {
        String sql = "SELECT * FROM BITCOIN WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BitcoinRowMapper());
    }

    public List<Bitcoin> getAll() throws DataAccessException {
        String sql = "SELECT * FROM BITCOIN";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Bitcoin>(Bitcoin.class));
    }

    public int insert(Bitcoin model) throws DataAccessException {
        String sql = "INSERT INTO BITCOIN (code, codecname, symbol, rate, description, ratefloat, updated, updatediso, updateduk, updatedtw, " +
                     "createdate, moddate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getCode());
            ps.setString(2, model.getCodecname());
            ps.setString(3, model.getSymbol());
            ps.setString(4, model.getRate());
            ps.setString(5, model.getDescription());
            ps.setString(6, model.getRatefloat());
            ps.setString(7, model.getUpdated());
            ps.setString(8, model.getUpdatedISO());
            ps.setString(9, model.getUpdateduk());
            ps.setString(10, model.getUpdatedtw());
            ps.setLong(11, model.getCreatedate());
            ps.setLong(12, model.getModdate());            
            return ps;
        });
    }

    public int update(Bitcoin model) throws DataAccessException {
        String sql = "UPDATE BITCOIN SET code=?, codecname=?, symbol=?, rate=?, description=?, ratefloat=?, " +
                        "updated=?, updatediso=?, updateduk=?, updatedtw=?, createdate=?, moddate=? WHERE id = ?";
        return jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, model.getCode());
            ps.setString(2, model.getCodecname());
            ps.setString(3, model.getSymbol());
            ps.setString(4, model.getRate());
            ps.setString(5, model.getDescription());
            ps.setString(6, model.getRatefloat());
            ps.setString(7, model.getUpdated());
            ps.setString(8, model.getUpdatedISO());
            ps.setString(9, model.getUpdateduk());
            ps.setString(10, model.getUpdatedtw());
            ps.setLong(11, model.getCreatedate());
            ps.setLong(12, model.getModdate());            
            ps.setInt(13, model.getId());
            return ps;
        });
    }

    public void delete(String id) throws DataAccessException{
        String sql = "DELETE FROM bitcoin WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class BitcoinRowMapper implements RowMapper<Bitcoin> {
        @Override
        public Bitcoin mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Bitcoin bitcoin = new Bitcoin();
            bitcoin.setId(rs.getInt("id"));
            bitcoin.setCode(rs.getString("code"));
            bitcoin.setCodecname(rs.getString("codecname"));
            bitcoin.setSymbol(rs.getString("symbol")); 
            bitcoin.setRate(rs.getString("rate"));
            bitcoin.setDescription(rs.getString("description"));
            bitcoin.setRatefloat(rs.getString("ratefloat"));
            bitcoin.setUpdated(rs.getString("updated"));
            bitcoin.setUpdatedISO(rs.getString("updatediso"));
            bitcoin.setUpdateduk(rs.getString("updateduk"));
            bitcoin.setUpdatedtw(rs.getString("updatedtw"));
            bitcoin.setCreatedate(rs.getLong("createdate"));
            bitcoin.setModdate(rs.getLong("moddate"));            
            return bitcoin;
        }
    }
}
