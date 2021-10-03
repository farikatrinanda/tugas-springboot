@Controller
public class MainController {

    @Autowired
    private TodoInterface todoInterface;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", todoInterface.getAll());
        return "index";
    }

    @GetMapping("/todo/create")
    public String create(Model model) {
        
        Todo todo = new Todo();
        model.addAttribute("todo", todo);
        
        return "create";
    }

    @PostMapping("/todo/store")
    public String store(@ModelAttribute("todo") Todo todo) {
        todoInterface.store(todo);
        return "redirect:/";
    }
@GetMapping("/todo/{id}/edit")
public String edit(@PathVariable(value = "id") long id, Model model) {
  Todo todo = todoInterface.getById(id);

  model.addAttribute("todo", todo);
  return "edit";
}

@PostMapping("/todo/{id}/delete")
public String delete(@PathVariable(value = "id") long id) {
  todoInterface.delete(id);
  return "redirect:/";
}
}
