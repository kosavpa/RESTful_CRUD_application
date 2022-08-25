package Configs.SpingWebConfig;

import Configs.DataConfig.FlyWayConfig;
import Configs.DataConfig.HibernateUtil;
import Controllers.MainController;
import DAO.PersonDAO;
import DAO.PersonDAOImpl;
import Service.PersonService;
import Service.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public MainController getRestControllers(){
        return new MainController();
    }

    @Bean
    public HibernateUtil getHibernateUtil(){
        return new HibernateUtil();
    }

    @Bean
    public PersonDAO getPersonDAO(){
        return new PersonDAOImpl(getHibernateUtil());
    }

    @Bean
    public PersonService getPersonService(){
        return new PersonServiceImpl(getPersonDAO());
    }

    @Bean
    public FlyWayConfig getFlywayConfig(){
        return new FlyWayConfig();
    }
}
