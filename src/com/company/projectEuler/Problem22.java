package com.company.projectEuler;

import java.io.*;

/**
 * Using names.txt, a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 */
public class Problem22 {
    private BufferedReader reader = null;

    Problem22() {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void test() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("com/company/res/p022_names.txt");
        reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ( (line = reader.readLine()) != null) {
            // do something with the line here
            System.out.println("Line read: " + line);
        }
    }

}

