class RandomizedSet {
    private list: number[] = [];
    private map: { [key: number]: number } = {};


    constructor() {
    }

    insert(val: number): boolean {
        if (this.map[val] === undefined) {
            this.list.push(val);
            this.map[val]= this.list.length - 1;
            return true;
        }
        return false;
    }

    remove(val: number): boolean {
        if (this.map[val] === undefined) {
            return false;
        }
        const lastInsertedIndex = this.list.length - 1;
        const lastInsertedElement = this.list[lastInsertedIndex];
        let indexToRemove = this.map[val];
        this.list[indexToRemove] = lastInsertedElement;
        this.list.pop();
        this.map[lastInsertedElement] = indexToRemove;
        delete this.map[val];
        return true;
    }

    getRandom(): number {
        const index = Math.floor(Math.random() * this.list.length);
        return this.list[index];
    }
}

const obj = new RandomizedSet();
obj.insert(0);
obj.remove(0);
obj.insert(0);
console.log(obj.getRandom());
obj.remove(0);


console.log(obj.insert(0), "Expected: true");
//
// console.log(obj.insert(1));
// console.log(obj.remove(2));
// console.log(obj.insert(2));
// console.log(obj.getRandom());
// console.log(obj.remove(1));
// console.log(obj.insert(2));
// console.log(obj.getRandom());
