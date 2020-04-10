package main

import (
	"fmt"
	"os"
)

/*
To execute hackerrank projecteuler+ solution use:
	go run main.go

To execute projecteuler.net solution use:
	go run main.go 1
*/

func main() {
	switch len(os.Args) {
	case 1:
		solveHR()
	default:
		solvePE()
	}
}

func solveHR() {
	// Hackerrank PE+ solution
	var t int
	var n int
	fmt.Scanf("%d", &t)
	for ; t > 0; t-- {
		fmt.Scanf("%d", &n)
		fmt.Println(solve(n))
	}
}

func solvePE() {
	// projecteuler.net solution
	fmt.Println(solve(1000))
}

func solve(n int) int {
	n--
	n3 := n / 3
	n5 := n / 5
	n15 := n / 15
	n3 = 3 * (n3 * (n3 + 1) / 2)
	n5 = 5 * (n5 * (n5 + 1) / 2)
	n15 = 15 * (n15 * (n15 + 1) / 2)
	return n3 + n5 - n15
}
