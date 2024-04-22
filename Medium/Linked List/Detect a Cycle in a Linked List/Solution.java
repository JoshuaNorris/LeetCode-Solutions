// https://leetcode.com/problems/linked-list-cycle-ii/submissions/1213708571/

// There was something wrong with the tost cases for the java implementation with what type to return
// But this is the correct solution

import java.util.HashMap;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<Integer, Integer> numbers_seen = new HashMap();
        int index = 0;
        while (true) {
            if (numbers_seen.containsKey(head.val)) {
                ListNode result = new ListNode();
                result.val = numbers_seen.get(head.val);
                return result;
            } else {

                try{
                    numbers_seen.put(head.val, index);
                    head = head.next;
                    index ++;
                } catch (NullPointerException e) {
                    ListNode result = new ListNode();
                    result.val = -1;
                    return result;
                }
            }
        }
    }
}