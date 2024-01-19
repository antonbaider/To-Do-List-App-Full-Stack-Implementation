package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
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
@RequestMapping("/todos")
public class ToDoController {

    private final UserService userService;
    private final ToDoService toDoService;
    private final TaskService taskService;

    @GetMapping("/create/users/{owner_id}")
    public String create(@PathVariable("owner_id") long ownerId,
                         Model model) {
        User user = userService.readById(ownerId);
        ToDo toDo = new ToDo();
        model.addAttribute("todo", toDo);
        model.addAttribute("ownerName", user.getFirstName() + ' ' + user.getLastName());
        model.addAttribute("owner", user);
        return "create-todo";
    }

    @PostMapping("/create/users/{owner_id}")
    public String create(@PathVariable("owner_id") long ownerId,
                         @ModelAttribute("todo") @Valid ToDo toDo,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("constraintViolations", bindingResult.getFieldErrors());
            User user = userService.readById(ownerId);
            model.addAttribute("todo", toDo);
            model.addAttribute("ownerName", user.getFirstName() + ' ' + user.getLastName());
            model.addAttribute("owner", user);
            return "create-todo";
        }
        User owner = userService.readById(ownerId);
        toDo.setOwner(owner);
                toDoService.create(toDo);

        return "redirect:/todos/all/users/" + ownerId;
    }

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

    @GetMapping("/{todo_id}/update/users/{owner_id}")
    public String update(@PathVariable("todo_id") long todoId, @PathVariable("owner_id") long ownerId, Model model) {
        ToDo toDo = toDoService.readById(todoId);
        model.addAttribute("todoUpdate", toDo);
        return "update-todo";
    }

    @PostMapping("/{todo_id}/update/users/{owner_id}")
    public String update(@PathVariable("todo_id") long todoId, @PathVariable("owner_id") long ownerId, @Valid @ModelAttribute("todoUpdate") ToDo updatedToDo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            ToDo toDo = toDoService.readById(todoId);
            model.addAttribute("constraintViolations", bindingResult.getFieldErrors());
            model.addAttribute("todoUpdate", toDo);
            return "update-todo";
        }
        User owner = userService.readById(ownerId);
        ToDo toDo = toDoService.readById(todoId);
        toDo.setTitle(updatedToDo.getTitle());
        toDoService.update(toDo);
        return "redirect:/todos/all/users/" + ownerId;
    }

    @GetMapping("/{todo_id}/delete/users/{owner_id}")
    public String delete(@PathVariable("todo_id") long todoId, @PathVariable("owner_id") long ownerId) {
        toDoService.delete(todoId);
        return "redirect:/todos/all/users/" + ownerId;
    }

    @GetMapping("/all/users/{user_id}")
    public String getAll(@PathVariable("user_id") long userId, Model model) {
        User user = userService.readById(userId);
        model.addAttribute("user", user);
        List<ToDo> toDos = toDoService.getByUserId(userId);
        model.addAttribute("todos", toDos);
        return "todos-user";
    }

    @PostMapping("/{todo_id}/add/")
    public String addCollaborator(@PathVariable("todo_id") long todoId, @RequestParam("collaboratorId") long collaboratorId, Model model) {
        userService.addCollaborator(todoId, collaboratorId);
        return "redirect:/todos/" + todoId + "/tasks";
    }

    @GetMapping("/{todo_id}/remove/{collaborator_id}")
    public String removeCollaborator(@PathVariable("todo_id") long todoId, @PathVariable("collaborator_id") long collaboratorId, Model model) {
        userService.removeCollaborator(todoId, collaboratorId);
        return "redirect:/todos/" + todoId + "/tasks";
    }
}
