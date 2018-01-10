package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Ivan Mozheiko (mozhivan@yandex.ru)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
/**
* Test echo.
 *
 */
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Ivan Mozheiko";
    String expect = "Echo, echo, echo : Ivan Mozheiko"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}