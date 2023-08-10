package by.htp.demo.service;

import by.htp.demo.persist.Worker;
import by.htp.demo.repository.WorkerRepository;
import by.htp.demo.repository.WorkerSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkerService {
    @Autowired
    private WorkerRepository repository;
    @Autowired
    private WorkerSortRepository workerSortRepository;

    public Page<Worker> listAll(int pageNum, String sortField, String sortDir,
                                String keyword) {

        Pageable pageable = PageRequest.of(pageNum - 1, 5,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending()

        );
        if (keyword != null) {
            return workerSortRepository.findAll(keyword, pageable);
        }
        return repository.findAll(pageable);
    }

}