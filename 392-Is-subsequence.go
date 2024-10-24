package main

import (
	"fmt"
	"sort"
)

func isSubsequence(s string, t string) bool {
	posMap := make(map[rune][]int)
	for i, char := range t {
		posMap[char] = append(posMap[char], i)
	}

	// Try to match each character in `s` with the corresponding position in `t`
	currPos := -1
	for _, char := range s {
		// If character not in `t`, return false
		if positions, exists := posMap[char]; exists {
			// Binary search for the next occurrence of `char` after `currPos`
			idx := sort.Search(len(positions), func(i int) bool { return positions[i] > currPos })
			if idx == len(positions) { // no valid position found
				return false
			}
			currPos = positions[idx] // update current position
		} else {
			return false
		}
	}

	return true
}

func main() {
	// Test case 1: s = "abc", t = "ahbgdc", expected output: true
	s1 := "abc"
	t1 := "ahbgdc"
	fmt.Println(isSubsequence(s1, t1)) // Output: true

	// Test case 2: s = "axc", t = "ahbgdc", expected output: false
	s2 := "axc"
	t2 := "ahbgdc"
	fmt.Println(isSubsequence(s2, t2)) // Output: false
}
