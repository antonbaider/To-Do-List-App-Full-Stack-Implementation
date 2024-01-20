package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.*;
import com.softserve.itacademy.service.StateService;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final ToDoService toDoService;
    private final TaskService taskService;
    private final StateService stateService;
    private final UserService userService;
    @GetMapping("/create/todos/{todo_id}")
    public String create(
            @PathVariable("todo_id") long todoId,
            Model model) {
        ToDo toDo = toDoService.readById(todoId);
        String todo = toDo.getTitle();
        String user = String.format("%s %s", toDo.getOwner().getFirstName(), toDo.getOwner().getLastName());
        model.addAttribute("user", user);
        model.addAttribute("todoId", todoId);
        model.addAttribute("todo", todo);
        model.addAttribute("task", new Task());
        model.addAttribute("priorities", Priority.values());
        return "create-task";
    }

    @PostMapping("/create/todos/{todo_id}")
    public String create(
            Model model, @PathVariable("todo_id") long todoId,
            @ModelAttribute("task") @Valid Task task,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("priorities", Priority.values());
            model.addAttribute("constraintViolations", bindingResult.getFieldErrors());
            return "create-task";
        }

        State state = stateService.readById(5L);
        ToDo toDo = toDoService.readById(todoId);
        task.setTodo(toDo);
        task.setState(state);
        task.setPriority(task.getPriority());

        taskService.create(task);
        return "redirect:/todos/" + todoId + "/tasks";
    }

    @GetMapping("/{task_id}/update/todos/{todo_id}")
    public String update(@PathVariable("task_id") long taskId, @PathVariable("todo_id") long todoId, Model model) {

        Task task = taskService.readById(taskId);
        List<State> allStates = stateService.getAll();
        model.addAttribute("task", task);
        model.addAttribute("priorities", Priority.values());
        model.addAttribute("states", allStates);

        return "update-task";
    }

    @PostMapping("/{task_id}/update/todos/{todo_id}")
    public String update(@PathVariable("task_id") long taskId, @PathVariable("todo_id") long todoId, @ModelAttribute("task") @Valid Task tasks, BindingResult bindingResult, Model model) {

        List<State> allStates = stateService.getAll();
        if (bindingResult.hasErrors()) {
            model.addAttribute("constraintViolations", bindingResult.getFieldErrors());
            model.addAttribute("task", tasks);
            model.addAttribute("priorities", Priority.values());
            model.addAttribute("states", allStates);
            return "update-task";
        }

        State state = stateService.readById(tasks.getState().getId());
        ToDo toDo = toDoService.readById(todoId);
        tasks.setId(taskId);
        tasks.setState(state);
        tasks.setTodo(toDo);
        taskService.update(tasks);
        return "redirect:/todos/" + todoId + "/tasks";

    }

    @GetMapping("/{task_id}/delete/todos/{todo_id}")
    public String delete(@PathVariable("task_id") long taskId, @PathVariable("todo_id") long todoId) {
        taskService.delete(taskId);
        return "redirect:/todos/" + todoId + "/tasks";
    }
}