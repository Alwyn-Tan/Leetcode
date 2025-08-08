function removeDuplicates(nums: number[]): number {
    let stack_size = 2;
    for (let i = 2; i < nums.length; i++) {
        if (nums[i] !== nums[stack_size - 2]) {
            nums[stack_size] = nums[i]
            stack_size++;
        }
    }
    return stack_size;
};