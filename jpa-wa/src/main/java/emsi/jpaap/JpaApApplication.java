package emsi.jpaap;

import emsi.jpaap.entities.Patient;
import emsi.jpaap.repositories.PatientRepository;
import emsi.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository Patientrepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            Patientrepository.save(
                    new Patient(null, "othmane", new Date(), Math.random() > 0.5 ? true : false, (int) (Math.random() * 1000)));

        }


        Page<Patient> patients = Patientrepository.findAll(PageRequest.of(1, 5));

        System.out.println("total pages : " + patients.getTotalPages());
        System.out.println("total elements : " + patients.getTotalElements());
        System.out.println("Numero de la page :" + patients.getNumber());
        List<Patient> content = patients.getContent();

        Page<Patient> byMalade = Patientrepository.findByMalade(true, PageRequest.of(0, 4));
        List<Patient> patientList = Patientrepository.chercherPatient("%o%", 388);
        byMalade.forEach(p -> {
            System.out.println("=======================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDatenaissance());
            System.out.println(p.getMalade());
        });
        System.out.println("*******************");
        Patient patient = Patientrepository.findById(1L).orElse(null);
        if (patient != null) {
            System.out.println(patient.getNom());
            System.out.println(patient.getMalade());
            patient.setScore(870);
            Patientrepository.save(patient);

        }


        // Patientrepository.deleteById(1L);


    }
}
