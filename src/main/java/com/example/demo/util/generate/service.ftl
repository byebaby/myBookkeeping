<#if !implflag>
    package ${packageName};

    import ${modelPackageName}.${className};

    /**
    * @desc ${desc}-服务接口
    * @author ${author}
    * @date ${createDate}
    */
    public interface ${className}Service {


    }
<#else>
    package ${implPackageName};

    import ${modelPackageName}.${className};
    import ${daoPackageName}.${className}Dao;
    import ${packageName}.${className}Service;
    import org.springframework.stereotype.Service;
    import org.springframework.beans.factory.annotation.Autowired;

    /**
    * @desc ${desc}-服务实现
    * @author ${author}
    * @date ${createDate}
    */
    @Service("${className}Service")
    public class  ${className}ServiceImpl implements  ${className}Service {

    private final ${className}Dao ${className?lower_case}Dao;
    @Autowired
    public ${className}ServiceImpl(${className}Dao ${className?lower_case}Dao) {
    this.${className?lower_case}Dao = ${className?lower_case}Dao;
    }

    }

</#if>