package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.RoleService;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/todos")
public class ToDoController {

    private final UserService userService;
    private final ToDoService toDoService;
    private final TaskService taskService;

    //    @GetMapping("/create/users/{owner_id}")
//    public String create(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
//    @PostMapping("/create/users/{owner_id}")
//    public String create(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
    @GetMapping("/{id}/tasks")
    public String read(@PathVariable("id") long todoId, Model model) {
        List<Task> tasks = taskService.getByTodoId(todoId);
        model.addAttribute("tasks", tasks);
        ToDo toDo = toDoService.readById(todoId);
        model.addAttribute("collaborators", toDo.getCollaborators());
        model.addAttribute("todo", toDo);
        model.addAttribute("users", userService.getAll());
        return "todo-tasks";
    }
//
//    @GetMapping("/{todo_id}/update/users/{owner_id}")
//    public String update(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
//    @PostMapping("/{todo_id}/update/users/{owner_id}")
//    public String update(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
//    @GetMapping("/{todo_id}/delete/users/{owner_id}")
//    public String delete(//add needed parameters) {
//                         // ToDo
//        return " ";
//    }
//
    @GetMapping("/all/users/{user_id}")
    public String getAll(@PathVariable("user_id") long userId, Model model) {
        User user = userService.readById(userId);
        model.addAttribute("user", user);
        List<ToDo> toDos = toDoService.getByUserId(userId);
        model.addAttribute("todos", toDos);
        return "todos-user";
    }
//
//    @GetMapping("/{id}/add")
//    public String addCollaborator(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
//
//    @GetMapping("/{id}/remove")
//    public String removeCollaborator(//add needed parameters) {
//        //ToDo
//        return " ";
//    }
}
