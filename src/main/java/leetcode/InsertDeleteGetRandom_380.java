package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * We could use a set to insert and remove elements,
 * but for getting the random, we need an array and peek a random index from its length
 *
 * but then we need to sync the list with the set, and then
 * how to remove fom the array one specific element in O(1) time?
 * We need to store the indexes fo each element in order to do that
 *
 * so we could use a map to store for each val, the index in the array
 *
 * although now do we really need the set?
 * we could actually use the same map to insert and remove elements in constant time.
 *
 * so at the end we need an array to get the random element and a map to keep the indexes and be able to use it as a constant time insert and remove
 */
public class InsertDeleteGetRandom_380 {
    ArrayList<Integer> arrayList = new ArrayList<>();
    HashMap<Integer, Integer> elementToIndexMap = new HashMap<>();
    Random random = new Random();

    public InsertDeleteGetRandom_380() {

    }

    public boolean insert(int val) {
        if (elementToIndexMap.containsKey(val)) {
            return false;
        }

        arrayList.add(val);
        elementToIndexMap.put(val, arrayList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (this.elementToIndexMap.containsKey(val)){
            Integer elementAtTheEndOfTheList = this.arrayList.get(arrayList.size()- 1);
            int indexOfElementToRemove = this.elementToIndexMap.get(val);

            if (indexOfElementToRemove == this.arrayList.size() - 1){
                this.arrayList.remove(arrayList.size() - 1);
                this.elementToIndexMap.remove(val);
                return true;
            }

            this.arrayList.set(indexOfElementToRemove, elementAtTheEndOfTheList);
            this.arrayList.remove(arrayList.size() - 1);
            this.elementToIndexMap.remove(val);
            this.elementToIndexMap.put(elementAtTheEndOfTheList, indexOfElementToRemove);
            return true;
        }

        return false;
    }

    public int getRandom() {
        return this.arrayList.get(random.nextInt(this.arrayList.size()));

    }
}
