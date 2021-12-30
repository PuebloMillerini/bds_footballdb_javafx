package org.but.feec.footballdb.services;
import org.but.feec.footballdb.api.PersonBasicView;
import org.but.feec.footballdb.api.PersonDetailView;
import org.but.feec.footballdb.api.PersonEditView;
import  org.but.feec.footballdb.data.PersonRepository;
//import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.List;

public class PersonService {
    private PersonRepository personRepository;
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    public PersonDetailView getPersonDetailView(Long id) {
        return personRepository.findPersonDetailedView(id);
    }
    public List<PersonBasicView> getPersonsBasicView() {
        return personRepository.getPersonsBasicView();
    }
    public void editPerson(PersonEditView personEditView) {
        personRepository.editPerson(personEditView);
    }


}
