package com.hry.component.javaassist;

import javassist.*;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.Mnemonic;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import org.junit.Test;
import test.Hello;

import java.io.IOException;

/**
 * @author: huangrongyou@yixin.im
 * @date: 2019/11/28 11:31
 */
public class DemoTest {

    @Test
    public void readWrite() throws NotFoundException, CannotCompileException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, BadBytecode {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("test.Rectangle");
        cc.setSuperclass(pool.get("test.Point"));
        // 可以指定重写的目录
        cc.writeFile("D;/");
        cc.writeFile();

        // 定义新类
        CtClass newCls = pool.makeClass("NewCreatePoint");
        newCls.writeFile();

        // 增加额外的扫描路径
        pool.insertClassPath(new ClassClassPath(this.getClass()));

        // 拷贝一个已经存在的类来定义一个新的类
        cc = pool.get("test.Point");
        cc.setName("NewPoint");
        cc.writeFile();

        // 在加载时修改字节码前，修改字节码
        ClassPool cp = ClassPool.getDefault();
        cc = cp.get("test.Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("{ System.out.println(\"Hello.say():\"); }");
        m.instrument(new ExprEditor(){
            @Override
            public void edit(MethodCall m) throws CannotCompileException {
                super.edit(m);
            }
        });

        // 打印指令
        CodeIterator ci = cc.getClassFile().getMethod("say").getCodeAttribute().iterator();
        while (ci.hasNext()) {
            int index = ci.next();
            int op = ci.byteAt(index);
            System.out.println(" " + Mnemonic.OPCODE[op]);
        }


        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();

        // 这里test.ClassloadTmp都是由同一个 app ClassLoader 加载，无法演示不同ClassLoader的加载从而跑出异常的情况
//        ClassLoader classLoader = new ClassLoader() {
//            @Override
//            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                return super.loadClass(name);
//            }
//        };
//
//        Class clazz = classLoader.loadClass("test.ClassloadTmp");
//        System.out.println(clazz.getClassLoader());
//        Object obj = clazz.newInstance();
//        ClassloadTmp b = (ClassloadTmp)obj;    // this always throws ClassCastException.

    }


    @Test
    public void classLoad() throws Throwable {
        Translator t = new MyTranslator();
        ClassPool pool = ClassPool.getDefault();
        Loader cl = new Loader();
        cl.addTranslator(pool, t);
        cl.run("test.Main", new String[]{"aa"});

    }

    @Test
    public void classLoader2() throws NotFoundException, CannotCompileException, IOException, NoSuchFieldException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("java.lang.String");
        CtField f = new CtField(CtClass.intType, "hiddenValue", cc);
        f.setModifiers(Modifier.PUBLIC);
        cc.addField(f);
        cc.writeFile(".");

        System.out.println(String.class.getField("hiddenValue").getName());


    }



    public class MyTranslator implements Translator {
        public void start(ClassPool pool) throws NotFoundException, CannotCompileException {}
        public void onLoad(ClassPool pool, String classname) throws NotFoundException, CannotCompileException {
            CtClass cc = pool.get(classname);
            cc.setModifiers(Modifier.PUBLIC);
            System.out.println("onLoad");
        }
    }

}
