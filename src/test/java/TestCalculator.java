import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class TestCalculator {
    Random random = new Random();


    @Test
    public void testCalculationOfTheTotalAmountToBeReturnedInRub() {
        Calculator calculator = new Calculator();
        int loanAmountInRub = random.nextInt();
        double actuals = calculator.calculationOfTheTotalAmountToBeReturnedInRub(loanAmountInRub);
        assertTrue("Неверный расчет общей суммы " + loanAmountInRub, (loanAmountInRub * 0.1) == actuals);
        //у нас тут почти коммунизм, осталось пару кирпичиков доложить
    }

    @Test
    public void testCalculationOfTheMonthlyPaymentInRub() {

        Calculator calculator = new Calculator();
        int loanAmountInRub = random.nextInt();
        int loanTermInMonths = random.nextInt();
        double actuals = calculator.calculationOfTheMonthlyPaymentInRub(loanAmountInRub, loanTermInMonths);
        //как-то вот тут спорно, если процент поменяется, тест станет не актуальным, так как мы ему болванку подсовываем, хотя с другой стороны раз мы с тестов начинаем, то и проверять ставку при её изменении будем с тестов
        assertTrue("Неверный расчет платежа " + loanAmountInRub + " и " + loanTermInMonths, (loanAmountInRub + loanAmountInRub * 0.1) / loanTermInMonths == actuals);

    }

    @Test
    public void testCalculationOverpayment() {
        Calculator calculator = new Calculator();
        int loanAmountInRub = random.nextInt();
        double actuals = calculator.calculationOverpayment(loanAmountInRub);
        assertTrue("Неверный расчет переплаты " + loanAmountInRub + " и " + calculator.calculationOverpayment(loanAmountInRub), calculator.calculationOverpayment(loanAmountInRub) - loanAmountInRub == actuals);
    }
}