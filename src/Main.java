import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        TestClass tcObj1 = new TestClass("String 11", "String 12");
        TestClass tcObj2 = new TestClass("String 21", "String 22");
        TestClass tcObj3 = new TestClass("String 31", "String 32");

        Method saveMany = null;
        Method saveOne = null;

        Class<?> cl = TestClass.class;
        Method[] methods = cl.getMethods();
        for(Method method: methods){
            if(method.isAnnotationPresent(Saver.class)){
                Saver saverAn = method.getAnnotation(Saver.class);
                if(saverAn.saveMany()){
                    Object[] params = new TestClass[3];
                    params[0] = tcObj1;
                    params[1] = tcObj2;
                    params[2] = tcObj3;
                    boolean result = (Boolean) method.invoke(null, new Object[]{params});
                    System.out.println("Result: "+result);
                }else {
                    boolean result = (Boolean) method.invoke(tcObj1);
                    System.out.println("Result: "+result);
                    result = (Boolean) method.invoke(tcObj2);
                    System.out.println("Result: "+result);
                    result = (Boolean) method.invoke(tcObj3);
                    System.out.println("Result: "+result);
                }

            }
        }

    }
}
