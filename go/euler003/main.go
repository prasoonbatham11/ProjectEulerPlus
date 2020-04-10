package main

import (
	"fmt"
	"os"
)

/*
To execute hackerrank projecteuler+ solution use:
	go build main.go
	./main

To execute projecteuler.net solution use:
	go build main.go
	./main 1
*/

func main() {
	switch len(os.Args) {
	case 1:
		solve()
	default:
		solvePE()
	}
}

func solve() {
	// Hackerrank PE+ solution
	var t, n int
	fmt.Scanf("%d", &t)
	for ; t > 0; t-- {
		fmt.Scanf("%d", &n)
		fmt.Println(getLargestPF(n))
	}
}

func getLargestPF(n int) int {
	lpf := 1
	i := 3

	// Check if 2 is a prime factor
	for n%2 == 0 {
		n = n / 2
		lpf = 2
	}

	// Check for all other primes
	for i*i <= n {
		for n%i == 0 {
			n /= i
			lpf = i
		}
		i += 2
	}

	// If the number left is greater than 1 then it is also prime
	if n > 1 {
		lpf = n
	}
	return lpf
}

func solvePE() {
	// projecteuler.net solution
	fmt.Println(getLargestPF(600851475143))
}
