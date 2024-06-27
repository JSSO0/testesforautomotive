import spock.lang.*

@Specification
class TotalSalaryLiquidServiceSpec extends Specification {

    def totalHoursService = Mock(TotalHoursService)
    def totalSalaryService = new TotalSalaryService(totalHoursService)

    def "Deve calcular o total de horas e valor para cada funcionário"() {
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
        def totalSalaryList = totalSalaryService.calculateTotalSalary(workedDays)

        then:
        totalSalaryList.size() == 1
        totalSalaryList[0].get("funcionario") == "JOELY"

        def totalHours = totalSalaryList[0].get("total_horas")
        assert totalHours.HT == 35.0
        assert totalHours.HN == 31.0
        assert totalHours.HS == 5.0
        assert totalHours.HD == 4.0

        def totalSalary = totalSalaryList[0].get("total_valores")
        assert totalSalary.get("VHN") == 837.0
        assert totalSalary.get("VHS") == 163.84
        assert totalSalary.get("VHSAB") == 163.0
        assert totalSalary.get("VHDF") == 227.36

    }
}