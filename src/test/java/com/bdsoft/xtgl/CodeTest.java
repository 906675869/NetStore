package com.bdsoft.xtgl;

import java.util.regex.Pattern;

public class CodeTest {
    public String codeTest(String []strs){
        Pattern p = Pattern.compile(
                "^(?![A-Za-z]+$)(?![A-Z\\d]+$)(?![A-Z\\W]+$)(?![a-z\\d]+$)(?![a-z\\W]+$)(?![\\d\\W]+$)\\S{8,20}$");
        for(String str : strs){
            if(!p.matcher(str).find()){
                return "NG";
            }
        }
        for(int i =0 ;i<strs.length ;i++){
            for(int j=i+1 ;j<strs.length;j++){
                if(strs[i].equals(strs[j])){
                    return "NG";
                }
            }
        }
        return "OK";
    }
}
