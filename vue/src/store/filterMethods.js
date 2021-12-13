// A page of functions to sort through the list of breweries.

export function getByNoiseLevel(noiseLevel, list) {
    if(noiseLevel == 0) {
        return list
    }
    return list.filter(list => list.noise_rating == noiseLevel)
}

export function getByMoneyLevel(moneyLevel, list) {
    if(moneyLevel == 0) {
        return list
    }
    return list.filter(list => list.cost_rating == moneyLevel)
}

export function getByKeyword(keyword, list) {
    if (keyword == '') {
        return list
    } else
        return list.filter(obj => obj.city == keyword)
}

export function getById(id, list) {
    return list.find(obj => obj.bb_brewery_id == id);
}