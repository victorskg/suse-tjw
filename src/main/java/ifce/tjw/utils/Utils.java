package ifce.tjw.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Utils {

    public static void populateBean(Object formBean, HttpServletRequest request) {
        populateBean(formBean, request.getParameterMap());
    }

    private static void populateBean(Object bean, Map<String, String[]> prop) {
        try {
            BeanUtils.populate(bean, prop);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
