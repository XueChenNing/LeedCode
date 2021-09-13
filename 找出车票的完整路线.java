package com.xue.stack;
import java.util.HashMap;
import java.util.Map;
/**
 * 给出你几张车票。让你根据这几张车票找出完整的路线，以及路线不存在环路
 * 这道题的关键就是找出路程的起点
 * 这里我们使用的方法就是使用两个HashMap,第一个用key来存起点，用value来存终点
 * 第二个用key来存终点，用key来存起点
 * 比那里第二个HashMap多有key，看看第二个HashMap的key中不包含第一个HashMap的key,那么这个key一定就是路程的起点
 * 然后，狗具有这个起点找出所有的路程
 *
 */
public class 找出车票的完整路线 {
    public void getRoute(Map<String,String> map){
        Map<String,String> reverseMap = new HashMap<>();
        for(Map.Entry entry:map.entrySet()){
            reverseMap.put(entry.getValue().toString(),entry.getValue().toString());
        }

        String start = null;
        String end = null;

        //下面找出起点
        for(Map.Entry entry:map.entrySet()){
            if(!reverseMap.containsKey(entry.getKey())){
                start = entry.getKey().toString();
            }
        }
        end = map.get(start);
//        System.out.println(start+">>"+end);
//        end = map.get(end);
//        System.out.println(">>"+end);
//        while(end!=null);


        //根据找出的起点，一次遍历hashMap来找出总路程
        if(start==null){
            System.out.println("输入数据错误");
        }else{
            System.out.print(start+">>");
            while(end!=null){
                System.out.print(end+">>");
                end = map.get(end);
            }
        }

    }
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("XiAn","ChengDu");
        map.put("BeiJing","ShangHai");
        map.put("DaLian","XiAn");
        map.put("ShangHai","DaLian");
        找出车票的完整路线 ss = new 找出车票的完整路线();
        ss.getRoute(map);
    }
}
