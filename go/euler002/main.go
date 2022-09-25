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
		fmt.Println(getFiboSum(n))
	}
}
func getFiboSum(n int) int {
	a := 1
	b := 2
	sum := b
	c := 0
	for {
		c = a + b
		if c > n {
			break
		}
		if c%2 == 0 {
			sum = sum + c
		}
		a, b = b, c
	}
	return sum
}
func solvePE() {
	// projecteuler.net solution
	fmt.Println(getFiboSum(4000000))
}
