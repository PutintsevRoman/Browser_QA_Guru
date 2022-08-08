package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:real.properties")
public interface RealConfig extends Config {

    @Config.Key("os_name")
    String os_name();

    @Config.Key("device")
    String device();

    @Config.Key("os_version")
    String os_version();

    @Config.Key("URL")
    String URL();
}
