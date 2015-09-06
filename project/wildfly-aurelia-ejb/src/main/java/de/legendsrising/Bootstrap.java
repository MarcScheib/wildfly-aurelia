package de.legendsrising;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class Bootstrap {
    @Inject
    private Logger logger;

    @PostConstruct
    public void init() {
        this.logger.info("Bootstrapping...");
    }
}
