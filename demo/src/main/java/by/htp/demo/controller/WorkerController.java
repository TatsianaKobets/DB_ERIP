package by.htp.demo.controller;

import by.htp.demo.persist.Worker;
import by.htp.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/workers/new")
    public String createNewWorker(Model model) {
        model.addAttribute("worker", new Worker());
        return "create_worker_page";
    }

    @PostMapping("/workers/save")
    public String saveWorker(Worker worker, HttpServletRequest request) {
        workerRepository.save(worker);
        return "redirect:/workers";
    }

    @GetMapping("/workers")
    public String listWorkers(Model model) {
        List<Worker> listWorkers = workerRepository.findAll();
        model.addAttribute("listWorkers", listWorkers);
        return "workers";
    }

    @GetMapping("workers/edit/{id}")
    public String showEditWorkerPage(@PathVariable("id") Integer id, Model model) {
        Worker worker = workerRepository.findById(id).get();
        model.addAttribute("worker", worker);
       return "create_worker_page";
    }

    @GetMapping("workers/delete/{id}")
    public String deleteWorker(@PathVariable("id") Integer id) {
        workerRepository.deleteById(id);
        return "redirect:/workers";
    }
}
