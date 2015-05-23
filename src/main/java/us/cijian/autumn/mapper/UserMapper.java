package us.cijian.autumn.mapper;

import org.apache.ibatis.annotations.Param;
import us.cijian.autumn.pojo.User;

/**
 * Created by MurphyL on 2015/5/24.
 */
public interface UserMapper {

    User getByName(@Param("name") String name);

}
