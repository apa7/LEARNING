package com.enjoy.spi;

import com.alibaba.dubbo.common.compiler.support.JavassistCompiler;
import javassist.*;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * javassist的使用示例
 */
public class JavassistTest {

    /**
     * javassist动态生成类示例
     */
    @Test
    public void createClassObj() throws NotFoundException, CannotCompileException,
            IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        // ClassPool：Class对象的容器
        ClassPool pool = ClassPool.getDefault();

        // 通过ClassPool生成一个public类
        CtClass ctClass = pool.makeClass("com.enjoy.service.DemoImpl");

        // 添加属性 private String name
        CtField nameFild = new CtField(pool.getCtClass("java.lang.String"), "name", ctClass);
        nameFild.setModifiers(Modifier.PRIVATE);
        ctClass.addField(nameFild);

        // 添加属性 private int age
        CtField ageField = new CtField(pool.getCtClass("int"), "age", ctClass);
        ageField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(ageField);

        // 为属性name和age添加getXXX和setXXX方法
        ctClass.addMethod(CtNewMethod.getter("getName", nameFild));
        ctClass.addMethod(CtNewMethod.setter("setName", nameFild));
        ctClass.addMethod(CtNewMethod.getter("getAge", ageField));
        ctClass.addMethod(CtNewMethod.setter("setAge", ageField));

        // 添加方法  void sayHello(String name) {...}
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "sayHello", new CtClass[] {}, ctClass);
        // 方法设置为PUBLIC
        ctMethod.setModifiers(Modifier.PUBLIC);
        // 方法体
        ctMethod.setBody("{\nSystem.out.println(\"hello \" + getName() + \" !\");\n}");
        ctClass.addMethod(ctMethod);

        //生成class类
        Class<?> clazz = ctClass.toClass();
        //创建对象
        Object obj = clazz.newInstance();
        //反射 执行方法sayHello
        obj.getClass().getMethod("setName", new Class[] {String.class})
                .invoke(obj, new Object[] {"peter"});
        obj.getClass().getMethod("sayHello", new Class[] {})
                .invoke(obj, new Object[] {});

    }

    /**
     * javassist动态编译类示例
     */
    @Test
    public void createClassByCompile()
            throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {
        JavassistCompiler compiler = new JavassistCompiler();
        Class<?> clazz = compiler.compile("public class DemoImpl implements DemoService {     public String sayHello(String name) {        System.out.println(\"hello \" + name);        return \"Hello, \" + name;   }}",JavassistTest.class.getClassLoader());
        //创建对象
        Object obj = clazz.newInstance();
        //反射 执行方法sayHello
        obj.getClass().getMethod("sayHello", new Class[] {String.class}).invoke(obj, new Object[] {"peter"});
    }

}
