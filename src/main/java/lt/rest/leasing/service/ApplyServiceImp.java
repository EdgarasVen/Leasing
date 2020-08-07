package lt.rest.leasing.service;

import lombok.extern.slf4j.Slf4j;
import lt.rest.leasing.exceptions.ResourceNotFindException;
import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.Person;
import lt.rest.leasing.model.Vehicle;
import lt.rest.leasing.repo.RepoLeasingApply;
import lt.rest.leasing.repo.RepoPerson;
import lt.rest.leasing.repo.RepoVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Slf4j
public class ApplyServiceImp implements ApplyService{
    RepoVehicle repoVehicle;
    RepoLeasingApply repoLeasingApply;
    RepoPerson repoPerson;

    @Value("${income.requirements}")
    private int INCOME_REQUIREMENTS;

    @Autowired
    public ApplyServiceImp(RepoVehicle repoVehicle, RepoLeasingApply repoLeasingApply, RepoPerson repoPerson) {
        this.repoVehicle = repoVehicle;
        this.repoLeasingApply = repoLeasingApply;
        this.repoPerson = repoPerson;
    }

    @Override
    public void addListOfPersons(List<Person> personList) {
        repoPerson.saveAll(personList);
        log.info("IN addListOfPersons - list added, list size: {}",personList.size());
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        repoVehicle.save(vehicle);
        log.info("IN addVehicle - vehicle added");
    }

    @Override
    public boolean addLeasingApply(LeasingApply leasingApply) {
        IntSummaryStatistics stats;
        List<Person> family=leasingApply.getFamily();
        Vehicle vehicle=leasingApply.getVehicle();

        for (Person person:family)
        {
            person.setLeasingApply(leasingApply);
        }

        stats=family.stream()
                .flatMapToInt(person -> IntStream.of(person.getIncome().intValue()))
                .summaryStatistics();
        boolean answer = stats.getAverage()>INCOME_REQUIREMENTS;
        addListOfPersons(family);
        vehicle.setLeasingApply(leasingApply);
        addVehicle(vehicle);
        leasingApply.setVehicle(vehicle);
        leasingApply.setFamily(family);
        leasingApply.setAnswer(answer);

        repoLeasingApply.save(leasingApply);
        log.info("IN addLeasingApply - full apply added");
        return answer;
    }

    @Override
    public boolean checkLeasingResultById(Long id) {
        LeasingApply apply=repoLeasingApply.findById(id).orElseThrow(() ->new ResourceNotFindException("Apply not find"));
        log.info("IN checkLeasingResultById - apply find by id: {}",id);
        return apply.isAnswer();
    }
}
