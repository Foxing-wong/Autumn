package us.cijian.autumn.mapper;

import org.apache.ibatis.annotations.Param;
import us.cijian.autumn.pojo.Setting;

import java.util.List;

/**
 * Created by Murphy on 3/18/2015.
 */
public interface SettingsMapper {

    List<Setting> getByType(@Param("type")String type);

}
