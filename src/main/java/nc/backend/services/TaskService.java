package nc.backend.services;

import nc.backend.daos.TaskDao;
import nc.backend.dtos.TaskDto;
import nc.backend.entities.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskDao taskDao;

    public TaskService(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    public TaskDto getTask(Long taskId) {
        Task task = taskDao.findByID(taskId);
        return buildTaskDtoFromTask(task);
    }

    private TaskDto buildTaskDtoFromTask(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setAttempts_max(task.getAttempts_max());
        taskDto.setDescription(task.getDescription());
        taskDto.setNumber(task.getNumber());
        taskDto.setTask_name(task.getTask_name());
        taskDto.setSection(task.getSection());
        return taskDto;
    }

}
