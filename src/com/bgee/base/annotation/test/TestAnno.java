package com.bgee.base.annotation.test;

import com.bgee.base.annotation.anno.MyAnno;
import com.bgee.base.annotation.anno.MyAnnoField;

import java.lang.reflect.Field;


@MyAnno
public class TestAnno {
    @MyAnno(color="red",name="apple",value="fruit")
      String apple;

    @MyAnnoField("i'm li bai")
    String libai;

    @MyAnno(name="print",value="method")
    void printAnno(){

    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public void setLibai(String libai) {
        this.libai = libai;
    }

    public String getApple() {
        return apple;
    }

    public String getLibai() {
        return libai;
    }

    public static void main(String[] args){
        TestAnno test = new TestAnno();
        MyAnno anno = test.getClass().getAnnotation(MyAnno.class);
        System.out.println(anno.color());
        System.out.println(anno.name());

        System.out.println(anno.value());
        System.out.println("=========================");
        Field  []fields = test.getClass().getDeclaredFields();
        for(Field field : fields){
//            System.out.println(field.getName());
            MyAnnoField annoField = field.getAnnotation(MyAnnoField.class);
            if(annoField != null){
                System.out.println("field[" + field.getName() + "] ->  Annotation:annoField , value:" + annoField.value());
            }

            MyAnno myAnno = field.getAnnotation(MyAnno.class);
            if(myAnno != null){
                System.out.println("field[" + field.getName() + "] ->  Annotation:myAnno , value:" + myAnno.value() + ", name:" + myAnno.name() + ", color:" + myAnno.color());
            }
        }



    }
}

