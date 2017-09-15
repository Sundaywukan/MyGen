package com.rongdu.azp.vo.req.zzzz;

import java.lang.Long;
import java.lang.String;


/**
 * @author wuk
 * @version 1.0
 * @createDate：2017.09.14 04:17
 */
public class ZzzzcreateReq {

    private Long id;
    
    private String name;
    
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }

    
}
