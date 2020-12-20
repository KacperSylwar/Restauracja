package pl.sylwar.Restauracja.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DbConfig {

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }
}
