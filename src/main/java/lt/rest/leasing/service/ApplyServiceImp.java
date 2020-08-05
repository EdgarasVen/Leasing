package lt.rest.leasing.service;

import lombok.extern.slf4j.Slf4j;
import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.Person;
import lt.rest.leasing.model.Vehicle;
import lt.rest.leasing.repo.RepoLeasingApply;
import lt.rest.leasing.repo.RepoPerson;
import lt.rest.leasing.repo.RepoVehicle;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ApplyServiceImp(RepoVehicle repoVehicle, RepoLeasingApply repoLeasingApply, RepoPerson repoPerson) {
        this.repoVehicle = repoVehicle;
        this.repoLeasingApply = repoLeasingApply;
        this.repoPerson = repoPerson;
    }

    @Override
    public void addListOfPersons(List<Person> personList) {
        repoPerson.saveAll(personList);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        repoVehicle.save(vehicle);
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
        boolean answer = stats.getAverage()>600;
        addListOfPersons(family);
        vehicle.setLeasingApply(leasingApply);
        addVehicle(vehicle);
        leasingApply.setVehicle(vehicle);
        leasingApply.setFamily(family);
        leasingApply.setAnswer(answer);

        repoLeasingApply.save(leasingApply);
        return answer;
    }

    @Override
    public boolean checkLeasingResultById(Long id) {
        return false;
    }
}
