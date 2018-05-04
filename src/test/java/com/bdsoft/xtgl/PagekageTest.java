package com.bdsoft.xtgl;

import com.bdsoft.xtgl.utils.packageutil.PackageUtil;

import java.util.Set;

public class PagekageTest {
    public static void  main(String args[]) throws  Exception{
        Set<String> packageSet = PackageUtil.findPackageClass("com.bdsoft.xtgl.entity");
        for(String set : packageSet){
           Class<?> clazz = Class.forName(set);
          System.out.println( clazz.getSimpleName() );
        }
    }
}
