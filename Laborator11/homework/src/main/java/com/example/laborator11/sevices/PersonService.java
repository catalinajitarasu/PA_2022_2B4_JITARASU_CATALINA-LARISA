package com.example.laborator11.sevices;

import com.example.laborator11.entity.Person;
import com.example.laborator11.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    }
    public Person getPersonById(int id) {
        return personRepository.findPersonById(id);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getUsers() {
        return personRepository.findAll();
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
    public List<Person> getMostPopular() {
        var users = personRepository.findAll();
        users.sort(Person::compareTo);
        return users;
    }

    public List<Person> getLeastPopular() {
        var users = getMostPopular();
        List<Person> least = new ArrayList<>();
        for (int i = users.size() - 1; i >= 0; i--) {
            least.add(users.get(i));
        }
        return least;
    }

    public Person mostPopularPerson() {
        var list = personRepository.findAll();
        list.sort(Person::compareTo);
        return list.get(list.size() - 1);
    }

    public boolean alreadyFriends(Person person, Person newFriend) {
        if (person.getFriends().contains(newFriend)) {
            return true;
        }
        return false;
    }

}