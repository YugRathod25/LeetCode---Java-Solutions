class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();

        for (int student : students) {
            q.offer(student); // offer adds student at the back
        }

        int i = 0;
        int rotations = 0;

        while (!q.isEmpty() && rotations < q.size()) {

            if (q.peek() == sandwiches[i]) {
                q.poll(); // poll removes student from the front 
                i++;
                rotations = 0;
            } 
            else {
                q.offer(q.poll());
                rotations++;
            }
        }

        return q.size();
    }
}
