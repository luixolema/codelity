function Brackets(S: string) {
    const openingStack = [];

    function checkItCloses(openingCharacter: string | undefined, closingCharacter: string) {
        if (
            openingCharacter === '(' && closingCharacter === ')' ||
            openingCharacter === '{' && closingCharacter === '}' ||
            openingCharacter === '[' && closingCharacter === ']'
        ) {
            return true;
        }
        return false;
    }

    for (let i = 0; i < S.length; i++) {
        let character = S[i];
        if (
            character === '(' ||
            character === '{' ||
            character === '['
        ) {
            openingStack.push(character)
        } else {
            let openingCharacter = openingStack.pop();
            if (!checkItCloses(openingCharacter, character)) {
                return 0;
            }
        }
    }

    return openingStack.length === 0 ? 1 : 0;
}

console.log(Brackets('{[()()]}'));


function Fish(A: number[], B: number[]) {
    const goingUp = [];
    let survivors = 0;

    const GOING_UP = 1;
    const GOING_DOWN = 0;

    function fight(fishSize: number, contendersSizes: any[]): boolean {
        let finished = false;
        let fishSurvived = true;
        let contendersNotEaten = [];

        while (!finished) {
            const contender = contendersSizes[contendersSizes.length - 1];
            if (contender > fishSize) {
                fishSurvived = false;
                finished = true;
            } else if (contender < fishSize) {
                contendersSizes.pop();
            } else if (contender === fishSize) {
                contendersNotEaten.push(contendersSizes.pop());
            }

            if (contendersSizes.length === 0) {
                finished = true;
            }
        }

        contendersSizes.push(...contendersNotEaten);
        return fishSurvived;
    }

    for (let i = 0; i < B.length; i++) {
        if (B[i] === GOING_UP) {
            goingUp.push(A[i]);
        }

        if (B[i] === GOING_DOWN) {
            if (goingUp.length === 0) {
                survivors++;
            } else {
                if (fight(A[i], goingUp)) {
                    survivors++;
                }
            }
        }
    }

    survivors += goingUp.length;

    return survivors;
}

function Nesting(S: string) {
    return Brackets(S);
}

function StoneWall(H: number[]) {
    const previousPossibleCommonHeights: number[] = [];
    let amountOfStones = 0;


    function isPossibleToReuse(height: number, previousPossibleCommonHeights: number[]) {
        if (previousPossibleCommonHeights.length === 0) {
            return false;
        }

        while (previousPossibleCommonHeights.length) {
            const reusableHeight = previousPossibleCommonHeights[previousPossibleCommonHeights.length - 1];
            if (reusableHeight > height) {
                previousPossibleCommonHeights.pop();
            } else if (reusableHeight < height) {
                return false;
            } else if (reusableHeight === height) {
                return true;
            }
        }

        return false;
    }

    for (const height of H) {
        if (previousPossibleCommonHeights.length) {
            if (isPossibleToReuse(height, previousPossibleCommonHeights)) {
                continue;
            } else {
                amountOfStones++;
                previousPossibleCommonHeights.push(height);
            }
        }else{
            amountOfStones++;
            previousPossibleCommonHeights.push(height);
        }
    }

    return amountOfStones;
}

console.log(StoneWall([8, 8, 5, 7, 9, 8, 7, 4, 8]));

