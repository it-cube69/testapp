package ru.itcube.testapp.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itcube.testapp.model.Test;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TestServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Test> listAllTests() {
        return jdbcTemplate.query("select id, title from tests", new RowMapper<Test>() {
            @Override
            public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
                Test result = new Test();
                result.setId(rs.getLong("id"));
                result.setTitle(rs.getString("title"));
                return result;
            }
        });
    }

    @PostConstruct
    public void doTest() {
        listAllTests().stream().forEach(test -> {
            System.out.println(test.toString());
        });
    }
}
