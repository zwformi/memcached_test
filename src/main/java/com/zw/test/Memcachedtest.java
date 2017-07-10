package com.zw.test;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.zw.bean.person;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/10.
 */
public class Memcachedtest {
    public static MemCachedClient GetMemcachedClient(){
        MemCachedClient client=new MemCachedClient();
        String [] addr ={"127.0.0.1:11211"};
        Integer [] weights = {3};
        SockIOPool pool = SockIOPool.getInstance();
        pool.setServers(addr);
        pool.setWeights(weights);
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(200);
        pool.setMaxIdle(1000*30*30);
        pool.setMaintSleep(30);
        pool.setNagle(false);
        pool.setSocketTO(30);
        pool.setSocketConnectTO(0);
        pool.initialize();
        return client;
    }

    public static void main(String[] args) {
        MemCachedClient client=GetMemcachedClient();
//      String [] s  =pool.getServers();
//      将数据放入缓存
        client.set("test2","test2");

//      将String数据放入缓存,并设置失效时间
        Date date=new Date(2000000);
        client.set("test1","test1", date);
//将bean存入缓存
        person p=new person();
        p.setName("zw");
        p.setAge(20);
        client.set("p1",p, date);
//      删除缓存数据
       client.delete("test1");

//      获取缓存数据
        String str =(String)client.get("test2");
        System.out.println(str);

        person p1 =(person)client.get("p1");
        System.out.println(p1.toString());

    }
    }
