class DifferenceCalculatorBetweenMounth extends Specification {

    def differenceCalculator = new DifferenceCalculator()

    def "Deve calcular a diferença de horas trabalhadas entre dois arrays"() {
        given:
        def oldHours = [
                ['JOELY', [
                        [HT, 35.0],
                        [HN, 31.0],
                        [HS, 5.0],
                        [HD, 4.0],
                ]]
        ]
        def newHours = [
                ['JOELY', [
                        [HT, 38.0],
                        [HN, 36.0],
                        [HS, 8.0],
                        [HD, 9.0],
                ]]
        ]

        when:
        def difference = differenceCalculator.calculateDifference(oldHours, newHours)

        then:
        difference == [
                ['JOELY', [
                        [HT, 3.0],
                        [HN, 5.0],
                        [HS, 3.0],
                        [HD, 5.0],
                ]]
        ]
    }

}
