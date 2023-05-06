// for input and output
# include <iostream>
// for std::numeric_limits
# include <limits>

/*
	Author: LeeTuah
	Program: Solving Quadratic Equation
	Date: 06/05/23
	For SuperB League event
*/

// fixes std::cin if bad input is provided
void fix_cin(){
	if(std::cin.fail()){
		// clears std::cin and removes all the bad input from it
		std::cin.clear();
		std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');	
	}	
}

// returns the two roots of a quadratic equation
// int a -> coefficient attached with degree 2 of x
// int b -> coefficient with degree 2 of x
// int c -> constant term
std::pair<float, float> quadratic_roots(int a, int b, int c){
	// variable declaration
	int d;
	std::pair<float, float> roots;
	
	// calculating discriminant
	d = b*b - (4*a*c);
	
	// if roots are imaginary, return 0
	if(d < 0){
		roots.first = 0;
		roots.second = 0;
		return roots;	
	}
	
	// calculating the roots from formula: 
	// {-b +- sqrt(b*b - 4ac)} / 2a
	roots.first = ((b * -1) + sqrt(d))/(float)2*a;
	roots.second = ((b * -1) - sqrt(d))/(float)2*a;
	
	return roots;
}

// execution starts from here
// int argc -> total argument count from run
// char** argv -> all the provided arguments in a string array
int main(int argc, char** argv){
	// variable declaration
	int a, b, c;
	std::pair<float, float> roots;
	
	// taking input from user
	std::cout << "Enter a, b, and c respectively:\n";
	std::cin >> a;
	fix_cin();
	std::cin >> b;
	fix_cin();
	std::cin >> c;
	
	// calculating the roots
	roots = quadratic_roots(a, b, c);
	
	// printing the roots
	std::cout << "The roots of the equation are " << roots.first << " and " << roots.second;
	return 0;
}
