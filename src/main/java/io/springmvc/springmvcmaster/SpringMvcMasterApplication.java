package io.springmvc.springmvcmaster;

import io.springmvc.springmvcmaster.reflect.ReflectExecutor;
import io.springmvc.springmvcmaster.reflect.ReflectFieldManager;
import io.springmvc.springmvcmaster.reflect.ReflectMethodManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringMvcMasterApplication {

//      base
      //   public static void main(String[] args) {
//        SpringApplication.run(SpringMvcMasterApplication.class, args);
//    }

//      reflect test 1
//      public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//
//
//            System.out.println("*class");
//            Class<?> aClass = Class.forName("java.util.ArrayList");

      /// /        Class<?> aClass= ArrayList.class;
      /// /        Class<?> aClass= new ArrayList().getClass();
//
//            System.out.println(aClass.getName());
//            System.out.println(aClass.getSuperclass());
//            System.out.println();
//            System.out.println("impl interface");
//            for (Class<?> anInterface : aClass.getInterfaces()) {
//                  System.out.println(anInterface.getName());
//            }
//
//            System.out.println();
//
//
//            System.out.println("*obj construct , obj instance");
//            Class<ReflectTarget> itachiShadow = ReflectTarget.class;
//            //issue
//            Constructor<ReflectTarget> constructor = itachiShadow.getConstructor(String.class, Integer.class);
//            ReflectTarget itachi = constructor.newInstance("itachi", 21);
//
//            System.out.println(itachi);
//
//            System.out.println();
//            System.out.println("*field");
//
//            //how to accumulate filed name, field value to map
//            Arrays.stream(itachi.getClass().getDeclaredFields())
//                        .forEach(f -> {
//                              try {
//                                    System.out.println("f.getName() = " + f.getName());
//                                    f.setAccessible(true);
//                                    System.out.println("f.get(itachi) = " + f.get(itachi));
//                                    if (f.getType().equals(Integer.class)) {
//                                          f.set(itachi, (Integer) f.get(itachi) + 1);
//                                          System.out.println("f.get(itachi) = " + f.get(itachi));
//                                    }
//
//                              } catch (Exception e) {
//                                    System.err.println(e.getMessage());
//                              }
//
//                        });
//
//            System.out.println();
//            System.out.println("*method");
//
//            Class<?> izumiShadow = Class.forName("io.springmvc.springmvcmaster.ReflectTarget");
//            Object izmui = izumiShadow.getDeclaredConstructor(String.class, Integer.class)
//                        .newInstance("Izumi", 30);
//
//
//            Method setName = izumiShadow.getDeclaredMethod("setName", String.class);
//            setName.invoke(izmui, "Izumi");
//
//            Method ageSetter = izumiShadow.getDeclaredMethod("setAge", Integer.class);
//            ageSetter.invoke(izmui, itachi.getAge() - 1);
//
//            Method izmuisTostring = izumiShadow.getDeclaredMethod("toString");
//            System.out.println("izmui"+izmuisTostring.invoke(izmui));
//
//      }





//      reflect test 2
      public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            Class<?> target = Class.forName("io.springmvc.springmvcmaster.reflect.ReflectTarget");
            Constructor<?> targetConstruct = target.getDeclaredConstructor(String.class, Integer.class);
            Object itcahi = targetConstruct.newInstance("itachi", 21);


            final ReflectExecutor reflectExecutor = new ReflectExecutor(
                        new ReflectFieldManager(target),
                        new ReflectMethodManager(target)
            );

            ReflectFieldManager reflectFieldManager = reflectExecutor.getReflectFieldManager();
            reflectFieldManager.setField(itcahi, "name", "izmui");
            ReflectMethodManager reflectMethodManager = reflectExecutor.getReflectMethodManager();
            reflectMethodManager.invokeMethod(itcahi, "getName");

            Object name = reflectFieldManager.getFieldValue(itcahi, "name");
            System.out.println("itachi name is " + name);

      }
}

