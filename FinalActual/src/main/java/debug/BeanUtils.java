

package debug;

import java.lang.reflect.Field;

public class BeanUtils {

    public static String printBeanProperties(Object bean) {
        try {
            // Get the class of the bean
            Class<?> beanClass = bean.getClass();
            
            // Get all declared fields (properties) of the bean
            Field[] fields = beanClass.getDeclaredFields();
            String s = "";
            // Iterate over the fields and print their names and values
            for (Field field : fields) {
                field.setAccessible(true); // Allow access to private fields
                Object value = field.get(bean); // Get the field value
                s = s+(field.getName() + " = " + value); // Print field name and value
            }
            return "s";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "s";
        }
    }
}
