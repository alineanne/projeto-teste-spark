package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;

/**
 *
 * @author ilegra0000190
 */
public interface ActivityRepository {
    public Long add(User user, Project project, Activity activity);
    public void delete(User user, Project project, Activity activity);
    public void update(User user, Project project, Activity activity);
    public List<Activity> listByMonth(User user, Short month);
    
}