package lt.rest.leasing;

import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.Person;
import lt.rest.leasing.model.Vehicle;
import lt.rest.leasing.repo.RepoLeasingApply;
import lt.rest.leasing.repo.RepoPerson;
import lt.rest.leasing.repo.RepoVehicle;
import lt.rest.leasing.service.ApplyServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ApplyServiceTest {

    @Mock
    RepoVehicle repoVehicle;
    @Mock
    RepoLeasingApply repoLeasingApply;
    @Mock
    RepoPerson repoPerson;

    @InjectMocks
    ApplyServiceImp serviceImp;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addLeasingApply(){
        List<Person> list=new ArrayList<>();
        Person person=new Person();
        person.setIncome(BigDecimal.valueOf(500));
        list.add(person);
        Vehicle vehicle=new Vehicle();
        LeasingApply apply=new LeasingApply();
        apply.setFamily(list);
        apply.setVehicle(vehicle);
        serviceImp.addLeasingApply(apply);
        verify(repoPerson, times(1)).saveAll(list);
        verify(repoVehicle,times(1)).save(vehicle);
        verify(repoLeasingApply,times(1)).save(apply);
    }

    @Test
    void getAnswerById(){
        List<Person> list=new ArrayList<>();
        Person person=new Person();
        person.setIncome(BigDecimal.valueOf(500));
        list.add(person);
        Vehicle vehicle=new Vehicle();
        LeasingApply apply=new LeasingApply();
        apply.setFamily(list);
        apply.setVehicle(vehicle);
        serviceImp.addLeasingApply(apply);
        when(repoLeasingApply.findById(anyLong())).thenReturn(java.util.Optional.of(apply));
        serviceImp.checkLeasingResultById(1L);
        verify(repoLeasingApply,times(1)).findById(1L);
    }
}
