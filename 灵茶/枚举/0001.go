func twoSum(nums []int, target int) []int {
	indexMap = map[int]int{}
	for i, x := range nums {
		if j, ok := indexMap[target-x]; ok {
			return []int{i, j}
		}
		indexMap[x] = i
	}
	return nil
}