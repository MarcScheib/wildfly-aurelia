package de.legendsrising.servlet.producer;

import de.legendsrising.servlet.qualifier.DefaultValue;
import de.legendsrising.servlet.qualifier.RequestParam;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Dependent
public class RequestParamProducer
{
    @Inject
    private HttpServletRequest request;

    @Produces
    @RequestParam
    protected String getRequestParam(InjectionPoint ip)
    {
        String parameterName = this.getParameterName(ip);
        String paramValue = this.getParameterValue(parameterName, ip);

        return paramValue;
    }

    private String getParameterName(InjectionPoint ip)
    {
        String parameterName = ip.getAnnotated().getAnnotation(RequestParam.class).value();
        if ("".equals(parameterName))
        {
            parameterName = ip.getMember().getName();
        }

        return parameterName;
    }

    private String getParameterValue(String parameterName, InjectionPoint ip)
    {
        if (this.request.getParameterMap().containsKey(parameterName))
        {
            return this.request.getParameter(parameterName);
        }

        return this.getDefaultValue(ip);
    }

    private String getDefaultValue(InjectionPoint ip)
    {
        DefaultValue defaultValue = ip.getAnnotated().getAnnotation(DefaultValue.class);

        if (defaultValue != null)
        {
            return defaultValue.value();
        }

        return null;
    }
}
