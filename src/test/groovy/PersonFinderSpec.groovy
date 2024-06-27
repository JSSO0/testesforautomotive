@Specification
class PersonFinderSpec extends Specification {

    @Mock
    private PersonRepository personRepository

    private PersonFinder personFinder

    def setup() {
        personFinder = new PersonFinder(personRepository)
    }

    def "Deve lançar exceção quando plantonista não encontrado"() {
        given:
        def name = "joeeely"

        when:
        personRepository.findByName(name) >> null

        then:
        assertThrows(PersonNotFoundException.class) { personFinder.findPersonByName(name) }
    }
}
