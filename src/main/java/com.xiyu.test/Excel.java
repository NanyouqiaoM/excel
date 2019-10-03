package com.xiyu.test;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import sun.util.calendar.Gregorian;

import java.lang.reflect.Field;
import java.util.*;

public class Excel {
    List<List<String>> datas=new ArrayList<List<String>>();
    List<String> list = new ArrayList<String>();

    @Test
    public void simpleWrite() {
        bianLiTest();
        // 写法1
        String fileName = "E:\\xiyu/test.xlsx";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, List.class).sheet("模板").doWrite(datas);

        // 写法2
     /*   fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去读
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(data(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();*/
    }

    private List<Demo> data() {
        List<Demo> list = new ArrayList<Demo>();
        for (int i = 0; i < 10; i++) {
            Demo data = new Demo();
            data.setName("臭鱼" + i);
            data.setDate(new Date());
            data.setMoney(9999.0);
            data.setDesc(new Desc(11.0, 250.0));
            List<Hobby> hobbyList=new ArrayList<Hobby>();
            hobbyList.add(new Hobby("说唱",99));
            hobbyList.add(new Hobby("rap",98));
            hobbyList.add(new Hobby("篮球",97));
            data.setHobbyList(hobbyList);
            list.add(data);
        }
        return list;
    }


    private Map<String, List> datas() {
        Map<String, List> map = new HashMap<String, List>();
        map.put("demo", data());
        return map;
    }

   // @Test
    public void bianLiTest() {
    //    System.out.println(data().get(0).getDate().getClass());
        for (Demo demo :data()
             ) {
            bianLi(demo);
            datas.add(list);
            list=new ArrayList<String>();
        }


        System.out.println(datas);
    }

    private void bianLi(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();

            //  String varValue=
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o;

                try {
                    o = fields[i].get(obj);
                    if (o.getClass().equals(ArrayList.class)) {
                        List<Object> objectList= (List<Object>) o;
                        for (Object object:objectList
                             ) {
                            bianLi(object);
                        }
                        continue;
                    }
                    if (baseType(o)) {
                        System.err.println("传入的对象中包含一个如下的变量：" + varName + " = " + o + "==" + o.getClass());
                        list.add(String.valueOf(o));
                    } else {

                        bianLi(o);
                    }


                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 判断传入类是否数据基本类型，是返回true
     * @param obj
     * @return
     */
    private boolean baseType(Object obj) {
        return obj.getClass().equals(String.class)||obj.getClass().equals(Date.class)
                || obj.getClass().equals(Byte.class) || obj.getClass().equals(byte.class)
                || obj.getClass().equals(Long.class) || obj.getClass().equals(long.class)
                || obj.getClass().equals(Float.class) || obj.getClass().equals(float.class)
                || obj.getClass().equals(Integer.class) || obj.getClass().equals(int.class)
                || obj.getClass().equals(Short.class) || obj.getClass().equals(short.class)
                || obj.getClass().equals(Double.class) || obj.getClass().equals(double.class)
                || obj.getClass().equals(Character.class) || obj.getClass().equals(char.class)
                || obj.getClass().equals(Boolean.class) || obj.getClass().equals(boolean.class);
    }
}
