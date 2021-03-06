package duong.cg.configuration;

import duong.cg.repository.customer.CustomerRepository;
import duong.cg.repository.ICustomerRepository;
import duong.cg.repository.deposit.DepositRepository;
import duong.cg.repository.deposit.IDepositRepository;
import duong.cg.repository.ITransferRepository;
import duong.cg.repository.transfer.TransferRepository;
import duong.cg.repository.IWithdrawRepository;
import duong.cg.repository.withdraw.WithdrawRepository;
import duong.cg.service.customer.CustomerService;
import duong.cg.service.customer.ICustomerService;
import duong.cg.service.deposit.DepositService;
import duong.cg.service.deposit.IDepositService;
import duong.cg.service.transfer.ITransferService;
import duong.cg.service.transfer.TransferService;
import duong.cg.service.withdraw.IWithdrawService;
import duong.cg.service.withdraw.WithdrawService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableSpringDataWebSupport
@EnableJpaRepositories("duong.cg.repository")
@ComponentScan("duong.cg")
public class AppConfig implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //C???u h??nh Thymleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    //C???u h??nh JPA
    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("duong.cg.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/banking_transaction_management");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        return properties;
    }

    @Bean
    public ICustomerRepository customerRepository() {
        return new CustomerRepository();
    }

    @Bean
    public ICustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    public IDepositRepository depositsRepository() {
        return new DepositRepository();
    }

    @Bean
    public IDepositService depositsService() {
        return new DepositService();
    }

    @Bean
    public IWithdrawRepository withdrawRepository() {
        return new WithdrawRepository();
    }

    @Bean
    public IWithdrawService withdrawService(){
        return new WithdrawService();
    }

    @Bean
    public ITransferRepository transferRepository() {
        return new TransferRepository();
    }

    @Bean
    public ITransferService transferService(){
        return new TransferService();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/") ;
        registry.addResourceHandler("/tools/**").addResourceLocations("/tools/");


    }




}
