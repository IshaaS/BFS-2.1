// https://leetcode.com/problems/employee-importance/

// Time Complexity : O(n) every node once
// Space Complexity : O(n) hashMap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// used hashmap to map every id to eployee to save time=> search 0(1)
// used dfs to get all subordinates and importance of the subordinates

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int imp;
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        this.imp=0;
        int i=0;
        this.map=new HashMap<>();
        while(i<employees.size()){
            map.put(employees.get(i).id, employees.get(i));
            i++;
        }
        dfs(id);
        return imp;
    }
    private void dfs(int id){
        //base
        Employee root=map.get(id);
        imp=imp+root.importance;
        if(root.subordinates==null) return;
        //logic
        int i=0;
        while(i<root.subordinates.size()){
            dfs(root.subordinates.get(i));
            i++;
        }
        return;
    }
}