// for input and output
# include <iostream>
// for std::numeric_limits
# include <limits>

/*
	Author: LeeTuah
	Program: 
	Date: 00/00/23
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

// returns the area and perimeter of a rectangular figure
// int length -> stores the length of rect
// int width -> stores the width of the rect
std::pair<int, int> area_perimeter(int length, int width){
	std::pair<int, int> ans = std::pair(0, 0);
	
	// calculating the area
	ans.first = length*width;
	// calculating the perimeter
	ans.second = 2 * (length + width);
	
	return ans;
}

// execution starts from here
// int argc -> total argument count from run
// char** argv -> all the provided arguments in a string array
int main(int argc, char** argv){
	// variable declaration
	int l, w;
	std::pair<int, int> ans;
	
	// getting the length and height from user
	std::cout << "Enter the length: ";
	std::cin >> l;
	fix_cin();
	std::cout << "Enter the width: ";
	std::cin >> w;
	
	// calculating the results
	ans = area_perimeter(l, w);
	
	// printing the results
	std::cout << "The area is " << ans.first;
	std::cout << "\nThe perimeter is " << ans.second;
	return 0;
}
