package nl.springMvc;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {

    public static int roundDoubleToInt(double d) {
        if ((d % 1) != 0) {
            if ((int) Math.round(d) == 0) {
                return 1;
            }
            return (int) Math.round(d);
        }
        return (int) d;
    }

    public static String parseDateDMY(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date));
        return localDate.format(formatter).toString();
    }

    public static String getUrlWithParams(HttpServletRequest httpServletRequest){
        String requestURI = httpServletRequest.getRequestURI();
        String queryString = httpServletRequest.getQueryString();
        if(StringUtils.isEmpty(queryString) || StringUtils.isBlank(queryString)){
            return requestURI;
        }
        return requestURI+"?"+queryString;
    }


    public static String getUrl(String baseUrl, HttpServletRequest httpServletRequest){
        String requestURI = baseUrl;
        String queryString = httpServletRequest.getQueryString();
        if(StringUtils.isEmpty(queryString) || StringUtils.isBlank(queryString)){
            return requestURI;
        }
        return requestURI+"?"+queryString;
    }



    public static String addStringParamToUrl(String urlStr, String paramName, String param) {
        if (StringUtils.isNotBlank(param) && StringUtils.isNotEmpty(param)) {
            if (StringUtils.isNotEmpty(urlStr)) {
                return String.join("", urlStr, "&", paramName, "=", param);
            } else if (StringUtils.isEmpty(urlStr)) {
                return String.join("", urlStr, "?", paramName, "=", param);
            }
        }
        return urlStr;
    }

    public static String addIntegerParamToUrl(String urlStr, String paramName, Integer param) {
        if (param != null && param != 0) {
            if (StringUtils.isNotEmpty(urlStr)) {
                return String.join("", urlStr, "&", paramName, "=", String.valueOf(param));
            } else if (StringUtils.isEmpty(urlStr)) {
                return String.join("", urlStr, "?", paramName, "=", String.valueOf(param));
            }
        }
        return urlStr;
    }
}
