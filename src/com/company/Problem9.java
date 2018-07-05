package com.company;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {
    int exceedingNumber = 1000;

    public Problem9() {
        solveProblem();
    }

    private void solveProblem() {
        double c;
        for(int a = 0; a < exceedingNumber; a++) {
            for(int b = a + 1; b < exceedingNumber; b++) {
                c = Math.sqrt( (a*a + b*b));
                if (a + b + c == 1000) {
                    if(checkPythagoreanTriplet(a,b,c)) {
                        System.out.println("a: " + a + " b: " + b + " c: " + c);
                        System.out.println("Product: " + a*b*(int)c);
                        return ;
                    }
                }
            }
        }
    }


    private boolean checkPythagoreanTriplet(int a, int b, double c) {
        if(     a < b &&
                b < c &&
                a*a + b*b == c*c) {
            return true;
        } else return false;
    }
}
