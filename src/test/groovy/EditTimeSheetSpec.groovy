import spock.lang.*

class EditTimeSheetSpec extends Specification {

    def timeSheetService = Mock(TimeSheetService)

    def "Deve editar o dia especificado na folha de ponto"() {
        given:
        def editedDay = ["2024-06-20", "08:00", "20:00"] // Novo horário para o dia 20/06
        def originalTimeSheet = [
                ['JOELY', [
                        ["2024-06-20", "07:00", "19:00"],
                        ["2024-06-21", "09:00", "17:00"],
                        ["2024-06-22", "08:00", "12:00"],
                        ["2024-06-23", "10:00", "20:00"],
                        ["2024-06-24", "11:00", "15:00"],
                ]]
        ]

        when:
        def editedTimeSheet = timeSheetService.editTimeSheet(originalTimeSheet, "JOELY", "2024-06-20", editedDay)

        then:
        editedTimeSheet == [
                ['JOELY', [
                        ["2024-06-20", "08:00", "20:00"],
                        ["2024-06-21", "09:00", "17:00"],
                        ["2024-06-22", "08:00", "12:00"],
                        ["2024-06-23", "10:00", "20:00"],
                        ["2024-06-24", "11:00", "15:00"],
                ]]
        ]
    }
}