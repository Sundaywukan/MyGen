package ${packageName}.vo.req.${modelName};

<#list cols as col> 
import ${col.typeClass};
</#list>


/**
 * @author ${author}
 * @version 1.0
 * @createDate：${createDate}
 */
public class ${className} {

	<#list cols as col> 
    private ${col.type} ${col.name};
    
    </#list>
    <#list cols as col> 
    
    public void set${col.name?cap_first}(${col.type} ${col.name}){
        this.${col.name} = ${col.name};
    }
    
    public ${col.type} get${col.name?cap_first}(){
        return this.${col.name};
    }
     </#list>

    
}
