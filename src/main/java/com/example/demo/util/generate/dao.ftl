package ${packageName};

import org.springframework.data.jpa.repository.JpaRepository;
import ${modelPackageName}.${modelClassName};

/**
* @desc ${desc}-Dao
* @author ${author}
* @date ${createDate}
*/
public interface ${modelClassName}Dao extends JpaRepository<${modelClassName}, String>{

}