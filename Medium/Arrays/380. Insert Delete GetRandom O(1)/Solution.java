// https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;

class RandomizedSet {

    private HashMap<Integer, Integer> dict;
    private ArrayList<Integer> list;

    public RandomizedSet() {
        dict = new HashMap();
        list = new ArrayList();
    }
    
    public boolean insert(int val) {
        System.out.println("INSERT " + val);
        if (dict.get(val) == null) {
            list.add(val);
            dict.put(val, list.size()-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        System.out.println("Remove " + val);
        if (dict.get(val) != null) {
            if (list.size() == 1) {
                list.remove(0);
                dict.remove(val);
            } else {
                int index = dict.get(val);
                list.set(index, list.get(list.size()-1));
                list.remove(list.size()-1);
                dict.remove(val);
                dict.put(val, index);
            }
            
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get((int)(Math.random() * list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */