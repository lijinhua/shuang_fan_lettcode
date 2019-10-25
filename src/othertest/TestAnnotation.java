package othertest;


import java.lang.reflect.Method;

public class TestAnnotation {

    public static void main(String[] args){
        System.out.println(UserManager.class.getName());
//        Method[] methods = UserManager.class.getMethods();
//        for (Method method : methods){
//            System.out.println(getMethodId(method));
//        }
    }

    public static String getMethodId(Method method) {
        MethodId methodId = method.getAnnotation(MethodId.class);
        if (methodId != null) {
            return methodId.value();
        } else {
            StringBuilder result = new StringBuilder(method.getName());
            result.append('(').append(getMethodParameters(method.getParameterTypes())).append(')');
            return result.toString();
        }
    }

    public static String getMethodParameters(Class<?>[] classes) {
        StringBuilder result = new StringBuilder();
        int length = classes.length;
        if (length == 0) {
            return result.toString();
        }
        result.append(getClassName(classes[0]));
        for (int i = 1; i < length; ++i) {
            result.append(",").append(getClassName(classes[i]));
        }
        return result.toString();
    }

    //boolean, byte, char, short, int, long, float, and double void
    private static String getClassName(Class<?> clazz) {
        if (clazz == Boolean.class) {
            return "boolean";
        } else if (clazz == Byte.class) {
            return "byte";
        } else if (clazz == Character.class) {
            return "char";
        } else if (clazz == Short.class) {
            return "short";
        } else if (clazz == Integer.class) {
            return "int";
        } else if (clazz == Long.class) {
            return "long";
        } else if (clazz == Float.class) {
            return "float";
        } else if (clazz == Double.class) {
            return "double";
        } else if (clazz == Void.class) {
            return "void";
        } else {
            return clazz.getName();
        }
    }
}
