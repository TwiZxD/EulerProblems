#include "classTest.h"
#include <iostream>

ClassTest::ClassTest()
{
	run();
}

void ClassTest::run() {
	int i = 1;
	int j = 2;
	std::cout << "Print 1 + 2 = " << i + j << "\n";
}