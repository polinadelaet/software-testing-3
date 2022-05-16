package reader;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile") //ключевое слово которое бывает
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URl = readConfig().getString("url");
    String USER1_LOGIN = readConfig().getString("usersParams.user1.login");
    String USER1_PASSWORD = readConfig().getString("usersParams.user1.password");
}
