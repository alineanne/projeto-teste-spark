package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;

public interface ActivityRepository {

    public Long add(User user, Activity activity);

    public void delete(User user, Activity activity);

    public void update(User user, Activity activity);

    public List<Activity> listByMonth(User user, Short month);

    public List<Activity> listAll();
}
