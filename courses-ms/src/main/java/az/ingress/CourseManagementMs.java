package az.ingress;

import az.ingress.domain.StudentEntity;
import az.ingress.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseManagementMs implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementMs.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        StudentEntity student = StudentEntity.builder()
                .firstName("Mehemmed")
                .lastName("Baloglanov")
                .build();

        studentRepository.save(student);

        final Optional<StudentEntity> byId = studentRepository.findById(1L);
        byId.ifPresent(System.out::println);
    }
}