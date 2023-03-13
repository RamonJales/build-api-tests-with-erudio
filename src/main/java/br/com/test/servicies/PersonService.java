package br.com.test.servicies;

import br.com.test.exceptions.ResourceNotFoundException;
import br.com.test.data.vo.v1.PersonVO;
import br.com.test.mapper.DozerMapper;
import br.com.test.models.Person;
import br.com.test.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonVO findById(Integer id) {
        logger.info("Finding one PersonVO!");

        Person obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));;

        return DozerMapper.parseObject(obj, PersonVO.class);
    }
    
    public List<PersonVO> findAll() {
        logger.info("Finding All people!");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO personVO) {
        logger.info("Creating one PersonVO!");

        Person obj = DozerMapper.parseObject(personVO, Person.class);
        PersonVO objVO = DozerMapper.parseObject(repository.save(obj), PersonVO.class);

        return objVO;
    }

    public PersonVO update(PersonVO PersonVO) {
        logger.info("Update one PersonVO!");

        Person obj = repository.findById(PersonVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        obj.setName(PersonVO.getName());
        obj.setLastName(PersonVO.getLastName());
        obj.setAddress(PersonVO.getAddress());
        obj.setGender(PersonVO.getGender());

        return DozerMapper.parseObject(repository.save(obj), PersonVO.getClass());
    }

    public void delete(Integer id) {
        logger.info("Deleting one PersonVO!");
        Person obj = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(obj);
    }
}
