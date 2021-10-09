/*Java code for a simple GameEntry class.
This code shows methods which holds high scores of users using Arrays. Additionally, also has
methods that update the high score.
This code is my attempt in learning how java algorithm works

For more information refer to the book "Data Structures and Algorithms in Java Fourth Edition". Pg 140-149
 */


public class GameEntry { //class for retrieving name and score
    protected String name;
    protected int score;

    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return "(" + name + "," + score + ")";
    }

    //Class for storing high scores in an array in non-descending order

    public class Scores {

        public static final int maxEntries = 10; //this variable keeps track of the top 10 high scores
        protected int numEntries; // number of actual entries also the length of the array entries
        protected GameEntry[] entries; //array of game entries with the names and scores

        public Scores() {
            entries = new GameEntry[maxEntries];
            numEntries = 0;
        }

        public String toString() {
            String s = "[";
            for (int i = 0; i < numEntries; i++) {
                if (i > 0) s += ","; //used to separate each entry by commas
                s += entries[i];
            }
            return s + "]";
        }


        //method for updating high score
     /*following is a method for adding gameEntry object and placing the object in appropriate
    position based on the score*/

        public void add(GameEntry e) {
            int newScore = e.getScore();

            if (numEntries == maxEntries) {  //the array is full
                if (newScore <= entries[numEntries - 1].getScore())
                    return; // the new entry will not be allocated a place in the array as it is not high enough

            } else // the array is not full
                numEntries++;

            //locate the place that the new high score entry e belongs
            for (int i = numEntries - 1; (i >= 1) && (newScore > entries[i - 1].getScore()); i--) {
                entries[i] = entries[i - 1]; // move entry i one to the right
                entries[i] = e; //adds new score to entries
            }
        }

        //Remove and return high score at index  i
        public GameEntry remove(int i) throws IndexOutOfBoundsException {
            if ((i < 0) || (i >= numEntries))
                throw new IndexOutOfBoundsException("Invalid index: " + i);
            GameEntry temp = entries[i]; // temporarily save the object to be removed
            for (int j = i; j < numEntries - 1; j++)//count up from i (not down)
                entries[j] = entries[j + 1];
            entries[numEntries - 1] = null; //null out the last score
            numEntries--;
            return temp; //return the removed object
        }

    }


}