package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        while (!input.equals("END")){
            //add_999999
            //subtract_19
            //divide_4
            //multiply_2
            //rightShift_1
            //leftShift_3
            String commandName = input.split("_")[0];
            int numb = Integer.parseInt(input.split("_")[1]);
            switch (commandName){
                case "add":
                    executedCommand(clazz, blackBoxInt, innerValue, numb,"add",methods);
                    break;
                case "subtract":
                    executedCommand(clazz, blackBoxInt, innerValue, numb,"subtract",methods);
                    break;
                case "divide":
                    executedCommand(clazz, blackBoxInt, innerValue, numb,"divide",methods);
                    break;
                case "multiply":
                    executedCommand(clazz, blackBoxInt, innerValue, numb,"multiply",methods);
                    break;
                case "rightShift":
                    executedCommand(clazz, blackBoxInt, innerValue, numb,"rightShift",methods);
                    break;
                case "leftShift":
                    executedCommand(clazz, blackBoxInt, innerValue, numb,"leftShift",methods);
                    break;
            }

            input = scanner.nextLine();
        }

    }

    private static void executedCommand(Class<BlackBoxInt> clazz, BlackBoxInt blackBoxInt, Field innerValue, int numb,String command,List<Method> methods) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method currentMethod = null;
        for(Method method : methods){
            if(method.getName().equals(command)){
                currentMethod = method;
                break;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(blackBoxInt,numb);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
