package us.cijian.autumn.mapper;

import org.apache.ibatis.annotations.Param;
import us.cijian.autumn.pojo.KV;
import us.cijian.autumn.pojo.Menu;

import java.util.List;

/**
 * Created by Murphy on 3/18/2015.
 */
public interface SettingsMapper {

    List<KV<String, String>> getByType(@Param("type") String type);

    List<KV<String, String>> getSimpleRoleMapping();

    List<Menu> getAllMenus();

    List<KV<Integer, Integer>> getMenusMapping();

}
