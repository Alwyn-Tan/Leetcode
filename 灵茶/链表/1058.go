package main

import "math"

func nodesBetweenCriticalPoints(head *ListNode) []int {
	a, b, c := head, head.Next, head.Next.Next
	first, last, minDis := 0, 0, math.MaxInt32
	for i, prev := 1, 0; c != nil; i++ {
		if a.Val < b.Val && b.Val > c.Val || a.Val > b.Val && b.Val < c.Val {
			if first == 0 {
				first = i
			}
			last = i
			if prev != 0 && i-prev < minDis {
				minDis = i - prev
			}
			prev = i
		}
		a, b, c = b, c, c.Next
	}

	if first == last {
		return []int{-1, -1}
	}
	return []int{minDis, last - first}
}
