package main

import (
	"fmt"
	"math"
	"sort"
)

func numberOfDigist(n int) int {
    count  := 0;
	for n != 0 {
		count = count + 1
		n = n/10
		fmt.Println(n)
	}
	return count;
}

func reverseNumber(x int) int {
	var rev int = 0;
	for x!= 0 {
		rev = rev*10 + x%10
		x = x/10
	}
	return rev;
}

func isPalindrome(x int) bool {
	if x < 0 {
		return false;
	}
	rev := reverseNumber(x)
	if x == rev {
		return true;
	}
	return false;
}

func isArmstrong(x int) bool {
	number := x
    sum  := 0
	for x!= 0 {
		digit := x%10
		x = x/10
		sum = sum + digit*digit*digit
	}
	return  sum == number;
}

func divisors(n int) []int {
	divisors := []int{}

	sqrtOfN := int(math.Sqrt(float64(n)))
	for i := 1; i <= sqrtOfN; i++ {
		if(n%i == 0) {
			divisors = append(divisors, i)
			if(n/i != i) {
				divisors = append(divisors, n/i)
			}
		}
	}
	
	 sort.Ints(divisors)
	 return divisors
}


func main() {
    fmt.Println(divisors(45))
}
