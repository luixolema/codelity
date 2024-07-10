

function Triangle(A: number[]) {
    const sizes: { length: number, index: number }[] =[];
    for (let i = 0; i < A.length; i++) {
        sizes.push({length: A[i], index: i});
    }

    const sortedSizes = sizes.sort((a, b) => a.length > b.length ? 1 : -1);
    for (let i = 2; i < sortedSizes.length; i++) {
        const side1 = sortedSizes[i - 2];
        const side2 = sortedSizes[i - 1];
        const side3 = sortedSizes[i];
        if (
            side1.length + side2.length > side3.length &&
            side2.length + side3.length > side1.length &&
            side3.length + side1.length > side2.length
        ) {
            // if I had to return the indexes stored in an array instead:
            // return [side1, side2, side3].map(e => e.index).sort();
            return 1;
        }
    }
    return 0;
}

function NumberOfDiscIntersections(A: number[]) {
    const points: { xCoordinates: number, start: boolean }[] = [];

    for (let i = 0; i < A.length; i++) {
        points.push({xCoordinates: i - A[i], start: true});
        points.push({xCoordinates: i + A[i], start: false});
    }

    const sortedPoints = points.sort(
        (a, b) => {
            if (a.xCoordinates === b.xCoordinates) {
                if (a.start){
                    return -1;
                }
                if (b.start){
                    return 1;
                }
            }
            return a.xCoordinates > b.xCoordinates ? 1 : -1

        });

    let interceptions = 0;
    let openedCircles = 0;
    for (const point of sortedPoints) {
        if (!point.start){
            openedCircles--;
        }
        if (point.start){
            interceptions += openedCircles;
            if (interceptions > 10000000){
                interceptions = -1;
                break;
            }
            openedCircles++;
        }
    }

    return interceptions;
}

console.log(NumberOfDiscIntersections([1,5,2,1,4,0]))