import spock.lang.*

@Specification
class TotalHoursServiceSpec extends Specification {
    def totalHoursService = new TotalHoursService()

    def "Deve calcular o total de horas trabalhadas"() {
        given:
        def workedDays = [
                ['JOELY', [
                        ["2024-06-20", "08:00", "18:00"],
                        ["2024-06-21", "09:00", "17:00"],
                        ["2024-06-22", "08:00", "12:00"],
                        ["2024-06-23", "10:00", "20:00"],
                        ["2024-06-24", "11:00", "15:00"],
                ]],
        ]

        when:
        def totalHours = totalHoursService.getTotalHours(dados)

        then:
        totalHours != null
        totalHours.HT == 35.0
        totalHours.HN == 31.0
        totalHours.HS == 5.0
        totalHours.HD == 4.0
        totalHours.HF == 0.0
    }
}
