function OddOccurrencesInArray(A =[]) {
    const occurrences = {};

    A.forEach(e=>{
        occurrences[e] = (occurrences[e] | 0) + 1;
    })

    return Object.keys(occurrences).find(key=>occurrences[key]===1);
}