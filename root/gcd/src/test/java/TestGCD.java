import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import root.gcd.GCD;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGCD {
    GCD gcd;
    @BeforeEach
    void init(){
        gcd = new GCD();
    }

    @AfterAll
    static void Success(){
        System.out.println("All tests has been passed successfully!");
    }

    @DisplayName("Positive integers")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "1, 1, 1",
            "1, 2, 1",
            "2, 1, 1",
            "2, 2, 2",

            "1, 1123414244, 1",
            "2, 1123414244, 2",

            "1, 2147483646, 1",
            "1, 2147483647, 1",
            "2, 2147483646, 2",
            "2, 2147483647, 1",

            "1123414244, 1, 1",
            "1123414244, 2, 2",

            "1123414244, 1123414244, 1123414244",

            "1123414244, 2147483646, 2",
            "1123414244, 2147483647, 1",

            "2147483646, 1, 1",
            "2147483646, 2, 2",
            "2147483647, 1, 1",
            "2147483647, 2, 1",

            "2147483646, 1123414244, 2",
            "2147483647, 1123414244, 1",

            "2147483646, 2147483646, 2147483646",
            "2147483646, 2147483647, 1",
            "2147483647, 2147483646, 1",
            "2147483647, 2147483647, 2147483647"
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void PositiveIntegers(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }

    @DisplayName("First integer is negative")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "-2147483648, 1, 1",
            "-2147483648, 2, 2",
            "-2147483647, 1, 1",
            "-2147483647, 2, 1",

            "-2147483648, 1123414244, 4",
            "-2147483647, 1123414244, 1",

            "-2147483648, 2147483646, 2",
            "-2147483648, 2147483647, 1",
            "-2147483647, 2147483646, 1",
            "-2147483647, 2147483647, 2147483647",

            "-715827882, 1, 1",
            "-715827882, 2, 2",

            "-715827882, 1123414244, 2",

            "-715827882, 2147483646, 715827882",
            "-715827882, 2147483647, 1",

            "-2, 1, 1",
            "-2, 2, 2",
            "-1, 1, 1",
            "-1, 2, 1",

            "-2, 1123414244, 2",
            "-1, 1123414244, 1",

            "-2, 2147483646, 2",
            "-2, 2147483647, 1",
            "-1, 2147483646, 1",
            "-1, 2147483647, 1"
    })
    @Timeout(1)
    void FirstNegative(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }

    @DisplayName("Second integer is negative")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "1, -2147483648, 1",
            "2, -2147483648, 2",
            "1, -2147483647, 1",
            "2, -2147483647, 1",

            "1123414244, -2147483648, 4",
            "1123414244, -2147483647, 1",

            "2147483646, -2147483648, 2",
            "2147483647, -2147483648, 1",
            "2147483646, -2147483647, 1",
            "2147483647, -2147483647, 2147483647",

            "1, -715827882, 1",
            "2, -715827882, 2",

            "1123414244, -715827882, 2",

            "2147483646, -715827882, 715827882",
            "2147483647, -715827882, 1",

            "1, -2, 1",
            "2, -2, 2",
            "1, -1, 1",
            "2, -1, 1",

            "1123414244, -2, 2",
            "1123414244, -1, 1",

            "2147483646, -2, 2",
            "2147483647, -2, 1",
            "2147483646, -1, 1",
            "2147483647, -1, 1"
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void SecondNegative(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals( r, result);
    }

    @DisplayName("Negative integers")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "-2147483648, -2147483648, -2147483648",
            "-2147483647, -2147483648, 1",
            "-2147483648, -2147483647, 1",
            "-2147483647, -2147483647, 2147483647",

            "-715827882, -2147483648, 2",
            "-715827882, -2147483647, 1",

            "-2, -2147483648, 2",
            "-1, -2147483648, 1",
            "-2, -2147483647, 1",
            "-1, -2147483647, 1",

            "-2147483648, -715827882, 2",
            "-2147483647, -715827882, 1",

            "-715827882, -715827882, 715827882",

            "-2, -715827882, 2",
            "-1, -715827882, 1",

            "-2147483648, -2, 2",
            "-2147483647, -2, 1",
            "-2147483648, -1, 1",
            "-2147483647, -1, 1",

            "-715827882, -2, 2",
            "-715827882, -1, 1",

            "-2, -2, 2",
            "-1, -2, 1",
            "-2, -1, 1",
            "-1, -1, 1"
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void NegativeIntegers(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }

    @DisplayName("First integer is zero")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "0, -2147483648, -2147483648",
            "0, -2147483647, 2147483647",

            "0, -715827882, 715827882",

            "0, -2, 2",
            "0, -1, 1",

            "0, 2147483647, 2147483647",
            "0, 2147483646, 2147483646",

            "0, 715827882, 715827882",

            "0, 2, 2",
            "0, 1, 1",
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void FirstZero(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }

    @DisplayName("Second integer is zero")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "-2147483648, 0, -2147483648",
            "-2147483647, 0, 2147483647",

            "-715827882, 0, 715827882",

            "-2, 0, 2",
            "-1, 0, 1",

            "2147483647, 0, 2147483647",
            "2147483646, 0, 2147483646",

            "715827882, 0, 715827882",

            "2, 0, 2",
            "1, 0, 1",
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void SecondZero(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }

    @Test
    @DisplayName("Zero integers")
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void ZeroIntegers(){
        int r = gcd.gcd(0, 0);
        int result = 0;
        assertEquals(result, r, "Failed");
    }

    @DisplayName("Coprime integers")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "15233, 86431",
            "49391, 66529",
            "84729, 319043",
            "488669, 704161",
            "745987, 805813",
            "941891, 970219",
            "1036337, 1047297",
            "1118267, 2205287",
            "2278219, 3433947",
            "3449893, 3787489",
            "3884231, 4156903",
            "4229137, 4678941",
            "4832953, 5124619",
            "5271971, 5482661",
            "5594753, 5776311"
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void CoprimeIntegers(int x, int y){
        int r = gcd.gcd(x, y);
        int result = 1;
        assertEquals(result, r, "Failed");
    }

    @DisplayName("Equal integers")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "-1989896543, -1989896543",
            "-1893432412, -1893432412",
            "-1567896543, -1567896543",
            "-1348836548, -1348836548",
            "-1194532418, -1194532418",
            "-876214582, -876214582",
            "-500654323, -500654323",
            "0, 0",
            "500654323, 500654323",
            "876214582, 876214582",
            "1194532418, 1194532418",
            "1348836548, 1348836548",
            "1567896543, 1567896543",
            "1893432412, 1893432412",
            "1989896543, 1989896543"
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void EqualIntegers(int x, int y){
        int r = gcd.gcd(x, y);
        if (x >= 0) {
            assertEquals(x, r, "Failed");
        } else {
            assertEquals(-x, r, "Failed");
        }
    }

    @DisplayName("First divides the second")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "-1000000000, -2000000000",
            "-300000000, -1500000000",
            "-1000000000, -2000000000",
            "-500000000, -1000000000",
            "-200000000, -400000000",
            "200000000, 400000000",
            "500000000, 1000000000",
            "600000000, 1200000000",
            "700000000, 1400000000",
            "800000000, 1600000000",
            "900000000, 1800000000",
            "1000000000, 2000000000",
            "125000000, 500000000",
            "250000000, 750000000",
            "333333333, 999999999"
})
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void FirstDividesSecond(int x, int y){
        int r = gcd.gcd(x, y);
        if (x >= 0) {
            assertEquals(x, r, "Failed");
        } else {
            assertEquals(-x, r, "Failed");
        }
    }

    @DisplayName("Second divides the first")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "-2000000000, -1000000000",
            "-1500000000, -300000000",
            "-2000000000, -1000000000",
            "-1000000000, -500000000",
            "-400000000, -200000000",
            "400000000, 200000000",
            "1000000000, 500000000",
            "1200000000, 600000000",
            "1400000000, 700000000",
            "1600000000, 800000000",
            "1800000000, 900000000",
            "2000000000, 1000000000",
            "500000000, 125000000",
            "750000000, 250000000",
            "999999999, 333333333"
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void SecondDividesFirst(int x, int y){
        int r = gcd.gcd(x, y);
        if (y >= 0) {
            assertEquals(y, r, "Failed");
        } else {
            assertEquals(-y, r, "Failed");
        }
    }

    @DisplayName("Result is not one")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "12000, 18000, 6000",
            "250000, 500000, 250000",
            "120000000, 130000000, 10000000",
            "-987654321, -1975308642, 987654321",
            "-157895000, -315790000, 157895000",
            "-876543210, -1753086420, 876543210",
            "666666660, 1333333320, 666666660",
            "500005000, 1500000000, 5000",
            "-1799999998, -899999999, 899999999",
            "131313131, 393939393, 131313131",
            "555555555, 666666666, 111111111",
            "999999992, 1999999992, 8"
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void ResultIsNotOne(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }

    @DisplayName("Border values")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "-2147483648, -2147483648, -2147483648",
            "-2147483648, 2147483647, 1",
            "2147483647, -2147483648, 1 ",
            "2147483647, 2147483647, 2147483647",
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void BorderValues(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }

    @DisplayName("Fibonacci integers")
    @ParameterizedTest(name = "#{index}: x = ''{0}'', y = ''{1}''")
    @CsvSource({
            "1836311903, 1134903170, 1",
            "1134903170, 701408733, 1",
            "701408733, 433494437, 1",
            "433494437, 267914296, 1 "
    })
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void FibonacciIntegers(int x, int y, int result){
        int r = gcd.gcd(x, y);
        assertEquals(result, r, "Failed");
    }
}
