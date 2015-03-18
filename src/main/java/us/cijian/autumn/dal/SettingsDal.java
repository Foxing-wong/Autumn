package us.cijian.autumn.dal;

import us.cijian.autumn.config.Inject;
import us.cijian.autumn.mapper.SettingsMapper;

import java.util.Map;

/**
 * Created by Murphy on 3/19/2015.
 */
public class SettingsDal implements AbstractDal {


    @Inject
    SettingsMapper mapper;

    @Override
    public Map<String, Object> data() {
        mapper.fetchAll();
        return null;
    }
}
