package com.ilegra.jt.lancamentodehoras.config;

import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.model.Group;
import com.ilegra.jt.lancamentodehoras.model.ActivityType;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;

public class Memory {

    public static List<User> users = new ArrayList<>();
    public static List<Activity> activities = new ArrayList<>();
    public static List<Project> projects = new ArrayList<>();
    public static List<SubProject> subProjects = new ArrayList<>();
    public static List<Group> groups = new ArrayList<>();
    public static List<ActivityType> activityType = new ArrayList<>();

    public static void start() {

        users.add(new User("marcelo", "123"));
        users.add(new User("admin", "123"));

        Project project1 = new Project(0, "Projeto teste 1");
        projects.add(project1);

        Project project2 = new Project(1, "Projeto teste 2");
        projects.add(project2);

        Project project3 = new Project(2, "Projeto teste 3");
        projects.add(project3);

        SubProject subProject1 = new SubProject(0, "SubProjeto teste 1");
        subProjects.add(subProject1);

        SubProject subProject2 = new SubProject(1, "SubProjeto teste 2");
        subProjects.add(subProject2);

        SubProject subProject3 = new SubProject(2, "SubProjeto teste 3");
        subProjects.add(subProject3);
        
        Group group1 = new Group(0,"Grupo teste 1");
        groups.add(group1);
        
        Group group2 = new Group(1,"Grupo teste 2");
        groups.add(group2);
        
        Group group3 = new Group(2,"Grupo teste 3");
        groups.add(group3);
        
        ActivityType activityType1 = new ActivityType(0 ,"Tipo teste 1");
        activityType.add(activityType1);
        
        ActivityType activityType2 = new ActivityType(1 ,"Tipo teste 2");
        activityType.add(activityType2);
        
        ActivityType activityType3 = new ActivityType(2 ,"Tipo teste 3");
        activityType.add(activityType3);
        

        Activity activity1 = new Activity();
        activity1.setId(0);
        activity1.setDescription("Atividade descricao 1");
        activity1.setProject(project1);
        activity1.setSubProject(subProject1);
        activity1.setGroup(group1);
        activity1.setActivityType(activityType1);
        activity1.setStartHour(LocalDateTime.of(2014, Month.JUNE, 12, 17, 0));
        activity1.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 12, 18, 0));
        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setId(1);
        activity2.setDescription("Atividade descricao 2");
        activity2.setProject(project2);
        activity2.setSubProject(subProject2);
        activity2.setGroup(group2);
        activity2.setActivityType(activityType2);
        activity2.setStartHour(LocalDateTime.of(2014, Month.JUNE, 13, 9, 0));
        activity2.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 13, 11, 0));
        activities.add(activity2);

        Activity activity3 = new Activity();
        activity3.setId(2);
        activity3.setDescription("Atividade descricao 3");
        activity3.setProject(project3);
        activity3.setSubProject(subProject3);
        activity3.setGroup(group3);
        activity3.setActivityType(activityType3);
        activity3.setStartHour(LocalDateTime.of(2014, Month.JUNE, 13, 9, 0));
        activity3.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 13, 11, 0));
        activities.add(activity3);

    }

}
