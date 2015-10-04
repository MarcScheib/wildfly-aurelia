package de.legendsrising.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Dependent
public class Loggers
{
    @Produces
    public Logger getLogger(InjectionPoint injectionPoint)
    {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getSimpleName());
    }
}