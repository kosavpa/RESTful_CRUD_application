package Configs.DataConfig;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Component
public class FlyWayConfig {

    private String url;
    private String user;
    private String password;

    @PostConstruct
    public void init(){
        Properties properties = new Properties();

        try(FileInputStream fis = new FileInputStream("D:\\java\\java_applications\\TestQuestion\\src\\main\\resources\\myFlywayConfig.properties")){
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        url = properties.getProperty("flyway.url");
        user = properties.getProperty("flyway.user");
        password = properties.getProperty("flyway.password");

        Flyway.configure().dataSource(url, user, password).baselineOnMigrate(true).load().migrate();
    }
}
