
 func getDecimalValue(head *ListNode) int {
    result :=0
    for tmp :=head; tmp != nil;{
        result <<= 1
        result += tmp.Val
        tmp = tmp.Next
    }
    return result
}
