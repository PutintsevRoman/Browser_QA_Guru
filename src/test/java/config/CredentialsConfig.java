package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:credentials.properties")
public interface CredentialsConfig  extends Config {

        @Key("username")
        String username();

        @Key("password")
        String password();

        @Key("app")
        String app();

        @Key("device")
        String device();

        @Key("os_version")
        String os_version();

        @Key("URL")
        String URL();
}
