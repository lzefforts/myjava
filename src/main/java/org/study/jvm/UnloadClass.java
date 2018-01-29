package org.study.jvm;

import aj.org.objectweb.asm.ClassWriter;
import aj.org.objectweb.asm.MethodVisitor;
import aj.org.objectweb.asm.Opcodes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO 未运行起来
 * 类加载机制测试
 * Created by ArnoldLee on 17/10/26.
 */
public class UnloadClass implements Opcodes{


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(V1_7,ACC_PUBLIC,"Example",null,"java/lang/Object",null);
        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC,"<init>","()V",null,null);
        methodVisitor.visitVarInsn(ALOAD,0);
        methodVisitor.visitMethodInsn(INVOKESPECIAL,"java/lang/Object","<init>","()V");
        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();

        methodVisitor = classWriter.visitMethod(ACC_PUBLIC+ACC_STATIC,"main","([Ljava/lang/String;)V",null,null);
        methodVisitor.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream");
        methodVisitor.visitLdcInsn("Hello World");
        methodVisitor.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","([Ljava/lang/String;)V");
        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(0,0);
        methodVisitor.visitEnd();

        byte[] code = classWriter.toByteArray();
        for(int i=0;i<10;i++){
            UnloadClassLoader loader = new UnloadClassLoader();
            Method method = ClassLoader.class.getDeclaredMethod("defineClass",String.class,byte[].class,int.class,int.class);
            method.setAccessible(true);
            method.invoke(loader,"Example",code,0,code.length);
            method.setAccessible(false);
            System.gc();
        }





    }

}
